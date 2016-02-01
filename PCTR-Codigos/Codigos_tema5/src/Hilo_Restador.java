/**
 * @(#)Hilo_Restador.java
 * @author A.T.
 * @version 1.00 2009/12/1
 */

class HiloRestador
	extends Thread
{	
	private Monitor Data;
	public HiloRestador(Monitor Ref){Data=Ref;}
	public void run()
	{
		for(;;)Data.DEC();
	}	
}