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

package practica2;

import java.util.concurrent.atomic.*;

/**Fichero hebraLambda.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * Clase que simula una función Lambda de forma paralela.
 */
public class hebraLambda
{
	/**
	 * Variable de concurso a modificar.
	 */
	private static int contador = 0;
	/**
	 * Limite del Hilo Incremental.
	 */
	private static AtomicInteger limiteI = new AtomicInteger(500000);
	/**
	 * Límite del Hilo Decremental.
	 */
	private static AtomicInteger limiteH = new AtomicInteger(1000000);

	public static void main (String[] args) throws Exception
	{
		Thread []hebra = new Thread[limiteH.get()];
		Thread []thread = new Thread[limiteI.get()];

		Runnable runnablePush = () -> {
			String nombre = Thread.currentThread().getName();
			System.out.println("Trabajando Hebra " + nombre);
			contador++;
		};

		Runnable runnablePoop = () -> {
			String nombre = Thread.currentThread().getName();
			System.out.println("Trabajando Hebra " + nombre);
			contador--;
		};

		for(int h = 0; h < limiteI.get(); h++)
			thread[h] = new Thread(runnablePush);

		for(int i = 0; i < limiteH.get(); i++)
			hebra[i] = new Thread(runnablePoop);

		for(int i = 0; i < limiteH.get(); i++)
		{
			hebra[i].start();
			hebra[i].join();
		}

		for(int h = 0; h < limiteI.get(); h++)
		{
			thread[h].start();
			thread[h].join();
		}

		System.out.println("Finalizando... Total: " + contador);
	}
}
