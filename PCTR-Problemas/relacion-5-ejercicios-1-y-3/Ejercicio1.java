class Monitor {
    int contador = 0;
    public synchronized void entrada() {
        contador++;
        if(contador < 3) {
            System.out.println(Thread.currentThread().getName()+" incrementa el contador a " 
                    + contador + " y se bloquea");
            try { wait(); } catch (InterruptedException ex) { ex.printStackTrace(); }
        } else {
            contador = 0;
            System.out.println(Thread.currentThread().getName()+" resetea el contador "
                    +"y desbloquea a los otros dos hilos");
            notifyAll();
        }
    }
}

public class Ejercicio1 extends Thread {
    Monitor m;

    public Ejercicio1(Monitor m) { this.m = m; }
    
    public void run(){
        for(int i=0;i<100;i++) {
            m.entrada();
            try{ Thread.sleep(100); } catch(InterruptedException ex) { ex.printStackTrace();}
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        Monitor m = new Monitor();
        Ejercicio1 h1 = new Ejercicio1(m); h1.start();
        Ejercicio1 h2 = new Ejercicio1(m); h2.start();
        Ejercicio1 h3 = new Ejercicio1(m); h3.start();
        h1.join(); h2.join(); h3.join();
    }
}
