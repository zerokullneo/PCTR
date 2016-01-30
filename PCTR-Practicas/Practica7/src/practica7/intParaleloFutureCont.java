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

package practica7;

import java.util.*;
import java.io.*;
import java.util.concurrent.*;
import java.util.Random;
import java.util.Scanner;

/**Fichero intParaleloFutureCont.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class intParaleloFutureCont implements Callable
{
     private static int puntos=0;
     private static int intentos=0;
     private static double cx,cy;
     public static int seleccion;

     public intParaleloFutureCont(int tampool,double cx,double cy)
     {
	intParaleloFutureCont.cx=cx;
	intParaleloFutureCont.cy=cy;
     }

     public static int menu()
     {
	int op;
	Scanner Sc = new Scanner(System.in);

	System.out.println("    Menu:    ");
	System.out.println("1.- f(x) = sin(x)" ); 
	System.out.println("2.- f(x) = x") ;

	do
	{
	     System.out.print("Introduzca una opcion: ");
	     op = Sc.nextInt();
	}while(op < 1 || op > 2);
	System.out.println("intoduce nº de intentos");
	intentos=Sc.nextInt();

	return op;
     }

     @Override
     public Integer call()
     {
	switch(seleccion)
	{
	     case 1:
		synchronized(this)
		{
		     for(int i = 0; i < intentos; i++)
		     {
			cx = (float)Math.random();
			cy = (float)Math.random();
			if (cy <= Math.sin(cx)) puntos++;
			//System.out.println( "valor de cont:" + puntos);
		     }
		     System.out.println("valor de la integal:" + (double)puntos/intentos);
		}
		break;
	     case 2:
		synchronized(this)
		{
		     for(int i = 0; i < intentos; i++)
		     {
			cx = (float)Math.random();
			cy = (float)Math.random();
			if (cy <= cx) puntos++;
			//System.out.println("valor de puntos:" + puntos);
		     }
		     System.out.println("valor de la integal:"+(double)puntos/intentos);
		}
		break;
	     default:
		break;
	}
	return Integer.valueOf(puntos);
     }

     public static void main(String[] args) throws InterruptedException
     {
	seleccion = menu();
	int nNuc = Runtime.getRuntime().availableProcessors();
	float Cb = 0;
	int tampool = (int)(nNuc/(1-Cb));
	ExecutorService pool = Executors.newFixedThreadPool(tampool);
	Set<Future<Integer>> set = new HashSet<Future<Integer>>();
	
	for(int i=0; i<tampool; i++)
	{
	     Callable<Integer> callable = new intParaleloFutureCont(tampool,(int)cx,(int)cy);
	     Future<Integer> future=pool.submit(callable);
	     set.add(future);
	}
	pool.shutdown();
	pool.shutdownNow();
	pool.awaitTermination(nNuc, TimeUnit.SECONDS);
     } 

   /*public static void main(String[] args){
      int intentos = 6000000;
      int puntos   = 0;
      
      piMonteCarlo piM = new piMonteCarlo();
      Future<int>x = pool.execute(piM);
      int res = x.get();
      
      for(int i=0; i<intentos; i++){
        double cx = Math.random();
        double cy = Math.random();
        if(Math.pow(cx, 2)+Math.pow(cy, 2)<=1)puntos++;
      }	      
      System.out.println(4.0*puntos/intentos);
      
    }*/
}
