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

package hoja2;

/**Fichero Suma.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class Suma
{
     //private long a, b;
     
     /*public Suma(long parama, long paramb)
     {
	a = parama;
	b = paramb;
     }*/

     public int sumar(int x, int y)
     {
	return x + y;
     }

     public float sumar(float x, float y)
     {
	return x + y;
     }

     public double sumar(double x, double y)
     {
	return x + y;
     }

     public long sumar(long x, long y)
     {
	return x + y;
     }

     public static void main(String[] args)
     {
	Suma S = new Suma();
	int a = 3, b = 5;
	long i = 100, j = 1999;
	float o = 3.3f, p = 4.4f;
	double x = 5.5, y = 6.6;

	System.out.println("Entero: " + S.sumar(a,b));

	System.out.println("Entero: " + S.sumar(i,j));

	System.out.println("Entero: " + S.sumar(o,p));

	System.out.println("Entero: " + S.sumar(x,y));
     }
}
