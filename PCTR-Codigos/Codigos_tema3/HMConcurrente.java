import java.lang.*;

public class HMConcurrente extends Thread
{
	public void run()
	{
		for(;;) System.out.println("Hola mundo concurrente... " + getName());
	}
	
	public static void main(String[] args)
	{
		HMConcurrente hilo1 = new HMConcurrente();
		HMConcurrente hilo2 = new HMConcurrente();
		HMConcurrente hilo3 = new HMConcurrente();
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
	}
}
