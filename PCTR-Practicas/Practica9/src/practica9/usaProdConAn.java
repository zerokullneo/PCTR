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
package practica9;

import java.util.*;

/**Fichero usaProdCon.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**
 * Descripcion
 * Clase que hace uso del monitor Productor-Consumidor.
 */
public class usaProdConAn extends Thread
{
	/**
	 * Atributo que crea el objeto del monitor.
	 */
	prodConAN monitor;

	static final int ITERACIONES = 2000;

	/**
	 * Constructor base de la clase.
	 * @param m parametro de tipo monitor Productor-Consumidor.
	 */
	usaProdConAn(prodConAN m)
	{
		monitor = m;
	}

	/**
	 * Metodo run sobrecargado.
	 */
	@Override
	public void run()
	{
		while(true)
		{
			if (monitor.Count <= 0)
			{
				System.out.println(monitor.Count + " - Produciendo...");
				monitor.Append(1);
			}
			else
			{
				System.out.println(monitor.Count + " - Consumiendo...");
				monitor.Take();
			}
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

		prodConAN prodcon = new prodConAN(dimension);
		usaProdConAn[] hilosProd = new usaProdConAn[nHilosProductores];
		usaProdConAn[] hilosCons = new usaProdConAn[nHilosConsumidores];
		
		for(int i=0 ; i < hilosProd.length ; i++)
		{
			hilosProd[i] = new usaProdConAn(prodcon);
			hilosProd[i].start();
		}

		for(int j=0 ; j < hilosCons.length ; j++)
		{
			hilosCons[j] = new usaProdConAn(prodcon);
			hilosCons[j].start();
		}
		
		for(int ij=0 ; ij < hilosCons.length || ij < hilosProd.length ; ij++)
		{
			hilosProd[ij].join();
			hilosCons[ij].join();
		}
	}
}