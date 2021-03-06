/**
 * Copyright (C) 2017 Jose Manuel Barba Gonzalez <zk at wordpress.com>
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

package hoja4;

/**Fichero hilosYield.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class hilosYield extends Thread
{
     public static int N = 10;
     private int n;
	
     public hilosYield(int num)
     {
	n = num;
     }

     public void run()
     {
	for(int i = 0; i < n; i++)
	     Thread.yield();

	System.out.println("Hilo en espera... " + Thread.currentThread().getName());
		    
     }

     public static void main(String[] args)
     {
	hilosYield hilo[] = new hilosYield[N];

	for(int i = 0, j = 10; i < N; i++)
	{
	     hilo[i] = new hilosYield(j);
	     new Thread(hilo[i]).start();
	}
     }
}
