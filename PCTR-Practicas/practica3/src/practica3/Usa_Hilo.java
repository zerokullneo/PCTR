/**
 * Copyright (C) 2015 Jose Manuel Barba Gonzalez <zk at wordpress.com>
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

package practica3;

/**Fichero Usa_Hilo.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class Usa_Hilo
{
     public static void main(String args[]) throws InterruptedException
     {
	Hilo hijo1 = new Hilo(10000,0);
	Hilo hijo2 = new Hilo(10000,0);
	Hilo hijo3 = new Hilo(10000,1);
	Hilo hijo4 = new Hilo(10000,1);

	hijo1.start();
	hijo2.start();
	hijo3.start();
	hijo4.start();

	System.out.println("Hilo1:" + hijo1.LeeConcurso());
	System.out.println("Hilo2:" + hijo2.LeeConcurso());
	System.out.println("Hilo3:" + hijo3.LeeConcurso());
	System.out.println("Hilo4:" + hijo4.LeeConcurso());
     }
}
