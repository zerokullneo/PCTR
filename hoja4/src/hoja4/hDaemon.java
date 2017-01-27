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

/**Fichero hDaemon.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class hDaemon implements Runnable
{
     private static int prioriti = 3;
     
     public hDaemon(int p)
     {
	prioriti = p;
     }

     public void run()
     {
	Thread.currentThread().setPriority(prioriti);
	Thread T = Thread.currentThread();
	try
	{
	     while(true)
	     {
		T.sleep(1000000000);
		System.out.println("Esperando Evento...");
	     }
	}
	catch(InterruptedException e)
	{
	     System.out.println("Error en sleep(): " + e);
	}
     }

     public static void main(String[] args)
     {
	// TODO code application logic here
	//hDaemon hilo[] = new hDaemon[10];
	
	for(int i = 0; i < 10; i++)
	{
	     Thread dam = new Thread(new hDaemon(i));
	     dam.setDaemon(true);
	     dam.start();
	}
     }
}
