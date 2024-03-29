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

import java.util.concurrent.*;

/**Fichero algHyman.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class algHyman implements Runnable
{
     private int turno;
     private int Hilo;
     private static int nVueltas = 1000000;
     private static volatile int n = 0;
     private static volatile int c1 = 1;
     private static volatile int c2 = 2;;

     public algHyman(int t)
     {
	turno = t;
     }
     
     public void run()
     {
	switch(turno)
	{
	     case 1:
	     {
		for(int i = 0; i < nVueltas; i++)
		{
		     turno = c1;
		     while(turno != c1);
		     n++;
		     turno = 2;
		}
		break;
	     }
	     case 2:
	     {
		for(int i = 0; i < nVueltas; i++)
		{
		     turno = c2;
		     while(turno != c2);
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
	e.execute(new algHyman(1));
	e.execute(new algHyman(2));

	e.shutdown();
	System.out.println(n);
    }
}
