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

import java.lang.*;
import java.util.*;

/**Fichero arrSeguro.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * Clase que crea y modifica de forma segura un array.
 */
public class arrSeguro extends Thread
{
	/**
	 * Variable que controla el numero de modificaciones que se realiza
	 * en el vector.
	 */
	public static int nVueltas;
	/**
	 * Variable que controla la dimension del vector.
	 */
	public static int dimension;
	/**
	 * Variable Vector que usaran los diferentes hilos.
	 */
	public static Vector<Integer> vector;
	/**
	 * Variable Objeto que actua como cerrojo para la exclusion mutua.
	 */
	public static Object lock;

	/**
	 * Constructor base de la clase
	 * @param nV numero de accesos o modificaciones a realizar.
	 * @param dim dimension del Vector.
	 */
	public arrSeguro(int nV, int dim)
	{
		nVueltas = nV;
		dimension = dim;
		vector = new Vector<Integer>(dimension);
		lock = new Object();
	}

	/**
	 * Metodo observador que visualiza el vector.
	 */
	public void getVector()
	{
		System.out.println(vector);
	}

	/**
	 * Metodo run sobreescrito para exclusion mutua con synchronized.
	 */
	@Override
	public void run()
	{
		synchronized(lock)
		{
			for(int it = 0; it < nVueltas; it++)
				for(int itv = 0; itv < dimension; itv++)
				{
					vector.add(itv);
				}
		}
	}

	public static void main(String[] args) throws Exception
	{
		int nV = 1000;
		int dim = 20;
		
		arrSeguro arrA = new arrSeguro(nV, dim);
		arrSeguro arrB = new arrSeguro(nV, dim);
		
		arrA.start();
		arrB.start();
		
		arrA.join();
		arrB.join();
		
		arrA.getVector();
	}
}
