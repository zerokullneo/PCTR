/* Fichero deadlocksem.java
  *@author Jose Manuel Barba Gonzalez
  *@version 1.0
  *Programacion Concurrente y de Tiempo Real
  *Area de CC. de la Computacion e I.A.
*/

import java.util.concurrent.*;

public class deadlocksem extends Thread
{
	private int tipoHilo;
	private static int nVueltas = 1000000;
	private static int n = 0;
	private static Semaphore s = new Semaphore(1);

	public emSem(int tipoHilo){tipoHilo = tipoHilo;}
	
	public void run()
	{
		
	}
	
	public static void main(String[] args)
	throws InterruptedException
	{
		emSem h1 = new emSem(1);
		emSem h2 = new emSem(2);
		h1.start(); h2.start();
		h1.join(); h2.join();
		System.out.println(n);
	}
}
