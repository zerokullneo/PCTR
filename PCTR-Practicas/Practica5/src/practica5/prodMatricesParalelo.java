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
package practica5;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

/**Fichero prodMatricesParalelo.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * Clase que trata de resolver el prducto de dos matrices A y B 
 * dimensiones mxm.
 */
public class prodMatricesParalelo implements Runnable
{
	/**
	 * Dimensión de la matriz cuadrada y del vector.
	 */
	private int m, parte;
	/**
	 * Parte u operando para el cálculo parical de la multiplicación.
	 */
	private static int op;
	/**
	 * Matriz Multiplicativa A.
	 */
     private int [][]matrizA;
	/**
	 * Matriz Multiplicativa B.
	 */
     private int [][]matrizB;
	/**
	 * Matriz de resultados.
	 */
	private int [][]matrizResultado;

	/**
	 * Constructor de matVectorConcurrente especificando los parametros con el
	 * metodo random().
	 * @param tam Tamaño del vector y de la matriz.
	 * @param p Partes en las que se divide la matriz en numero de hilos
	 * para el calculo del producto.
	 */
	public prodMatricesParalelo(int tam, int p)
	{
		m = tam;
		parte = p;
		Random r = new Random();
		matrizA = new int[m][m];
		matrizB = new int[m][m];
		matrizResultado = new int[m][m];
		
		for(int i = 0; i < m; i++)
		{
			for(int j = 0; j < m; j++)
			{
				matrizA[i][j] = r.nextInt(11-1)+1;
				matrizB[i][j] = r.nextInt(11-1)+1;
			}
		}
		op = 0;
	}

	/**
	 * Muestra la matriz.
	 */
	public void VerMatriz()
	{
		System.out.println();
		for(int i = 0; i < m; i++)
		{
			for(int j = 0; j < m; j++)
			System.out.print(matrizA[i][j] + " ");

			System.out.println();
		}
	}

	/**
	 * Muestra la matriz Resultado multiplicada por A y B, filas por columnas.
	 */
	public void VerMatrizResultado()
	{
		System.out.println();
		for(int i = 0; i < m; i++)
		{
			for(int j = 0; j < m; j++)
			System.out.print(matrizResultado[i][j] + " ");

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
	public void multiplicacion(prodMatricesParalelo mv, int ini, int fin)
	{
		for(int i = ini; i < fin; i++)
		{
			for(int j = 0; j < fin; j++)//mv.m
			{
				op = op + (mv.matrizA[i][j] * mv.matrizB[j][i]);
				matrizResultado[i][j] = op;
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
		
		LinkedList<prodMatricesParalelo> matrices = new LinkedList<prodMatricesParalelo>();
		
		int nNuc = (int)(Runtime.getRuntime().availableProcessors());
		float Cb = 0.5f;
		int i, M;

		System.out.println("Introduzca el Cb: ");
		Cb =	Float.parseFloat(lectura.readLine());
		int tamPool = (int)(nNuc/(1-Cb));

		System.out.println("Introduzca el tamaño M de la matrices A y B: ");
		M = Integer.parseInt(lectura.readLine());
		prodMatricesParalelo MV[] = new prodMatricesParalelo[M];

		ThreadPoolExecutor ept = new ThreadPoolExecutor(
			tamPool, 
			tamPool,
			0L,
			TimeUnit.MILLISECONDS, 
			new LinkedBlockingQueue<Runnable>());
		
		ept.prestartAllCoreThreads();

		//Tiempo Inicial
		double iniTiempo = (double)System.currentTimeMillis();
		//con la interfaz Runnable hay que crear primero los Threads
		matrices.add(new prodMatricesParalelo(M,M));
		
		for(Iterator it = matrices.iterator(); it.hasNext();)
			ept.execute((Runnable)it.next());
		
		ept.shutdown();
		while(!ept.isTerminated()){}

		//Tiempo Final
		double finTiempo = (double)System.currentTimeMillis();
					
		
		if(M < 1000)
		{
			MV[M-1].VerMatriz();
			MV[0].VerMatrizResultado();
		}

		

		System.out.println("Producto Matriz por vector obtenido en " + (finTiempo - iniTiempo) + " milisegundos");
	}
}
