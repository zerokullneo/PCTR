/**
 * @(#)UsaBarreras.java
 *
 *
 * @author Antonio Tomeu
 * @version 1.00 2011/5/17
 */

import java.util.concurrent.*;
       
   
   class Hilo extends Thread
   {
   	CyclicBarrier barrera = null;
   	
   	public Hilo (CyclicBarrier bar)
   	{barrera = bar;}
   	
   	public void run()
   	{
   		try {int i = barrera.await();}
   		  catch (BrokenBarrierException e) {}
   		    catch (InterruptedException e) {}
   		System.out.println("El hilo "+this.toString()+" paso la barrera...");
   	}
   }
   
   public class UsaBarreras {
    public static void main(String[] args) 
    {
    	int numHilos = 3;
        CyclicBarrier PasoANivel = new CyclicBarrier (numHilos);
        new Hilo(PasoANivel).start();
    }
}
