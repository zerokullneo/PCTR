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
package practica7;

import java.util.*;

/**Fichero usaProdCon.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class usaProdCon extends Thread
{
	PCMonitor monitor;
	static final int ITERACIONES = 2000;

	usaProdCon(PCMonitor m)
	{
		monitor = m;
	}

	public void run()
	{
		int temp = 0;
		for(; ; )
		{
			if (temp == 0)
			{
				System.out.println(temp + " - Produciendo...");
				monitor.Append(monitor.N);
			}
			System.out.println(temp + " - Consumiendo...");
			temp = monitor.Take();
		}
	}

	public static void main(String[] args) throws InterruptedException
	{
		int nucleos = Runtime.getRuntime().availableProcessors();
		int nHilosProductores = nucleos/2;
		int nHilosConsumidores = nucleos/2;
		Scanner nBuffer;
		int dimension;
		System.out.println("Introducir la dimension del Buffer:");
		nBuffer = new Scanner(System.in);
		dimension = nBuffer.nextInt();

		PCMonitor prodcon = new PCMonitor(dimension);
		usaProdCon[] hilosProd = new usaProdCon[nHilosProductores];
		usaProdCon[] hilosCons = new usaProdCon[nHilosConsumidores];
		
		for(int i=0 ; i < hilosProd.length ; i++)
		{
			hilosProd[i] = new usaProdCon(prodcon);
			hilosProd[i].start();
		}

		for(int j=0 ; j < hilosCons.length ; j++)
		{
			hilosCons[j] = new usaProdCon(prodcon);
			hilosCons[j].start();
		}
		
		for(int ij=0 ; ij < hilosCons.length || ij < hilosProd.length ; ij++)
		{
			hilosProd[ij].join();
			hilosCons[ij].join();
		}
	}
}
