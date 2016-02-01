/**
 * @(#)MuestraBloqueo.java
 * @author AT
 * @version 1.00 2011/11/3
 */

public class MuestraBloqueo
  implements Runnable
 {
 	private Object o;

    public MuestraBloqueo(Object p)
    {o = p;}

    public void run()
    {
    	synchronized(o)
    	{
    	  for(int i=1;i<100;i++){
    	  	System.out.println("Iteracion "+i+" del hilo "+this.toString());
    	  	for(int j=1;j<100;j++);
    	  }
    	}
    }

    public static void main(String[] args)
    {
    	Object lock = new Object();
        Thread h1 = new Thread(new MuestraBloqueo(lock), "hilo 1");
        Thread h2 = new Thread(new MuestraBloqueo(lock), "hilo 2");
        h1.setPriority(Thread.MIN_PRIORITY);
        h2.setPriority(Thread.MAX_PRIORITY);
        h1.start();
        h2.start();
    }
}
