 /**
 * Copyright (C) 2021 Jose Manuel Barba Gonzalez <zk at wordpress.com>
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
 * Clase que trata de resolver el prducto de una matriz por un vector de 
 * dimensiones n, de forma concurrente con la interfaz Runnable.
 */
public class matVectorConcurrente implements Runnable
{
	/**
	 * Dimensión de la matriz cuadrada y del vector.
	 */
	private int n, parte;
	/**
	 * Parte u operando para el cálculo parical de la multiplicación.
	 */
	private static int op;
	/**
	 * Matriz Multiplicativa.
	 */
	private int [][]matriz;
	/**
	 * Vector multiplicativo.
	 */
	private int []vector;
	/**
	 * Vector Resultado y;
	 */
	private static int []vectorResultado;

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
		vectorResultado = new int[n];

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
		vectorResultado = new int[n];
		
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
      * Muestra el VectorResultado de multiplicar la matriz por el vector.
      */
     public void VectorResultado()
     {
		System.out.println();
		for(int i = 0; i < n; i++)
			System.out.print(vectorResultado[i] + " ");
		System.out.println();
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
				op = op + (mv.matriz[i][j] * mv.vector[j]);
			}
			vectorResultado[i] = op;
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
		int i, N;

	
		System.out.println("Introduzca el tamaño N de la matriz y vector: ");
		N = Integer.parseInt(lectura.readLine());
		matVectorConcurrente MV[] = new matVectorConcurrente[N];
					
		//Tiempo Inicial
		double iniTiempo = (double)System.currentTimeMillis();
		//con la interfaz Runnable hay que crear primero los Threads
		for(i = 0; i < N; i++)
			MV[i] = new matVectorConcurrente(N,i);
					
		for(i = 0; i < N; i++)
			new Thread(MV[i]).start();

		//Tiempo Final
		double finTiempo = (double)System.currentTimeMillis();
					
		
		if(N < 1000)
		{
			MV[N-1].VerMatriz();
			MV[0].VerVector();
		}

		MV[0].VectorResultado();
	
		System.out.println("Producto Matriz por vector obtenido en " + (finTiempo - iniTiempo) + " milisegundos");
	}
}
