/**
 * @(#)semaforo.java
 *
 *
 * @author Antonio Tomeu
 * @version 1.00 2009/4/16
 */


public class semaforo
{
	private  byte S;
	
	public void inicial (byte valor)
	{S = valor; return;}
	
	synchronized public void Wait() 
	{
		while (S == 0)
		  try{
		  	wait();
		     } catch (Exception e) {}
		S--;     
	}	
	
	synchronized public void Signal()
	{
		S++;
		notifyAll();
	}
}	
