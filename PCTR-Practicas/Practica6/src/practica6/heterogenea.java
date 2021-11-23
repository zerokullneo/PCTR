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

import java.util.*;
import java.io.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

/**Fichero heterogenea.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * Clase que simula y muestra las diferencias entre sincronizar de forma atomica
 * o no tanto variables como metodos o secciones criticas.
 */
public class heterogenea implements Runnable
{
	/**
	 * Variable compartida de forma atomica.
	 */
	private static AtomicInteger n = new AtomicInteger(0);
	/**
	 * Variable compartida no atomica.
	 */
	private static int m;
	/**
	 * Variable que controla el numero de repeticiones/ejecuciones de los hilos.
	 */
	private static int nVueltas;

	/**
	 * Clase base que inicializa las variables necesarias.
	 * @param nlocal parametro que inicializa la variable n.
	 * @param mlocal parametro que inicializa la variable m.
	 * @param vueltas parametro que inicializa el numero de repeticiones.
	 */
	public heterogenea(AtomicInteger nlocal, int mlocal, int vueltas)
	{
		n = nlocal;
		m = mlocal;
		nVueltas = vueltas;
	}

	/**
	 * Metodo que incrementa la variable compartida n.
	 */
	public synchronized void incrementoSinc()
	{
		n.incrementAndGet();
	}

	/**
	 * Metodo que incrementa la variable compartida m.
	 */
	public void incrementoNoSinc()
	{
		m++;
	}

	/**
	 * Metodo observador de la variable compartida n.
	 * @return Devuelve la variable n.
	 */
	public synchronized AtomicInteger getN()
	{
		return n;
	}

	/**
	 * Metodo observador de la variable compartida m.
	 * @return Devuelve la variable m.
	 */
	public int getM()
	{
		return m;
	}

	/**
	 * Metodo run sobreescrito para realizar las repeticiones o ejecuciones
	 * indicadas en "nVueltas".
	 */
	public void run()
	{
		for(int it = 0; it < nVueltas; it++)
		{
			this.incrementoSinc();
			this.incrementoNoSinc();
		}
	}
}
