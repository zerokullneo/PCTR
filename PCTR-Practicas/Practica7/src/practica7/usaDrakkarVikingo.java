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

/**Fichero usaDrakkarVikingo.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class usaDrakkarVikingo
{
	private static final int vikingos = 10; // num vikingos
	private static int marmi = 0;
	private static final int angui = 100; // num anguilas
     
	public static void main(String[] args) throws InterruptedException
	{
		marmi = angui;
		drakkarVikingo v[] = new drakkarVikingo[vikingos]; //creo un vector con los vikingos
		drakkarVikingo cocinero = new drakkarVikingo(1, marmi, angui); //creo un cocinero

		for(int i = 0; i < vikingos; i++)
		{
			v[i] = new drakkarVikingo(0, marmi, angui);
		}

		for (int i = 0; i < vikingos; i++)
		{
			v[i].start(); //lanzo los vikingos
		}

		cocinero.start(); //lanzo el cocinero
		
		for (int i = 0; i < vikingos; i++)
		{
			v[i].join(); //lanzo los vikingos
		}
		
		cocinero.join();
     }
}
