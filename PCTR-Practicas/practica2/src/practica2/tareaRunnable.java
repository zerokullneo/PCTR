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

/**Fichero tareaRunnable.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * Implementa la clase tareaRunnable con los métodos específicos para realizar
 * las acciones indicadas en la variable "accion".
 */
public class tareaRunnable implements Runnable
{
	/**
	 * Variable de concurso.
	 */
	private static int n = 0;
	/**
	 * Variable que especifica la acción a realizar, incremento o decremento.
	 */
	private final String accion;
	/**
	 * Variable que especifica el número de vueltas del bucle.
	 */
	private static int loop = 10000000;

	/**
	 * Constructor de la clase con el parametro que indica la acción a realizar.
	 * @param acc variable que recoge la acción a realizar por el objeto.
	 */
	public tareaRunnable(String acc) { accion = acc; }

	/**
	 * Método que incrementa la variable de concurso.
	 */
	public void incremento(){n++;}

	/**
	 * Método que decrementa la variable de concurso.
	 */
	public void decremento(){n--;}

	/**
	 * Metodo observador para devolver el estado actual de la variable de concurso.
	 * @return devuelve un entero siendo la variable de concurso.
	 */
	public int getDato(){return(n);}

	/*public void run()
	{
		for(int i = 0; i < 100; i++)
		{
			switch(accion)
			{
				case "inc":
					this.incremento();
					break;
				case "dec":
					this.decremento();
					break;
				default:
			 break;
			}
		}
	}*/

	/**
	 * Método run sobreescrito para que un tipo de Hilo incremente la variable
	 * de concurso y otro tipo de Hilo la decremente.
	 */
	@Override
	public void run()
	{
		switch(accion)
		{
			case "inc":
				for(int i = 0; i < loop; i++)
					this.incremento();
				break;
			case "dec":
				for(int i = 0; i < loop; i++)
					this.decremento();
				break;
			 default:
				break;
	  }
    }
}
