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

/**Fichero Usa_Hebra.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * Uso de la clase Hebra con 4 hilos constantes.
 */
public class Usa_Hebra
{
	public static void main(String args[]) throws InterruptedException
	{
		Hebra hijo1 = new Hebra(10000,0);
		Hebra hijo2 = new Hebra(10000,0);
		Hebra hijo3 = new Hebra(10000,1);
		Hebra hijo4 = new Hebra(10000,1);

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
