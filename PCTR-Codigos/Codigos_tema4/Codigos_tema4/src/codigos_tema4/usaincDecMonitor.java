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

package codigos_tema4;

/**Fichero usaincDecMonitor.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class usaincDecMonitor implements Runnable
{
     public static incDecMonitor monitor = new incDecMonitor();
     public int tipoHilo, max;

     public usaincDecMonitor(int tipoHilo, int m)
     {
	this.tipoHilo = tipoHilo;
	max = m;
     }

     public void run()
     {
	switch(tipoHilo)
	{
	     case 0:
		for(int i = 0; i < max; i++)
		     monitor.inc();
		break;
	     case 1:
		for(int i = 0; i < max; i++)
		     monitor.dec();
		break;
	}
     }

     public static void main(String[] args)
     {
	Thread p = new Thread(new usaincDecMonitor(0,1000000));
	Thread q = new Thread(new usaincDecMonitor(1,1000000));

	p.start();
	q.start();
	
	try
	{
	     p.join();
	     q.join();
	}
	catch(InterruptedException e)
	{
	     System.out.println("Error: " + e);
	}

	System.out.println("" + monitor.ver());
     }
}
