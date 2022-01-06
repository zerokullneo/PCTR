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
 *
 *
 * Descripcion
 * Clase que hace uso mediante la interfaz Runnable de la clase monitorImpresion.
 */
public class UsamonitorImpresion implements Runnable
{
	/**
	 * Atributo que simula un numero de documentos a imprimir.
	 */
	private static int N;

	/**
	 * Atributo que indica el tamaño que va a tener el buffer de ranuras "libres".
	 */
	private static int tam;

	/**
	 * Atributo para crear el tipo monitorImpresion.
	 */
	private static monitorImpresion mon;

	/**
	 * Constructor que inicializa los atributos de la clase.
	 */
	public UsamonitorImpresion()
	{
		N = 9;
		tam = 3;
		mon = new monitorImpresion(tam);
	}

	/**
	 * Metodo run sobreescrito para que simule la impresion con los metodos
	 * de impresion.
	 */
	public void run()
	{
		int i;
		//while(true)
		//{
			for(i = 0; i < N; i++)
			{
				mon.ImpresoraA();
				mon.ImpresoraB();
				mon.ImpresoraC();
			}
		//}
	}

	/**
	 * Metodo principal de la clase.
	 * @param args argumentos de la entrada estandar.
	 */
	public static void main(String[] args)
	{
		int nf = 9;
		ExecutorService ej = Executors.newFixedThreadPool(nf);

		for(int i = 0; i < nf; i++)
			ej.execute(new UsamonitorImpresion());

		ej.shutdown();
		while(!ej.isTerminated()){}
	}
}