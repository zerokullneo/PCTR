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

/**Fichero numPerfectosParalelo.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * Clase que trata de encontrar los numeros perfectos dada una dimension
 * en un rango N.
 */
public class numPerfectosParalelo implements Callable
{
	/**
	 * Primer el numero a comprobar del rango.
	 */
	private final int linf;
	/**
	 * Ultimo numero a comprobar del rango.
	 */
	private final int lsup;
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
	public numPerfectosParalelo(int dimensionN, int lf, int ls)
	{
		n = dimensionN;
		linf = lf;
		lsup = ls;
		encontrados = 0;
	}

	/**
	 * Metodo que busca los numeros perfectos en la dimension dada.
	 */
	public void encontrarPerfectos()
	{
		int i,j, suma;
		for(i = linf; i <= lsup; i++)
		{
			// i es el número que vamos a comprobar
			suma = 0;
			for(j = 1; j < i; j++)
			{
				// j son los divisores. Se divide desde 1 hasta i-1                          
				if(i % j == 0)
				{
					suma = suma + j; // si es divisor se suma
				}
			}
			if(i == suma)
			{
				// si el numero es igual a la suma de sus divisores es perfecto              
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

	/**
	 * Metodo call sobreescrito para ejecutar la busqueda
	 * @return devuelve el atributo encontrado de la clase.
	 */
	@Override
	public Integer call()
	{
		encontrarPerfectos();
		return (encontrados);
	}

	public static void main(String[] args)
	{
		Scanner data;
		String cb;
		int nPuntos;
		float Cb;

		data = new Scanner(System.in);
		System.out.println("Introducir los n numeros perfectos a encontrar.");
		nPuntos = data.nextInt();
		
		System.out.println("Introducir el Cb.");
		data = new Scanner(System.in);
		cb = data.nextLine();
		Cb = Float.parseFloat(cb);

		int nTareas     = (int)(Runtime.getRuntime().availableProcessors());//*10, /1.3, /2, /4
		int encontrados = 0;
		int tVentana    = nPuntos/nTareas;
		int linf        = 1;
		int lsup        = tVentana;
		int tamPool      = (int)(nTareas/(1-Cb));
		
		ArrayList<Future<Integer>> numParalelos = new ArrayList<Future<Integer>>();
		
		long inicTiempo = System.nanoTime();  
		ThreadPoolExecutor ept = new ThreadPoolExecutor(
				tamPool,
				tamPool,
				0L,
				TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>()
		);
    
		for(int i=0; i<nTareas; i++)
		{
			numParalelos.add(ept.submit(
			new numPerfectosParalelo(nPuntos, linf, lsup)));
			linf=lsup+1;
			lsup+=tVentana;
		}  
		for(Future<Integer> iterador:numParalelos)
		try
		{
			encontrados +=  iterador.get(); 
		}
		catch (CancellationException e){}
		catch (ExecutionException e){}
		catch (InterruptedException e){}
		long fincTiempo = System.nanoTime();  
		long tiempoTotal = (fincTiempo-inicTiempo);   
		ept.shutdown();

		System.out.println("Numeros Perfectos encontrados: " + encontrados);
		System.out.println("Calculo finalizado en " + tiempoTotal/1.0e9 + " segundos");
	}
}
