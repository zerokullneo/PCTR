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

/* Fichero raizporBiseccion.java 
  *@author Jose Manuel Barba Gonzalez
  *@version 1.0
  *Programacion Concurrente y de Tiempo Real
  *Area de CC. de la Computacion e I.A.
*/

/**Descripcion
 * 
 */
public class raizporBiseccion
{
	private int a,b;
	
	public raizporBiseccion(int pa, int pb)
	{
		a = pa;
		b = pb;
	}

	//a+b/2
	
	public static void main (String []args)
	{
		raizporBiseccion F1;//cos(x) - x^3 = 0
		raizporBiseccion F2;//x^2 - 5 = 0
		int a1=0, a2=2, b1=1, b2=3;
		double x;

		Scanner TI = new Scanner(System.in);

		F1 = new raizporBiseccion(a1,b1);
		F2 = new raizporBiseccion(a2,b2);

		System.out.println("cuadrado de 5: " + Math.sqrt(5));
		System.out.println("cubica de 1: " + Math.cbrt(Math.cos(1)));
	}
}
