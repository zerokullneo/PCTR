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

package practica4;
import java.lang.*;
import java.io.*;
import java.util.*;

/**Fichero prodMat.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class prodMat
{
     private int n;
     private static int op;
     private int [][]matriz;
     private int []vector;

     /**
      * Constructor de prodMat especificando los parametros de 
      * forma manual.
      * @param tam Tamaño del vector y de la matriz.
      * @param mt Matriz creada manualmente de tamaño [tam][tam].
      * @param v Vector de [tam] elementos que se multiplica con la matriz.
      */
     public prodMat(int tam, int [][]mt, int []v)
     {
	n = tam;
	matriz = new int[n][n];
	vector = new int[n];
	for(int i = 0; i < n; i++)
	{
	     vector[i] = v[i];
	     for(int j = 0; j < n; j++)
		matriz[i][j] = mt[i][j];
	}
	op = 0;
     }

     /**
      * Constructor de prodMat especificando los parametros con el
      * metodo random().
      * @param tam Tamaño del vector y de la matriz.
      */
     public prodMat(int tam)
     {
	n = tam;
	Random r = new Random();
	vector = new int[n];
	matriz = new int[n][n];
	for(int i = 0; i < n; i++)
	{
	     vector[i] = r.nextInt(11-1)+1;
	     for(int j = 0; j < n; j++)
		matriz[i][j] = r.nextInt(11-1)+1;
	}
	op = 0;
     }

     /**
      * Muestra el Vector por el que se va a multiplicar la matriz.
      */
     public void VerVector()
     {
	System.out.println();
	for(int i = 0; i < n; i++)
	     System.out.println("Fila " + i + ":" + vector[i]);
     }
     /**
      * Muestra la matriz multiplicada por el vector.
      */
     public void VerMatriz()
     {
	System.out.println();
	for(int i = 0; i < n; i++)
	{
	     for(int j = 0; j < n; j++)
		System.out.print(matriz[i][j] + " ");
	     
	     System.out.println();
	}
     }

     /**
      * Metodo que multiplica la matriz [n][n] por el vector dado de [n]
      * elementos.
      * @param mv Objeto matVector pasado por referencia para realizar la
      * multiplicacion.
      */
     public void multiplicacion(prodMat mv)
     {
	int i, j;
	for(i = 0; i < mv.n; i++)
	{
	     for(j = 0; j < mv.n; j++)
	     {
		op = (mv.matriz[i][j] * mv.vector[j]);
		matriz[i][j] = op;
	     }
	     op = 0;
	}
     }
}
