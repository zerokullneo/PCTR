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
package practica6;

import java.util.*;
import java.io.*;
import java.util.concurrent.*;
import java.util.Random;
import java.util.Scanner;

/**Fichero integCallable.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * Clase que obtiene los resultados de la Integral de Monte-Carlo de forma
 * paralela con la implementacion de la interfaz Callable.
 */
public class integCallable implements Callable
{
	/**
	 * Variable que almacenara los puntos encontrados dentro de la funcion 
	 * definida para la integral.
	 */
	private static int puntos = 0;
	/**
	 * Variable que almacenara los intentos a realizar sobre la funcion 
	 * definida para la integral.
	 */
	private static int intentos;
	/**
	 * Coordenadas x e y iniciales para la primera iteracion.
	 */
	private static double cx,cy;

	public integCallable(int intents, double cx, double cy)
	{
		integCallable.intentos = intents;
		integCallable.cx = cx;
		integCallable.cy = cy;
	}

	/**
	 * Metodo call sobreescrito para que devuelva un entero calculado por la
	 * funcion cos(x) y que coincidan con el rango dado.
	 * @return Devuelve un entero correspondiente al numero de puntos coincidentes
	 * con la funcion dada.
	 */
	@Override
	public Integer call()
	{
		synchronized(this)
		{
			for(int i = 0; i < intentos; i++)
			{
				cx = (float)Math.random();
				cy = (float)Math.random();
				if (cy <= Math.cos(cx)) puntos++;
				//System.out.println( "valor de cont:" + puntos);
			}
			System.out.println("valor de la integal Monte-Carlo:" + (double)puntos/intentos);
		}

		return Integer.valueOf(puntos);
	}

	public static void main(String[] args) throws InterruptedException
	{
		System.out.println("Integral Monte-Carlo -> f(x) = cos(x)" );
		Scanner Sc = new Scanner(System.in);

		System.out.println("Intoduce nº de intentos");
		int intents =Sc.nextInt();

		int MCpuntos = 0;
		int nNuc = Runtime.getRuntime().availableProcessors();
		float Cb = 0.5f;
		int tampool = (int)(nNuc/(1-Cb));
		
		ExecutorService pool = Executors.newFixedThreadPool(tampool);
		Set<Future<Integer>> set = new HashSet<Future<Integer>>();

		for(int i=0; i < tampool; i++)
		{
			Callable<Integer> callable = new integCallable(intents, (int)cx, (int)cy);
			Future<Integer> future=pool.submit(callable);
			set.add(future);
		}
		
		for(Future<Integer> iterador:set)
		try
		{
			MCpuntos += iterador.get();
		}
		catch (CancellationException e){}
		catch (ExecutionException e){}
		catch (InterruptedException e){}
		
		pool.shutdown();
		pool.shutdownNow();
		pool.awaitTermination(nNuc, TimeUnit.SECONDS);
		
		System.out.println("Puntos cos(x): " + MCpuntos);
		System.out.println("puntos de clase: " + puntos);
	}

	/*public static void main(String[] args)
	{
		int intentos = 6000000;
		int puntos   = 0;

		piMonteCarlo piM = new piMonteCarlo();
		Future<int>x = pool.execute(piM);
		int res = x.get();

		for(int i=0; i<intentos; i++)
		{
			double cx = Math.random();
			double cy = Math.random();
			if(Math.pow(cx, 2)+Math.pow(cy, 2)<=1)puntos++;
		}

		System.out.println(4.0*puntos/intentos);
	}*/
}
