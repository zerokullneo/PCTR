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

/**Fichero lectorEscritor.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class lectorEscritor implements Runnable
{
	private static int n = 0;
	private static int opc;
	private static boolean e = false;

	/**
	 * Constructor de lectorEscritor con parametros.
	 * @param o Parametro que recoje la opcion a realizar por el buffer.
	 */
	public lectorEscritor(int o)
	{
		opc = o;
	}

	/**
	 * Metodo que bloquea la escritura mientras se esta leyendo.
	 */
	public synchronized void iLectura()
	{
		while(e)
		{
			try
			{
				wait();
			}
			catch(InterruptedException ex) 
			{
				ex.printStackTrace();
			}
		}
		n++;
		notifyAll();
	}

	/**
	 * Metodo que dosbloquea la lectura.
	 */
	public synchronized void fLectura()
	{
		n--;
		if (n == 0)
		{
			notifyAll();
		}
	}

	/**
	 * Metodo que bloquea la lectura mientras se esta escribiendo.
	 */
	public synchronized void iEscritura()
	{
		while (n != 0 || e)
		{
			try
			{
				wait();
			}
			catch(InterruptedException ex)
			{
				ex.printStackTrace();
			}
		}
		e = true;
	}

	/**
	 * Metodo que dosbloquea la escritura.
	 */
	public synchronized void fEscritura()
	{
		e = false;
		notifyAll();
	}

	/**
	 * Metodo run() que controla la exclusion mutua del estado de los
	 * buffers de Lectura y Escritura.
	 */
	@Override
	public void run()
	{
		switch (opc)
		{
			case 0:
				iLectura();
				System.out.println("Leyendo");
				fLectura();
				System.out.println("Fin lectura");
				break;
			case 1:
				iEscritura();
				System.err.println("Escribiendo");
				fEscritura();
				System.err.println("Fin escritura");
				break;
		}
	}
}
