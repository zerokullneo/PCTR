import java.util.Random;

class MonitorP {
    int totalBloqueados = 0, turno = 0;
    int[] bloqueados = new int[10];
    
    private int siguienteTurno() {
        int i = 0;
        if(totalBloqueados > 0) {
            while(bloqueados[i] == 0) {
                i++;
            }
        }
        return i;
    }
    
    public synchronized void bloquear(int n) {
        try {
            totalBloqueados++; bloqueados[n]++;
            System.out.println(Thread.currentThread().getName() 
                    + ", de prioridad " + n + " se bloquea. " 
                    + "En total hay " + totalBloqueados 
                    + " hilos bloqeados (" + bloqueados[n] 
                    + " de prioridad " + n + ")");
            wait();
            
            while(turno != n) {
                wait();
            }
            totalBloqueados--; bloqueados[n]--;
            System.out.println(Thread.currentThread().getName() 
                    + ", de prioridad " + n + " se desbloquea. " 
                    + "En total hay " + totalBloqueados 
                    + " hilos bloqeados (" + bloqueados[n] 
                    + " de prioridad " + n + ")");
            
            if(bloqueados[n] == 0) {
                liberar();
            }
            
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    public synchronized void liberar() {
        turno = siguienteTurno();
        
        if(totalBloqueados > 0){
            System.out.println(Thread.currentThread().getName() 
                    + " libera a los hilos de prioridad " + turno);

            notifyAll();
        } else {
            System.out.println(Thread.currentThread().getName() 
                    + " efectura una llamada al método liberar, pero no hay "
                    + "ninguno bloqueado");
        }
    }
}

public class Ejercicio3 extends Thread {
    MonitorP monitor;
    static final int ITERACIONES = 10;

    public Ejercicio3(MonitorP monitor) {
        this.monitor = monitor;
    }
    
    public void run() {
        Random r = new Random();
        for(;;) {
            try {
                Thread.sleep((long) (Math.random()*1000));
            } catch (InterruptedException ex) { ex.printStackTrace(); }
            monitor.bloquear(r.nextInt(10));
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        MonitorP monitor = new MonitorP();
        Ejercicio3[] hilos = new Ejercicio3[5];
        for(int i=0 ; i<hilos.length ; i++) {
            hilos[i] = new Ejercicio3(monitor);
            hilos[i].start();
        }
        
        for(;;) {
            Thread.sleep((long) (Math.random()*1000));
            monitor.liberar();
        }
    }
}
