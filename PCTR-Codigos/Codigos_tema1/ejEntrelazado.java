/**
 * @(#)ejEntrelazado.java
 * @author A.T.
 * @version 1.00 2012/7/10
 */

public class ejEntrelazado extends Thread {
	public static int nIter  = 20;
	public static int nHilos = 6;

    public ejEntrelazado() {}
    public void run()
    {
      for(int i=0; i<nIter;i++)
      	System.out.println("Hilo " + this.getName() + " imprimiendo iteracion numero " + i);
    }

    public static void main(String[] args)
    	throws InterruptedException
    {
        ejEntrelazado hilo = new ejEntrelazado();
       ejEntrelazado[] t = new ejEntrelazado[nHilos];
       for(int i=0; i<t.length; i++)
       	t[i] =new ejEntrelazado();
       	for(int i=0; i<t.length; i++)
       	t[i].start();
    }
}
