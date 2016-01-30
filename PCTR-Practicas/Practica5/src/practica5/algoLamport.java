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

package practica5;

import java.lang.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;

/**Fichero algoLamport.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class algoLamport implements Runnable
{
     public static volatile int[] turnos;
     private static int numThread;
     private static int thread=0;

     public algoLamport(int t)
     {
	numThread = t;
	turnos = new int[numThread];
     }

     public void run()
     {
	for(int i = 0; i < numThread; ++i)
	{
	     //Antes del pre-protocolo
	     System.out.println(this.toString() + ": Antes del pre-protocolo.");

	     //Pre-protocolo
	     System.out.println(this.toString() + ": Pre-protocolo: " + thread);

	     if(thread == 9)
		thread=0;
	     else
		if(thread == 0)
		     thread = 1;
		else
		     thread = (thread % numThread);

	     turnos[numThread] = thread;
	     //turnos[numThread] = turnos[thread] + 1;

	     System.out.println(this.toString() + ": Mi turno: " + turnos[numThread] + ". Turno del otro: " + turnos[thread]);
	     while(turnos[thread] != 0 && turnos[numThread] > turnos[thread]) {}

	     //Sección crítica
	     System.out.println(this.toString() + ": Seccion critica. Vuelta " + i);

	     //Post-protocolo
	     System.out.println(this.toString() + ": Post-protocolo");
	     turnos[numThread] = 0;
	     System.out.println(this.toString() + ": Post turnos[" + numThread + "] = " + turnos[numThread]);
	}
     }

     public static void main(String[] args) throws InterruptedException
     {
	algoLamport []t1; //= new algoLamport();
	//algoLamport t2 = new algoLamport();

	int  nTareas = 10;
	int  tamPool = 1000000;
	
	ThreadPoolExecutor cola = new ThreadPoolExecutor(nTareas, tamPool, 60000L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());

	t1 = new algoLamport[nTareas];
	for(int i=0; i<nTareas; i++)
	{
		t1[i] = new algoLamport(i);
		cola.execute(t1[i]);
	}
	cola.shutdown();
     }
}
