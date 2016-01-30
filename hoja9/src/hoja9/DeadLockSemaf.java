/**
 * Copyright (C) 2015 Jose Manuel Barba Gonzalez <zk at wordpress.com>
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

package hoja9;

import java.util.concurrent.Semaphore;

/**Fichero DeadLockSemaf.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class DeadLockSemaf
{
     public static void main(String[] args)
     {
	final Semaphore region_A = new Semaphore(1);
	final Semaphore region_B = new Semaphore(1);

	Thread Hilo_A = new Thread(new Runnable()
	{
	     public void run()
	     {
		try
		{
		     region_A.acquire();
		}
		catch(InterruptedException e)
		{
		}

		for(int i=0; i<10000; i++);
		
		try
		{
		     region_B.acquire();
		}
		catch(InterruptedException e)
		{}
		System.out.println("hilo A");
		region_B.release();
		region_A.release();
	     }
	});

	Thread Hilo_B = new Thread(new Runnable()
	{
	     public void run()
	     {
		try
		{
		     region_B.acquire();
		}
		catch(InterruptedException e)
		{}

		for(int i=0; i<10000; i++);

		try
		{
		     region_A.acquire();
		}
		catch(InterruptedException e)
		{}

		System.out.println("hilo B");
		region_A.release();
		region_B.release();
	     }
	});

	Hilo_B.start();
	Hilo_A.start();
     }
}