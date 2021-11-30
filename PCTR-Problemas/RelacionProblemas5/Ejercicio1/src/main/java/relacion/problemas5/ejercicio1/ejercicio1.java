/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relacion.problemas5.ejercicio1;

import java.util.logging.Level;
import java.util.logging.Logger;

class Monitor
{
	int contador = 0;

	public synchronized void entrada()
	{
		contador++;
		if(contador < 3)
		{
			System.out.println(Thread.currentThread().getName() + " incrementa el contador a " 
				+ contador + " y se bloquea");
			try { wait(); } catch (InterruptedException ex) { ex.printStackTrace(); }
		}
		else
		{
			contador = 0;
			System.out.println(Thread.currentThread().getName() + " resetea el contador "
				+ "y desbloquea a los otros dos hilos");
			notifyAll();
		}
	}
}
/**
 *
 * @author zerokullneo
 */
public class ejercicio1 extends Thread
{
	Monitor m;

	public ejercicio1(Monitor mon)
	{
		m = mon;
	}

	public void run()
	{
		for(int i=0;i<100;i++)
		{
			m.entrada();
			try{ Thread.sleep(100); } catch(InterruptedException ex) { ex.printStackTrace();}
		}
	}

	public static void main(String[] args) throws InterruptedException
	{
		Monitor m = new Monitor();
		ejercicio1 h1 = new ejercicio1(m); h1.start();
		ejercicio1 h2 = new ejercicio1(m); h2.start();
		ejercicio1 h3 = new ejercicio1(m); h3.start();
		h1.join(); h2.join(); h3.join();
	}
}
