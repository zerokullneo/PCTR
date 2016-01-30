/**
 * Copyright (C) 2016 Jose Manuel Barba Gonzalez <zk at wordpress.com>
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

/**Fichero Productor.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

import java.util.concurrent.*;

/**Descripcion
 * 
 */
public class Productor implements Runnable
{
     LinkedBlockingQueue<Integer> data;
     Thread hilo;

     public Productor(LinkedBlockingQueue<Integer> l)
     {
	this.data = l;
	hilo = new Thread (this);
	hilo.start();
     }

     public void run()
     {
	try
	{
	     for(int x=0;;x++)
	     {
		data.put(new Integer(x));
		System.out.println("Insertando "+x);
	     }
	}
	catch(InterruptedException e)
	{
	    System.out.println("Error Productor... " + e); 
	}
     }
}
