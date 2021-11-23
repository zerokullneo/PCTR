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

package practica6;

import java.lang.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;

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
     private static int n, rango;
     public int parte, tampool;
     private static int op;
     private static int [][]matriz;
     private static int []vector;
     private static int i;

     public matVectorConcurrente(int tam, int p, int tpl)
     {
	n = tam;
	tampool = tpl;
	parte = p;
	rango = n/tampool;
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

     public static void VerVector()
     {
          System.out.print("[");
     	for(i = 0; i < n-1; i++)
	     System.out.print(vector[i] + ", ");
	System.out.println(vector[n-1] + "].");
     }

     /**
      * Muestra la matriz multiplicada por el vector.
      */
     public static void VerMatriz()
     {
	System.out.println();
	for(int i = 0; i < n; i++)
	{
	     for(int j = 0; j < n; j++)
		System.out.print(matriz[i][j] + " ");
	     
	     System.out.println();
	}
     }
     
     public static void multiplicacion(matVectorConcurrente mv, int ini, int fin)
     {
	for(int i = ini; i < fin; i++)
	{
		for(int j = 0; j < n; j++)
		{
		     op = (mv.matriz[i][j] * mv.vector[j]);
		     matriz[i][j] = op;
		}
		op = 0;
	}
     }
	
     public void run()
     {
	multiplicacion(this, (parte*rango), (rango*(parte+1)));		
     }

     public static void main(String []args) throws IOException
     {
	//introducir por parametro el tamanio y el coeficiente
	long Tini, Tfin;
	LinkedList<matVectorConcurrente> tareas = new LinkedList<matVectorConcurrente>();
	//matVectorConcurrente hilo_MV;
	int nNuc = Runtime.getRuntime().availableProcessors();
	int i, N = Integer.parseInt(args[0]);
	float Cb = Float.parseFloat(args[1]);
	int tamPool = (int)(nNuc/(1-Cb));

	ThreadPoolExecutor ept = new ThreadPoolExecutor(tamPool,tamPool,0L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
	ept.prestartAllCoreThreads();

	Tini = System.nanoTime();
	for(i = 0; i < tamPool; i++)
	     tareas.add(new matVectorConcurrente(N,i,tamPool));

	//VerMatriz();

	for(Iterator iter = tareas.iterator(); iter.hasNext();)
	     ept.execute((Runnable)iter.next());

	ept.shutdown();
	while(!ept.isTerminated()){}

	Tfin = System.nanoTime();

	VerVector();
	//VerMatriz();
	System.out.println("Numero de Nucleos: " + nNuc);
	System.out.println("Coficiente de Bloqueo: " + Cb);
	System.out.println("Tamano del Pool: " + tamPool);
	System.out.println("Tiempo Total (segundos): " + (Tfin-Tini)/1.0e9);
     }
}
