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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Fichero UsamonitorImpresion.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**
 * Descripcion
 * 
 */
public class UsamonitorImpresion implements Runnable
{
	private static int N;
	private static int tam;
	private static monitorImpresion mon;

	public UsamonitorImpresion()
	{
		N = 8;
		tam = 10;
		mon = new monitorImpresion(N);
	}

	public void run()
	{
		mon.ImpresoraA();
		mon.ImpresoraB();
		mon.ImpresoraC();
	}

	public static void main(String[] args)
	{
		ExecutorService ej = Executors.newFixedThreadPool(N);

		for(int i = 0; i < N; i++)
			ej.execute(new UsamonitorImpresion());

		ej.shutdown();
		while(!ej.isTerminated()){}
     }
}