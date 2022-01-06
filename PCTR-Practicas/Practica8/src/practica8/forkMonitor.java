/*
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

package practica8;

import static java.lang.Thread.*;
import java.util.logging.*;

/**
 * Fichero forkMonitor.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 *
 *
 * Descripcion
 * Clase que simula las transacciones de un monitor teorico para la cena de 
 * filosofos.
 */
public class forkMonitor
{
	/**
	 * Atributo que recoge un array de tenedores disponibles o no.
	 */
	private static int []fork;

	/**
	 * Atributo que recoge el numero de filosofos a simular.
	 */
	private static int N;

	/**
	 * Constructor que inicializa los atributos de la clase.
	 * @param n Parametro que indica el numero de filosofos para inicializar
	 * el monitor.
	 */
	public forkMonitor(int n)
	{
		fork = new int[n];
		N = n;
	}

	/**
	 * Metodo que establece los tenedores o palillos como ocupados.
	 * @param i parametro que indica la posicion de array de tenedores que es ocupada.
	 */
	public synchronized void takeForks(int i)
	{
		try
		{
			System.out.println("Filosofo " + i + ", adquiere tenedores..." + Thread.currentThread().getName());
			//sleep(1000);
			fork[i] = 2;
			while(fork[i] != 2)
				wait();

			int masuno = ((i + 1) % N);
			int menuno = ((i - 1) % N);

			if(menuno == -1)
				menuno = menuno + N;

			//System.out.println("indices: " + masuno + ", " + menuno);
			fork[masuno] = fork[masuno] - 1;
			fork[menuno] = fork[menuno] - 1;
		}
		catch (InterruptedException ex)
		{
			Logger.getLogger(forkMonitor.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Metodo que establece los tenedores o palillos como libres.
	 * @param i parametro que indica la posicion de array de tenedores que es liberada.
	 */
	public synchronized void releaseForks(int i)
	{
		System.out.println("Filosofo " + i + ", libera tenedores..." + Thread.currentThread().getName());
		//sleep(1000);
		int masuno = ((i + 1) % N);
		int menuno = ((i - 1) % N);

		if(menuno == -1)
		   menuno = menuno + N;

		fork[masuno] = fork[masuno] + 1;
		fork[menuno] = fork[menuno] + 1;
		fork[i] = 0;

		/*while(fork[masuno] == 2)
			notifyAll();
		while(fork[menuno] == 2)*/
			notifyAll();
	}
}