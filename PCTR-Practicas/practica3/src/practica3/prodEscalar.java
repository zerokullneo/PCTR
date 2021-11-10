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

/**Fichero prodEscalar.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * Clase que trata de resolver el producto escalar de dos vectores A y B
 * de dimensiones n.
 */
public class prodEscalar
{
	/**
	 * Dimensión de los vectores a multiplicar.
	 */
	private int size;
	/**
	 * Primer vector multiplicando.
	 */
	private int []vectorA;
	/**
	 * Segundo vector multiplicando.
	 */
	private int []vectorB;

	/**
	 * Constructor base de la clase.
	 * @param n Dimension de los vectores A y B.
	 * @param vA Vector inicial A.
	 * @param vB Vector inicial B.
	 */
	public prodEscalar(int n, int []vA, int []vB)
	{
		size = n;
		vectorA = vA;
		vectorB = vB;
	}

	/**
	 * Metodo que lealiza el producto escalar de forma secuencial.
	 * @return Devuelve el resultado k de la multiplicacion.
	 */
	public int Escalar()
	{
		int ivecs, resultado = 0;
		for(ivecs = 0; ivecs< size; ivecs++)
			resultado = resultado + (vectorA[ivecs] * vectorB[ivecs]);
		
		return resultado;
	}

	public static void main(String[] args)
	{
		int n, r;
		
		System.out.println("Introduzca el tamaño N de los vectores: ");
		n = new Scanner(System.in).nextInt();

		int []vectorA = new int[n];
		int []vectorB = new int[n];
		
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

		prodEscalar PE = new prodEscalar(n, vectorA, vectorB);
		//Tiempo Inicial
		double iniTiempo = (double)System.currentTimeMillis();
		
		r = PE.Escalar();
		
		//Tiempo Final
		double finTiempo = (double)System.currentTimeMillis();
		System.out.println("Producto Escalar: " + r + "\nObtenido en " + (finTiempo - iniTiempo) + " milisegundos");
	}
}
