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

import java.util.Scanner;

/**Fichero prodEscalarParalelo.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * Recibe dos vectores, A y B, de igual tamaño ya creados, el inicio y el final
 * de cada partición que va a tratar cada objeto Thread, el tamaño n de los vectores
 * y la identificacion de la hebra con idHebra.
 */
public class prodEscalarParalelo extends Thread
{
	/**
	 * Dimension de los vectores
	 * Particion a calcular.
	 */
     public static int n, particion;
	/**
	 * Vector inicial A.
	 */
     public static int vectorA[] = new int[n];
	/**
	 * Vector inicial B.
	 */
     public static int vectorB[] = new int[n];
	/**
	 * Particion a tratar de cada vector.
	 */
     public static int pruductoParcial[] = new int[particion];
	/**
	 * Inicio y final de la particion,
	 * resultado de la multiplicacion.
	 */
     public int idHebra, inicio, finale, resultado;

	/**
	 * Constructor base de la clase .
	 * @param idHebra identificador de la hebra.
	 * @param vA Vector inicial A.
	 * @param vB Vector inicial B.
	 * @param inicio posicion inicial de la particion a tratar.
	 * @param finale Posicion final de la particion a tratar.
	 * @param n Dimension de los vectores.
	 */
     prodEscalarParalelo(int idHebra, int []vA, int []vB, int inicio, int finale, int n, int p)
     {
		this.idHebra = idHebra; this.inicio = inicio; this.finale = finale;
		vectorA = vA; vectorB = vB;
		this.n = n;
		particion = p;
		resultado = 0;
     }

	/**
	 * Metodo run sobreescrito que calcula parcialmente el producto.
	 */
	@Override
     public void run()
     {
		int ivecs;
		for(ivecs = inicio; ivecs < finale; ivecs++)
			resultado = resultado + (vectorA[ivecs] * vectorB[ivecs]);
		//pruductoParcial[ivecs] = resultado;
     }

	/**
	 * Metodo observador que devuelve el resultado k del producto escalar
	 * @return retorno de la variable resultado.
	 */
	int parcialEscalar()
	{
		return resultado;
	}
     
     public static void main(String[] args) throws Exception
     {
		int n, ini, fin;
		int nHebras = 4, particion;
		long r = 0;

		System.out.println("Introduzca el tamaño N de los vectores: ");
		n = new Scanner(System.in).nextInt();

		int []vectorA = new int[n];
		int []vectorB = new int[n];
		particion = n/nHebras;

		System.out.println("Particion: " + particion);
		//int []vectorA = {15, 8, 12, 1, 2, 11, 11, 3, 14, 13, 13, 3, 3, 8, 5, 15, 2, 2, 19, 6};
		//int []vectorB = {12, 13, 17, 16, 8, 8, 19, 20, 13, 13, 10, 13, 4, 13, 3, 11, 3, 11, 16, 9};
		for(int ia = 0; ia < n; ia++)
			vectorA[ia] = (int) (Math.random()*10+1);

		for(int ib = 0; ib < n; ib++)
			vectorB[ib] = (int) (Math.random()*10+1);

		if(n < 100)
		{
			for(int i = 0; i < n; i++)
				System.out.print( vectorA[i] + ", " );
			System.out.println();
		
			for(int i = 0; i < n; i++)
				System.out.print( vectorB[i] + ", " );
			System.out.println();
		}

		prodEscalarParalelo []PE = new prodEscalarParalelo[nHebras];
		//Tiempo Inicial
		double iniTiempo = (double)System.currentTimeMillis();
		for(int i = 0; i < nHebras; i++)
		{
			ini = particion * i;
			fin = (ini + particion);
			//System.out.println("iesima: " + i + ": " + ((double)(i+1)/nHebras) * particion);
			if((((float)(i+1)/nHebras) * particion) >= particion)
			{
				//System.out.println("iesima if: " + i + ": " + ((float)i/nHebras) * particion);
				fin = fin + ((n) % nHebras);
				PE[i] = new prodEscalarParalelo(i, vectorA, vectorB, ini, fin, n, n - fin);
			}
			else
				PE[i] = new prodEscalarParalelo(i, vectorA, vectorB, ini, fin, n, particion);
		}

		for(int i = 0; i < nHebras; i++)
			PE[i].start();
		for(int i = 0; i < nHebras; i++)
			PE[i].join();
		
		for(int iRes = 0; iRes < nHebras; iRes++)
			r = r + PE[iRes].parcialEscalar();
		//Tiempo Final
		double finTiempo = (double)System.currentTimeMillis();
		System.out.println("Producto Escalar: " + r + "\nObtenido en " + (finTiempo - iniTiempo) + " milisegundos");
     }
}
