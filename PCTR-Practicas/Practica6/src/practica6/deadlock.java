/**
 * Copyright (C) 2021 Jose Manuel Barba Gonzalez <zk at wordpress.com>
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

package practica6;

/**Fichero deadlock.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * Clase base para simular una situacion de deadlock con tres hilos.
 */
public class deadlock
{
	public static void main(String[] args)
	{
		final Object region_A = new Object();
		final Object region_B = new Object();
		final Object region_C = new Object();
		final int n = 0;

		Thread Hilo_C = new Thread(new Runnable()
		{
			public void run()
			{
				synchronized(region_C)
				{
					for(int j=0; j<100000;j++);
					synchronized(region_B)
					{
						System.out.println(n);
					}
				}
			}
		});

		/**
		 * Creacion en bruto de hilos 
		 */
		Thread Hilo_B = new Thread(new Runnable()
		{
			public void run()
			{
				synchronized(region_B)
				{
					for(int i=0; i<100000;i++);
					synchronized(region_A)
					{
						System.out.println(n);
					}
				}
			}
		});

		Thread Hilo_A = new Thread(new Runnable()
		{
			public void run()
			{
				synchronized(region_A)
				{
					for(int j=0; j<100000;j++);
					synchronized(region_B)
					{
						System.out.println(n);
					}
				}
			}
		});

		Hilo_C.start();
		Hilo_B.start();
		Hilo_A.start();
	}
}
