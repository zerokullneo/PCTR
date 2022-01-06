/*
 * Copyright (C) 2021 Jose Manuel Barba Gonzalez <administrador at elyinyang.com>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package practica9;

import static java.lang.Thread.sleep;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Fichero tiempos.java
 * @author Jose Manuel Barba Gonzalez <administrador at elyinyang.com>
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */
 /**
 * Descripcion
 * Clase que realiza la exclusion mutua mediante diferentes tecnicas y toma tiempos.
 */
public class tiempos
{
	/**
	 * Atributo tipo Object para controlar la exclusion mutua del metodo tiempoSynchronized.
	 */
	private static Object lock;
	/**
	 * Atributo tipo Object para controlar la exclusion mutua del metodo tiempoSemaphore.
	 */
	private Semaphore semaforo;
	/**
	 * Atributo tipo Object para controlar la exclusion mutua del metodo tiempoReentrant.
	 */
	private ReentrantLock bloqueo;
	/**
	 * Atributo tipo Object para controlar la exclusion mutua del metodo tiempoAtomic.
	 */
	private AtomicInteger entero;

	/**
	 * Atributos de inicio y final del tiempo registrado.
	 */
	private long ini, fin;
	/**
	 * Atributo incremental para las iteraciones.
	 */
	private int n;

	/**
	 * Constructor base de la clase.
	 */
	public tiempos()
	{
		ini = 0;
		fin = 0;
		n = 0;
		lock = new Object();
		semaforo = new Semaphore(1);
		bloqueo = new ReentrantLock();
		entero = new AtomicInteger(0);
	}

	/**
	 * Metodo que realiza la tarea de exclusion por la tecnica synchronized.
	 * @param iter parametro que indica la cantidad de incrementos de n.
	 * @return devuelve el tiempo empleado en incrementar n.
	 */
	public long tiempoSynchronized(long iter)
	{
		ini = System.nanoTime();
		synchronized(lock)
		{
			for(long i = 0; i < iter; i++)
				n++; //seccion critica
		}
		fin = System.nanoTime();
		return(fin-ini);
	}

	/**
	 * Metodo que realiza la tarea de exclusion por la tecnica Semaphore.
	 * @param iter parametro que indica la cantidad de incrementos de n.
	 * @return devuelve el tiempo empleado en incrementar n.
	 */
	public long tiempoSemaphore(long iter)
	{
		ini = System.nanoTime();
		try
		{
			semaforo.acquire();
			for(long i = 0; i < iter; i++)
				n++; //seccion critica
		}
		catch(InterruptedException ex)
		{
			System.out.println("Error Semaforo: " + ex.getMessage());
		}
		finally
		{
			semaforo.release();
		}

		fin = System.nanoTime();
		return(fin-ini);
	}

	/**
	 * Metodo que realiza la tarea de exclusion por la tecnica ReentrantLock.
	 * @param iter parametro que indica la cantidad de incrementos de n.
	 * @return devuelve el tiempo empleado en incrementar n.
	 */
	public long tiempoReentrant(long iter)
	{
		ini = System.nanoTime();
		bloqueo.lock();
		for(long i = 0; i < iter; i++)
			n++; //seccion critica
			
		bloqueo.unlock();

		fin = System.nanoTime();
		return(fin-ini);
	}

	/**
	 * Metodo que realiza la tarea de exclusion por la tecnica AtomicInteger.
	 * @param iter parametro que indica la cantidad de incrementos de n.
	 * @return devuelve el tiempo empleado en incrementar n.
	 */
	public long tiempoAtomic(long iter)
	{
		ini = System.nanoTime();
		
		for(long i = 0; i < iter; i++)
			entero.getAndAdd(n);
			//n++; //seccion critica

		fin = System.nanoTime();
		return(fin-ini);
	}

	public static void main(String[] args) throws InterruptedException
	{
		Scanner cin;
		int iteraciones;
		tiempos tms = new tiempos();
		
		System.out.println("Introducir el numero de iteraciones:");
		cin = new Scanner(System.in);
		iteraciones = cin.nextInt();

		System.out.println("Synchronized Tiempo(milisegundos): " + (double)tms.tiempoSynchronized(iteraciones)/1000000);
		sleep(500);
		System.out.println("Semaphore Tiempo(milisegundos): " + (double)tms.tiempoSemaphore(iteraciones)/1000000);
		sleep(500);
		System.out.println("ReentrantLock Tiempo(milisegundos): " + (double)tms.tiempoReentrant(iteraciones)/1000000);
		sleep(500);
		System.out.println("Atomic Tiempo(milisegundos): " + (double)tms.tiempoAtomic(iteraciones)/1000000);
	}
}
