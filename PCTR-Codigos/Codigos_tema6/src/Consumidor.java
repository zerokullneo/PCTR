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

/**Fichero Consumidor.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */
import java.util.concurrent.*;
/**Descripcion
 * 
 */
public class Consumidor implements Runnable
{
     LinkedBlockingQueue<Integer> data;
     Thread hilo;

     public Consumidor(LinkedBlockingQueue<Integer> l)
     {
	this.data = l;
	hilo = new Thread (this);
	hilo.start();
     }

     public void run()
     {
	try
	{
  		for(;;)
  	      System.out.println("Extrayendo " + data.take().intValue());
	}
	catch(InterruptedException e)
	{
	     System.out.println("Error Consumidor... " + e);
	}
     }
}