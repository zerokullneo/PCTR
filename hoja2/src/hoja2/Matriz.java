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

/**Fichero Matriz.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class Matriz
{
     private int n;
     private int m;
     private double matrix[][];

     /**
      * Constructor vacío de Matriz.
      */
     public Matriz()
     {
	n = 1;
	m = 1;
	matrix = new double[n][m];
	matrix[0][0] = 0.0;
     }

     /**
      * Constructor especificando los parametros de Matriz.
      * @param i
      * @param j 
      */
     public Matriz(int i, int j, double mx[])
     {
	n = i;
	m = j;
	matrix = new double[n][m];

	int z = 0;
	for(int x = 0; x < n; x++)
	     for(int y = 0; y < m; y++, z++)
		matrix[x][y] = mx[z];
     }

     /**
      * Metodo observador del atributo n.
      * @return Devuelve el atributo n.
      */
     public int mostrarN(){ return n; }

     /**
      * Metodo observador del atributo m.
      * @return Devuelve el atributo m.
      */
     public int mostrarM(){ return m; }

     public void mostrar_matriz()
     {
	for(int x = 0; x < n; x++)
	{
	     System.out.print("{ ");
	     for(int y = 0; y < m;y++)
		System.out.print(matrix[x][y] + " ");
	     System.out.print("}\n");
	}
     }
}
