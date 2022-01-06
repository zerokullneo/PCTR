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

import java.util.concurrent.*;

/**Fichero usaLectorEscritor.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class usaLectorEscritor
{
	private static final int N = 100000;
     
	//private static lectorEscritor le = new lectorEscritor();
	public static void main(String[] args)
	{
		ExecutorService ept = Executors.newFixedThreadPool(N);

		for (int i = 0; i < N; i++)
		{
			if (i % 2 == 0)
				ept.execute(new lectorEscritor(1));
			else
				ept.execute(new lectorEscritor(0));
		}
		ept.shutdown();
		while(!ept.isTerminated()){}
	}
}
