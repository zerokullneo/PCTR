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

package hoja8;

import java.util.concurrent.*;

/**Fichero cocidoMadrileño.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class cocidoMadrileño implements Runnable
{
     private static int []cucharas = new int[5];
     private static Semaphore[] aComer = new Semaphore[4];

     public void cogerCucharas(int i)
     {
	try
	{
	     if(cucharas[i] != 2) aComer[i].acquire();
	}
	catch(InterruptedException e)
	{
	     System.out.println("Error: " + e);
	}
	cucharas[i+1]--;
	cucharas[i-1]--;
     }

     public void dejarCucharas(int i)
     {
	cucharas[i+1]++;
	cucharas[i-1]++;

	if(cucharas[i+1]==2) aComer[i+1].release();
	if(cucharas[i-1]==2) aComer[i-1].release();
     }

     public void run()
     {
	for(int j=0; j < 4;j++)
	     cucharas[j]=2;     
     }

}
