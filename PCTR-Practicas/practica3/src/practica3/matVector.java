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

/**Fichero matVector.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * Clase que trata de resolver el prducto de una matriz por un vector de 
 * dimensiones n.
 */
public class matVector
{
	/**
	 * Dimensión de la matriz cuadrada y del vector.
	 */
     private int n;
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
	private int []vectorResultado;

     /**
      * Constructor de matVector especificando los parametros de 
      * forma manual.
      * @param tam Tamaño del vector y de la matriz.
      * @param mt Matriz creada manualmente de tamaño [tam][tam].
      * @param v Vector de [tam] elementos que se multiplica con la matriz.
      */
     public matVector(int tam, int [][]mt, int []v)
     {
		n = tam;
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
      * Constructor de matVector especificando los parametros con el
      * metodo random().
      * @param tam Tamaño del vector y de la matriz.
      */
     public matVector(int tam)
     {
		n = tam;
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
      * Metodo que multiplica la matriz [n][n] por el vector dado de [n]
      * elementos.
      * @param mv Objeto matVector pasado por referencia para realizar la
      * multiplicacion.
      */
     public void multiplicacion(matVector mv)
     {
		int i,j;
		for(i = 0; i < mv.n; i++)
		{
			for(j = 0; j < mv.n; j++)
			{
				op = op + (mv.matriz[i][j] * mv.vector[j]);
			}
			vectorResultado[i] = op;
			op = 0;
		}
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

     public static void main(String []args) throws IOException
     {
		InputStreamReader entrada = new InputStreamReader(System.in);
		BufferedReader lectura = new BufferedReader(entrada);
		matVector MV;
		int N;

		System.out.println("Introduzca el tamaño N de la matriz y vector: ");
		N = Integer.parseInt(lectura.readLine());
		MV = new matVector(N);
					
		//Tiempo Inicial
		double iniTiempo = (double)System.currentTimeMillis();
		MV.multiplicacion(MV);
		//Tiempo Final
		double finTiempo = (double)System.currentTimeMillis();

		if(N < 1000)
		{
			MV.VerMatriz();
			MV.VerVector();
		}
		
		MV.VectorResultado();
		
		System.out.println("Producto Matriz por vector obtenido en " + (finTiempo - iniTiempo) + " milisegundos");
     }
}
