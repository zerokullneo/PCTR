/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mi.monitorimpresoras;

import java.util.concurrent.locks.*;



/**
 *
 * @author zerokullneo
 */
public class monitorImpresoras extends Thread
{
	private int i, impresoras;
	private boolean[] libre;
	
	monitorImpresoras(int prints)
	{
		impresoras = prints;
	}
	
	public synchronized int take_print() throws InterruptedException
	{
		while(impresoras == 0)
			wait();
		
		int aux = 1;
		
		while(!libre[aux])
			aux++;
		
		libre[aux] = false;
		impresoras--;
		
		return aux;
	}
	
	public synchronized void drop_print(int n)
	{
		libre[n] = true;
		impresoras++;
		notifyAll();
	}
	
	public void run()
	{
		
	}
}
