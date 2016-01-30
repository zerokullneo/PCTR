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

import java.util.Scanner;

/**Fichero UsaPunto.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class UsaPunto
{
     public static void main(String[] args)
     {
	double x, y;
	Punto punto;
	Scanner Pt = new Scanner(System.in);

	System.out.printf("Introducir coordenadas: (x y)");
	x = Pt.nextDouble();
	y = Pt.nextDouble();
	
	punto = new Punto(x,y);
	System.out.println("Coordenadas en el plano: " + punto.mostrarX()  + ", " + punto.mostrarY());
     }
}
