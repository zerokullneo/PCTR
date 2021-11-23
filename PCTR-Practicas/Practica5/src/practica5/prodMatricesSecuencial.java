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
import java.lang.*;
import java.io.*;
import java.util.*;

/**Fichero prodMatricesSecuencial.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * Clase que trata de resolver el prducto de dos matrices A y B 
 * dimensiones mxm.
 */
public class prodMatricesSecuencial
{
	/**
	 * Dimensión de las matrices.
	 */
     private int m;
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
      * Constructor de matVector especificando los parametros con el
      * metodo random().
      * @param tam Tamaño del vector y de la matriz.
      */
     public prodMatricesSecuencial(int tam)
     {
		m = tam;
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
      * Metodo que multiplica la matrizA [n][n] por la matrizB [n][n]
      * elementos.
      * @param mv Objeto prodMatricesSecuencial pasado por referencia para
	 * realizar la multiplicacion.
      */
     public void multiplicacion(prodMatricesSecuencial mv)
     {
		int i,j;
		for(i = 0; i < mv.m; i++)
		{
			for(j = 0; j < mv.m; j++)
			{
				op = op + (mv.matrizA[i][j] * mv.matrizB[j][i]);
				matrizResultado[i][j] = op;
			}
			op = 0;
		}
     }


     /**
      * Muestra la matriz.
      */
     public void VerMatriz()
     {
		System.out.println();
		for(int i = 0; i < m-1; i++)
		{
			for(int j = 0; j < m-1; j++)
				System.out.print(matrizA[i][j] + " ");
	     
			System.out.println();
		}
     }

     /**
      * Muestra la matriz resultado del producto, filas por columnas.
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

     public static void main(String []args) throws IOException
     {
		InputStreamReader entrada = new InputStreamReader(System.in);
		BufferedReader lectura = new BufferedReader(entrada);
		prodMatricesSecuencial MV;
		int M;

		System.out.println("Introduzca el tamaño M de las matrices A y B: ");
		M = Integer.parseInt(lectura.readLine());
		MV = new prodMatricesSecuencial(M);
					
		//Tiempo Inicial
		double iniTiempo = (double)System.currentTimeMillis();
		MV.multiplicacion(MV);
		//Tiempo Final
		double finTiempo = (double)System.currentTimeMillis();

		if(M < 1000)
		{
			MV.VerMatriz();
			MV.VerMatrizResultado();
		}
		
		System.out.println("Producto Matriz por vector obtenido en " + (finTiempo - iniTiempo) + " milisegundos");
     }
}
