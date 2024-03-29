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

/**Fichero Usa_Cajero.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class Usa_Cajero
{
     public static void main(String args[]) throws InterruptedException
     {
	Cuenta_Banca CB1 = new Cuenta_Banca(1001,200.50,"Juan");
	Cuenta_Banca CB2 = new Cuenta_Banca(1002,400.50,"Anna");
	
	System.out.println(CB1.toString());
	System.out.println(CB2.toString());

	Cajero c1 = new Cajero(CB1,1, 10, 100.0);
	Cajero c2 = new Cajero(CB2,2, 10, 200.0);
		
	Thread C1 = new Thread(c1);
	Thread C2 = new Thread(c2);
	C1.start();
	C2.start();
	C1.join();
	C2.join();

	System.out.println(CB1.toString());
	System.out.println(CB2.toString());
     }
}
