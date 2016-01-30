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

package hoja5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**Fichero juanma.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class juanma implements Runnable
{
     private int turno = 1;
     private int Hilo;
     private static int nVueltas = 1000000;
     private static volatile int n = 0;

     public juanma(int t)
     {
	Hilo = t;
     }
     
     public void run()
     {
	switch(Hilo)
	{
	     case 1:
	     {
		for(int i = 0; i < nVueltas; i++)
		{
		     turno = 1;
		     while(turno != 1);
		     n++;
		     turno = 2;
		}
		break;
	     }
	     case 2:
	     {
		for(int i = 0; i < nVueltas; i++)
		{
		     turno = 2;
		     while(turno != 2);
		     n--;
		     turno = 1;
		}
		break;
	     }

	}
     }

     public static void main(String[] args) throws InterruptedException
     {
	ExecutorService e = Executors.newCachedThreadPool();
	e.execute(new juanma(1));
	e.execute(new juanma(2));

	e.shutdown();
	System.out.println(n);
    }
}
