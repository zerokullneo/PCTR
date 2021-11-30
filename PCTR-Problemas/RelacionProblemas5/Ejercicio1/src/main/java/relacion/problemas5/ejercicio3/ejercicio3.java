/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relacion.problemas5.ejercicio3;

import java.util.*;

class MonitorPrioridades
{
	int prioridadquesedebeliberar = 0, turno = 0;
	int[] procesosDePrioridad = new int[10];

	private int siguienteTurno()
	{
		int i = 0;
		if(prioridadquesedebeliberar > 0)
			while(procesosDePrioridad[i] == 0)
				i++;

		return i;
	}

	public synchronized void bloquear(int n)
	{
		procesosDePrioridad[n-1]++;
		
			try
			{
				procesosDePrioridad[n]++;
				System.out.println(Thread.currentThread().getName() 
				+ ", de prioridad " + n + " se bloquea. " 
				+ "En total hay " + prioridadquesedebeliberar 
				+ " hilos bloqeados (" + procesosDePrioridad[n] 
				+ " de prioridad " + n + ")");
				wait();
				
				while(turno != n)
					wait();
				
				prioridadquesedebeliberar--; procesosDePrioridad[n]--;
				System.out.println(Thread.currentThread().getName() 
				+ ", de prioridad " + n + " se desbloquea. " 
				+ "En total hay " + prioridadquesedebeliberar 
				+ " hilos bloqeados (" + procesosDePrioridad[n] 
				+ " de prioridad " + n + ")");

				if(procesosDePrioridad[n] == 0)
					desbloquear();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		
		procesosDePrioridad[n-1]--;
		if(procesosDePrioridad[n-1] == 0)
		{
			while(n < 10 && procesosDePrioridad[n] != 0)
				n++;
			if(n == 10)
				prioridadquesedebeliberar = 0;
			else
				prioridadquesedebeliberar = n;
		}
		notifyAll();
	}
	
	public synchronized void desbloquear()
	{
		turno = siguienteTurno();
        
		if(prioridadquesedebeliberar > 0)
		{
			System.out.println(Thread.currentThread().getName() 
				+ " libera a los hilos de prioridad " + turno);

			notifyAll();
		}
		else
		{
			System.out.println(Thread.currentThread().getName() 
				+ " efectura una llamada al método liberar, pero no hay "
				+ "ninguno bloqueado");
		}
	}
}

/**
 *
 * @author zerokullneo
 */
public class ejercicio3 extends Thread
{
	MonitorPrioridades m;
	static final int ITERACIONES = 10;
	
	public ejercicio3(MonitorPrioridades mn)
	{
		m = mn;
	}
	
	public void run()
	{
		Random r = new Random();
		for(;;)
		{
			try
			{
				Thread.sleep((long) (Math.random()*1000));
			}
			catch (InterruptedException ex)
			{
				ex.printStackTrace();
			}

			m.bloquear(r.nextInt(10));
		}
		//m.bloquear(1 + (int)(Math.random()*10));
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		MonitorPrioridades monitor = new MonitorPrioridades();
		ejercicio3[] hilos = new ejercicio3[5];

		for(int i=0 ; i < hilos.length ; i++)
		{
			hilos[i] = new ejercicio3(monitor);
			hilos[i].start();
		}
        
		for(;;)
		{
			Thread.sleep((long) (Math.random()*1000));
			monitor.desbloquear();
		}
		
		for(int i=0 ; i < hilos.length ; i++)
		{
			hilos[i].join();
		}
	}
}
