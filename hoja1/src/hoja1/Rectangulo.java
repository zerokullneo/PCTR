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

/**Fichero Rectangulo.java 
  *@author Jose Manuel Barba Gonzalez
  *@version 1.0
  *Programacion Concurrente y de Tiempo Real
  *Area de CC. de la Computacion e I.A.
*/

/**Descripcion
 * 
 */
public class Rectangulo
{
     public static void main (String []args)
     {	//caracter = TI.next().charAt(0);
	int a, b, x, y;

	Scanner TI = new Scanner(System.in);

	do
	{
	     System.out.println("Cantidad de * en x min(10), cantidad de * en y min(3):");
	     a = TI.nextInt();
	     b = TI.nextInt();
	}while(a < 10 && b < 3);

	System.out.println("Dimensiones: " + a + ", " + b);
	for(x = 0; x < b; x++)
	{
	     for(y = 0; y < a; y++)
	     {
		if((x !=0 && x != b-1) && (y !=0 && y != a-1))
		     System.out.print(" ");
		else
		     System.out.print("*");
	     }
	     System.out.println();
	}
     }
}
