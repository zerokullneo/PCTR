/**
 * Copyright (C) 2021 Jose Manuel Barba Gonzalez <zk at wordpress.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package practica8;

/**
 * Fichero monitorImpresion.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 *
 *
 * Descripcion
 * Clase que simula las transacciones de un monitor teorico para la impresion
 * de varios documentos simultaneamente.
 */
public class monitorImpresion
{
	/**
	 * Atributo de numero de ranuras del que dispone el array "libres".
	 */
	private int numSlots;

	/**
	 * Atributo que declara el numero de impresoras del sisitema en el monitor.
	 */
	private final int impresoras;

	/**
	 * Atributo array de Slots o espacios disponibles de cada impresora
	 * true = libre; false = ocupada.
	 */
	public boolean [] libres;

	/**
	 * Atributo contador de documentos en impresion.
	 */
	private int cont;

	/**
	 * Constructor que inicializa los atributos de la clase.
	 * @param nslots Parametro que inicia la cantidad de ranuras disponibles.
	 */
	public monitorImpresion(int nslots)
	{
		impresoras = nslots;
		cont = 0;
		numSlots = nslots;
		libres = new boolean[numSlots];
		for(int i = 0; i < numSlots; ++i)
			libres[i] = true;
	}

	/**
	 * Metodo que establece la impresora solicitada como ocupada.
	 * @return devuelve el numero o contador de impresora utilizado.
	 */
	public synchronized int take_print()
	{
		boolean valor;
		while(cont == numSlots)
		try
		{
			wait();
		}
		catch(InterruptedException e)
		{
			System.out.println("ERROR Insertar..." + e.getMessage() + " - " + e.getLocalizedMessage());
		}

		valor = libres[cont];
		if(valor)
			cont++;

		notifyAll();

		return cont;
	}

	/**
	 * Metodo que establece la impresora solicitada como libre.
	 * @param i Parametro que establece como libre el numero o contador
	 * de impresora utilizado.
	 */
	public synchronized void drop_print(int i)
	{
		while (cont == 0)
		try
		{
			wait();
		}
		catch(InterruptedException e)
		{
			System.out.println("ERROR Extraer..." + e.getMessage() + " - " + e.getLocalizedMessage());
		}

		libres[i] = true;

		cont--;

		notifyAll();
	}

	/**
	 * Metodo que permite hacer uso de la primera impresora, adquiriendo
	 * y liberando los recursos mediante los metodos take_print y drop_print.
	 */
	public synchronized void ImpresoraA()
	{
		if(libres[0])
		{
			numSlots = take_print();
			System.out.println("Imprimiendo Impresora A...");
		}
		drop_print(0);
	}

	/**
	 * Metodo que permite hacer uso de la segunda impresora, adquiriendo
	 * y liberando los recursos mediante los metodos take_print y drop_print.
	 */
	public synchronized void ImpresoraB()
	{
		if(libres[1])
		{
			numSlots = take_print();
			System.out.println("Imprimiendo Impresora B...");
		}
		drop_print(1);
	}

	/**
	 * Metodo que permite hacer uso de la tercera impresora, adquiriendo
	 * y liberando los recursos mediante los metodos take_print y drop_print.
	 */
	public synchronized void ImpresoraC()
	{
		if(libres[2])
		{
			numSlots = take_print();
			System.out.println("Imprimiendo Impresora C...");
		}
		drop_print(2);
	}
}