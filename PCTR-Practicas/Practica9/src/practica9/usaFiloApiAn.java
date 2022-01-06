/*
 * Copyright (C) 2021 Jose Manuel Barba Gonzalez <administrador at elyinyang.com>
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

package practica9;

import java.util.concurrent.*;

/**
 * Fichero usaFiloApiAn.java
 * @author Jose Manuel Barba Gonzalez <administrador at elyinyang.com>
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */
 /**
 * Descripcion
 * Clase que hace uso del monitor cena de los filosofos.
 */
public class usaFiloApiAn implements Runnable
{
	/**
	 * Atributo que crea el objeto del monitor.
	 */
	static filoApiAN mesa;
	/**
	 * Atributo filosofo inicial.
	 */
	int i;

	/**
	 * Constructor base de la clase.
	 * @param i parametro que indica el filosofo que pretende comenzar la cena.
	 */
	usaFiloApiAn(int i)
	{
		this.i = i;
		mesa = new filoApiAN();
	}

	/**
	 * Metodo run sobrecargado.
	 */
	@Override
	public void run()
	{
		try
		{
			mesa.EmpezarComer(i);
			System.out.println("Filosofo " + (i + 1) + " comiendo...");
			mesa.DejarComer(i);
			System.out.println("Filosofo " + (i + 1) + " ha terminado.");
		}
		catch(InterruptedException e)
		{
			System.out.println("ERROR ejecucion filosofos..." + e);
		}
	}

	public static void main(String[] args)
	{
		usaFiloApiAn[] filosofos = new usaFiloApiAn[5];
		ExecutorService ejecutor = Executors.newFixedThreadPool(5);

		for(int i = 0; i < filosofos.length; i++)
		{
			filosofos[i] = new usaFiloApiAn(i);
			ejecutor.execute(filosofos[i]);
		}

		ejecutor.shutdown();
		while(!ejecutor.isTerminated()){}
	}
}
