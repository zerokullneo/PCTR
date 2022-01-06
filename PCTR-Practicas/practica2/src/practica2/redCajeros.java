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

/**Fichero Usa_Cajero.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * Clase que simula una red de cajeros operando simultaneamente.
 */
public class redCajeros
{
	public static void main(String args[]) throws InterruptedException
	{
		cuentaCorriente CB1 = new cuentaCorriente(1001, 200.50, "Juan García");
		cuentaCorriente CB2 = new cuentaCorriente(1002, 400.50, "Anna López");
	
		System.out.println(CB1.toString());
		System.out.println(CB2.toString());

		Cajero c1 = new Cajero(CB1, 1, 10, 100.0);
		Cajero c2 = new Cajero(CB2, 2, 10, 200.0);
		Cajero c3 = new Cajero(CB2, 2, 20, 80.0);
		Cajero c4 = new Cajero(CB1, 1, 20, 50.0);
	
		Thread C1 = new Thread(c1);
		Thread C2 = new Thread(c2);
		Thread C3 = new Thread(c3);
		Thread C4 = new Thread(c4);
		C1.start();
		C2.start();
		C3.start();
		C4.start();
		C1.join();
		C2.join();
		C3.join();
		C4.join();

		System.out.println(CB1.toString());
		System.out.println(CB2.toString());
	}
}
