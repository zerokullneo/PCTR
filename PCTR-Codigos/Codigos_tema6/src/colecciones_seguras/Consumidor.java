/**
 * @(#)Consumidor.java
 * @author Antonio Tomeu
 * @version 1.00 2011/5/26
 */


import java.util.concurrent.*;

public class Consumidor
  implements Runnable
{

  LinkedBlockingQueue<Integer> data;
  Thread hilo;

  public Consumidor(LinkedBlockingQueue<Integer> l)
   {
   	  this.data = l;
   	  hilo = new Thread (this);
   	  hilo.start();
   }

  public void run()
  {
  	try {
  		for(;;)
  	      System.out.println("Extrayendo "+data.take().intValue());
  		}
  	    catch(InterruptedException e){}
  }
}