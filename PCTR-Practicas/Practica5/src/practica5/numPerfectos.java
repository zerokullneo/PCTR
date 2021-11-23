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

import java.util.*;

/**Fichero numPerfectos.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * Clase que trata de encontrar los numeros perfectos dada una dimension
 * en un rango N.
 */
public class numPerfectos
{
	/**
	 * Dimension de numeros enteros donde buscar.
	 */
	private int n;
	/**
	 * Cantidad de numeros perfectos encontrados en la dimension n.
	 */
	private int encontrados;
	
	/**
	 * Constructor base de la clase.
	 * @param dimensionN rango de enteros donde buscar.
	 */
	public numPerfectos(int dimensionN)
	{
		n = dimensionN;
		encontrados = 0;
	}

	/**
	 * Metodo que busca los numeros perfectos en la dimension dada.
	 */
	public void encontrarPerfectos()
	{
		int i,j, suma;
		for(i=1;i <= n;i++)
		{      // i es el número que vamos a comprobar
			suma = 0;
			for(j = 1;j < i;j++)
			{    // j son los divisores. Se divide desde 1 hasta i-1                          
				if(i % j==0)
				{
					suma = suma + j; // si es divisor se suma
				}
			}
			if(i == suma)
			{             // si el numero es igual a la suma de sus divisores es perfecto              
				this.encontrados++;
			}
		}
	}

	/**
	 * Metodo observador que devuelve la cantidad de encontrados en la
	 * dimension n dada.
	 * @return devuelve el atributo encontrado de la clase.
	 */
	public int getEncontrados()
	{
		return this.encontrados;
	}
	
	public static void main(String[] args)
	{
		Scanner opcion;
		int n;
		
		System.out.println("Introducir los n numeros perfectos a encontrar.");
		opcion = new Scanner(System.in);
		n = opcion.nextInt();

		System.out.println("Números perfectos entre 1 y : " + n);

		numPerfectos NP = new numPerfectos(n);
		
		long inicTiempo = System.nanoTime(); 
		NP.encontrarPerfectos();
		long fincTiempo = System.nanoTime(); 
		
		System.out.println(NP.getEncontrados());
		
		System.out.println("Calculo finalizado en " + (fincTiempo - inicTiempo)/1.0e9 + " segundos");
	}
}
