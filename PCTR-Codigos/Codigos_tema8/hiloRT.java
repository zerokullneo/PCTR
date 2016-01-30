import javax.realtime.*;
public class hiloRT {

    class tarea implements Runnable {
        public void run() {
            System.out.println("Tarea en ejecucion");
            Exception e1 = new Exception();
            e1.printStackTrace();
        }
    }
    
    public hiloRT() {
        tarea t = new tarea();
        RealtimeThread rtt = new RealtimeThread(null,null,null,null,null,t);
        rtt.start();
    }
    
    public static void main(String[] args) {
        tarea m = new hiloRT();
    }

}
