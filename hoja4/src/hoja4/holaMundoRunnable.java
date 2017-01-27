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

package hoja4;

/**Fichero holaMundoRunnable.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class holaMundoRunnable implements Runnable
{
     private static int prioriti = 1;
     
     public holaMundoRunnable(int p)
     {
	prioriti = p;
	Thread.currentThread().setPriority(prioriti);
     }

     public void run()
     {
	System.out.println("Hola Mundo..." + Thread.currentThread().getPriority());
     }

     public static void main(String[] args)
     {
	// TODO code application logic here
	holaMundoRunnable hilo[] = new holaMundoRunnable[10];
	
	for(int i = 0; i < 10; i++)
	{
	     hilo[i] = new holaMundoRunnable(i+1);
	     new Thread(hilo[i]).start();
	}
     }

}
