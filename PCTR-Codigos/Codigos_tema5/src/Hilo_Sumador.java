/**
 * @(#)Hilo_Sumador.java
 * @author A.T.
 * @version 1.00 2009/12/1
 */


class HiloSumador
	extends Thread
{	
	private Monitor Data;
	public HiloSumador(Monitor Ref){Data=Ref;}
	public void run()
	{
		for(;;)Data.INC();
	}	
}

