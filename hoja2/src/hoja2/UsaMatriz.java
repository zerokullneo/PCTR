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

/**Fichero UsaMatriz.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class UsaMatriz
{
     public static void main(String[] args)
     {
	int n, m;
	double mx[];
	Matriz matriz;
	Scanner Pt = new Scanner(System.in);

	System.out.printf("Introducir el tamaño de la matriz: (n m)");
	n = Pt.nextInt();
	m = Pt.nextInt();
	mx = new double[n*m];
	System.out.printf("Introducir los " + n*m + " valores:");
	for(int i = 0; i < n*m; i++) mx[i] = Pt.nextDouble();

	matriz = new Matriz(n,m, mx);
	System.out.println("Tamaño de la matriz: " + matriz.mostrarN()  + ", " + matriz.mostrarM());
	matriz.mostrar_matriz();
     }
}
