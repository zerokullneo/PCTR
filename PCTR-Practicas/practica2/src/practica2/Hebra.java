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

/**Fichero Hebra.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * Clase que representa la implementación de Threads básicos.
 */
public class Hebra extends Thread
{
	/**
	 * Variable que selecciona el tipo de tarea a realizar, incremento o decremento.
	 */
	private final int tipoHilo;
	/**
	 * Variable de concurso.
	 */
	private static int n = 0;
	/**
	 * Variable que define el número de iteraciones a realizar.
	 */
	private final int nVueltas; 

	/**
	 * Constructor especificando los parametros de Hilo.
	 * @param nVueltas Numero de vueltas que da cada hilo creado.
	 * @param tipoHilo Determina si el hilo suma a la variable "n",
	 * tipo 0, o si el hilo resta a la variable "n", tipo 1.
	 */
	public Hebra(int nVueltas, int tipoHilo) 
	{
		this.nVueltas = nVueltas;
		this.tipoHilo = tipoHilo;
	} 

	/**
	 * Metodo que modifica la variable de concurso dependiendo de la variable
	 * tipoHilo.
	 */
	public void run() 
	{ 
		switch(tipoHilo)
		{ 
			case 0: for(int i = 0; i < nVueltas; i++) n++; break; 
			case 1: for(int i = 0; i < nVueltas; i++) n--; break; 
		}
	} 

	/**
	 * Metodo para visualizar la variable de concurso modificada.
	 * @return Devuelve el valor de "n" modificado por el metodo run().
	 */
	public static int LeeConcurso(){return n;}
}
