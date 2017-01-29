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

/**Fichero matVectorConcurrente.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class matVectorConcurrente implements Runnable
{
     private int n, parte;
     private static int op;
     private int [][]matriz;
     private int []vector;

     /**
      * Constructor de matVectorConcurrente especificando los parametros de 
      * forma manual.
      * @param tam Tamaño del vector y de la matriz.
      * @param mt Matriz creada manualmente de tamaño [tam][tam].
      * @param v Vector de [tam] elementos que se multiplica con la matriz.
      * @param p Partes en las que se divide la matriz en numero de hilos
      * para el calculo del producto.
      */
     public matVectorConcurrente(int tam, int [][]mt, int []v, int p)
     {
	n = tam;
	parte = p;
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
      * Constructor de matVectorConcurrente especificando los parametros con el
      * metodo random().
      * @param tam Tamaño del vector y de la matriz.
      * @param p Partes en las que se divide la matriz en numero de hilos
      * para el calculo del producto.
      */
     public matVectorConcurrente(int tam, int p)
     {
	n = tam;
	parte = p;
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
      * @param ini Corresponde a la fila de inicio donde comenzara la
      * multiplicacion concurrente indicada en el metodo run().
      * @param fin Corresponde a la fila de fin donde finaliza la
      * multiplicacion concurrente indicada en el metodo run(), puede ser
      * igual a ini y nunca menor.
      */
     public void multiplicacion(matVectorConcurrente mv, int ini, int fin)
     {
	for(int i = ini; i < fin; i++)
	{
	     for(int j = 0; j < fin; j++)//mv.n
	     {
		op = (mv.matriz[i][j] * mv.vector[j]);
		matriz[i][j] = op;
	     }
	     op = 0;
	}
     }
	
     /**
      * Metodo run() redefinido para que realice la multiplicacion por filas.
      */
     public void run()
     {
	multiplicacion(this, parte, parte+1);		
     }

     public static void main(String []args) throws IOException
     {
	InputStreamReader entrada = new InputStreamReader(System.in);
	BufferedReader lectura = new BufferedReader(entrada);
	int i, j, N, opcion = 0;
	int []v; int [][]m;

	do
	{
	     System.out.println();
	     System.out.println("-- Menu Vector Concurrente--");
	     System.out.println("1.- Vector y Matriz Manual.");
	     System.out.println("2.- Vector y Matriz Aleatorio.");
	     System.out.println("0.- Salir.");
	     System.out.println("Opcion: ");
	     opcion = Integer.parseInt(lectura.readLine());

	     switch(opcion)
	     {
		case 0:
		     break;
		case 1:
		{
		     System.out.println("Introduzca N: ");
		     N = Integer.parseInt(lectura.readLine());
		     v = new int[N];
		     m = new int[N][N];
		     System.out.println("Introduzca los " + N + " Valores del vector");
		     for(i = 0; i < N; i++)
			v[i] = Integer.parseInt(lectura.readLine());
		     System.out.println("Introduzca los " + (N*N) + " Valores de la Matriz");
		     for(i = 0; i < N; i++)
		     {
			System.out.println("Fila " + i + " de la Matriz");
			for(j = 0; j < N; j++)
			     m[i][j] = Integer.parseInt(lectura.readLine());
		     }
		     matVectorConcurrente MV[] = new matVectorConcurrente[N];
		     //con la interfaz Runnable hay que crear primero los Threads
		     for(i = 0; i < N; i++)
			MV[i] = new matVectorConcurrente(N,m,v,2);;
		     MV[0].VerMatriz();
		     for(i = 0; i < N; i++)
			new Thread(MV[i]).start();
		     MV[0].VerVector();
		     //for(i = 0; i < N; i++)
			MV[N-1].VerMatriz();
		     break;
		}
		case 2:
		{
		     System.out.println("Introduzca N: ");
		     N = Integer.parseInt(lectura.readLine());
		     matVectorConcurrente MV[] = new matVectorConcurrente[N];
		     //con la interfaz Runnable hay que crear primero los Threads
		     for(i = 0; i < N; i++)
			MV[i] = new matVectorConcurrente(N,i);
		     MV[0].VerMatriz();
		     for(i = 0; i < N; i++)
			new Thread(MV[i]).start();
		     MV[0].VerVector();
		     //for(i = 0; i < N; i++)
			MV[N-1].VerMatriz();
		     break;
		}
		default:
		     opcion = 0;
		     break;
	     }
	}while(opcion != 0);
     }
}
