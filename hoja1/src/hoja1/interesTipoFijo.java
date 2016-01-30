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

package hoja1;

import java.util.*;

/**Fichero interesTipoFijo.java 
  *@author Jose Manuel Barba Gonzalez
  *@version 1.0
  *Programacion Concurrente y de Tiempo Real
  *Area de CC. de la Computacion e I.A.
*/

/**Descripcion
 * 
 */
public class interesTipoFijo
{
     public static void main (String []args)	
     {	//caracter = TI.next().charAt(0);
		double tipo, cantidad, a;

		Scanner TI = new Scanner(System.in);

		do
		{
			System.out.println("Introducir valor Tipo Interes, min(0,5%)");
			tipo = TI.nextDouble();
		}while(tipo < 0.5);

		do
		{
			System.out.println("Cantidad a Prestar, min(100€):");
			cantidad = TI.nextDouble();
		}while(cantidad < 100);

		a = (cantidad + ((cantidad*tipo)/100))/6;
		System.out.println("Mensualidad: " + a);
	}
}
