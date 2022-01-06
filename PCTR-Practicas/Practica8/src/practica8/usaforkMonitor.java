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

package practica8;

import static java.lang.Thread.*;
import java.util.concurrent.*;
import java.util.logging.*;

/**
 * Fichero usaforkMonitor.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 *
 *
 * Descripcion
 * Clase que hace uso mediante la interfaz Runnable de la clase forkMonitor
 * de la cena de los filosofos.
 */
public class usaforkMonitor implements Runnable
{
	/**
	 * Atributo que indica el numero de filosofos y tenedores disponibles.
	 */
	private static int N;

	/**
	 * Atributo para crear el tipo forkMonitor.
	 */
	private static forkMonitor mon;

	/**
	 * Constructor que inicializa los atributos de la clase.
	 */
	public usaforkMonitor()
	{
		N = 5;
		mon = new forkMonitor(N);
	}

	/**
	 * Metodo run sobreescrito para que simule la interaccion de los filosofos
	 * con los tenedores.
	 */
	public synchronized void run()
	{
		int i;
		while(true)
		{
			try
			{
				for(i = 0; i < N; i++)
				{
					mon.takeForks(i);
					mon.releaseForks(i);
					sleep(1000);
					//se incluye una pausa con el único motivo
					//de visualizar cómodamente la salida
				}
			}
			catch (InterruptedException ex)
			{
				Logger.getLogger(usaforkMonitor.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	/**
	 * Metodo principal de la clase.
	 * @param args argumentos de la entrada estandar.
	 */
	public static void main(String[] args)
	{
		int Nf = 5;
		ExecutorService ej = Executors.newFixedThreadPool(Nf);

		for(int i = 0; i < Nf; i++)
			ej.execute(new usaforkMonitor());

		ej.shutdown();
		while(!ej.isTerminated()){}
	}
}
