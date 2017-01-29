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

/**Fichero resImagenParGru.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class resImagenParGru extends CargaImagen implements Runnable
{
     private int n, m, parte;
     private static int [][]matriz;

     /**
      * Constructor especificando los parametros.
      * @param p Referente a la parte en la que se dividira el problema.
      * @throws IOException 
      */
     public resImagenParGru(int p)throws IOException
     {
          parte = p;
          n = matriz.length;
          m = matriz.length;
     }

     /**
      * Metodo observador del atributo Matriz.
      * @return Devuelve la matriz vectorizada.
      */
     public int[][] mostrar_matriz(){ return matriz; }

     /**
      * Metodo que vectoriza la matriz que contiene los codigos de colores.
      * @param img Referente al objeto al que se le modificara la matriz.
      * @param i Referente a la fila inicial a tratar por un hilo dado.
      * @param in Referente a la fila final a tratar por un hilo dado.
      * @return Devuelve el objeto "img" con la matriz de colores vectorizada.
      */
     public resImagenParGru vectorizar(resImagenParGru img, int i, int in)
     {//xi,j = (4xi,j − xi+1,j − xi,j+1 − xi−1,j − xi,j−1 )/8
          int c;
          for(; i < in; i++)
	     for(int j = 1; j < m-1; j++)
	     {
		c = ((4 * img.matriz[i][j]) - (img.matriz[i+1][j]) - (img.matriz[i][j+1]) - (img.matriz[i-1][j]) - (img.matriz[i][j-1]))/8;
		if(c > 255)
		     c = 255;
		if(c < 0)
		     c = 0;
	          img.matriz[i][j] = c;
	     }
          return img;
     }
	
     public void run()
     {
          switch(parte)
          {
	     case 0:
		System.out.println("tarea 1");
	          vectorizar(this,1,n/4);
	          break;
	     case 1:
		System.out.println("tarea 2");
	          vectorizar(this,n/4,n/2);
	          break;
	     case 2:
		System.out.println("tarea 3");
	          vectorizar(this,n/2,(n/4)*3);
	          break;
	     case 3:
		System.out.println("tarea 4");
	          vectorizar(this,(n/4)*3,n-1);
	          break;
	     default:
	          break;
	}
     }

     public static void main(String[] args) throws IOException
     {//introducir por parametro el intervalo
	LinkedList<resImagenParGru> tareas = new LinkedList<resImagenParGru>();
	int nNuc = Runtime.getRuntime().availableProcessors();
	int tamPool = 4, i; 
	long finTiempo, inicTiempo = System.nanoTime();

	matriz = cargar("uca.png");

	ThreadPoolExecutor ept = new ThreadPoolExecutor(tamPool,tamPool,0L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());

	ept.prestartAllCoreThreads();
	for(i=0;i < tamPool;i++)
	     tareas.add(new resImagenParGru(i));

	for(Iterator iter = tareas.iterator(); iter.hasNext();)
	     ept.execute((Runnable)iter.next());

	ept.shutdown();
	while(!ept.isTerminated()){}

	guardar(matriz,"ucaresG.png");

	finTiempo = System.nanoTime();
	System.out.println("Numero de Nucleos: " + nNuc);
	System.out.println("Tamano del Pool: " + tamPool);
	System.out.println("Tiempo... " + (finTiempo-inicTiempo)/1.0e9);
     }
}
