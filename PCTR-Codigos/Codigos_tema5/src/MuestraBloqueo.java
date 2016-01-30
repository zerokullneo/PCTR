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

/**Fichero MuestraBloqueo.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class MuestraBloqueo implements Runnable
{
     private Object o;

     public MuestraBloqueo(Object p)
     {
	o = p;
     }

     public void run()
     {
	synchronized(o)
	{
	     for(int i=1;i<100;i++)
	     {
		System.out.println("Iteracion "+i+" del hilo "+this.toString());
		for(int j=1;j<100;j++);
	     }
	}
     }

     public static void main(String[] args)
     {
	Object lock = new Object();
	Thread h1 = new Thread(new MuestraBloqueo(lock), "hilo 1");
	Thread h2 = new Thread(new MuestraBloqueo(lock), "hilo 2");
	h1.setPriority(Thread.MIN_PRIORITY);
	h2.setPriority(Thread.MAX_PRIORITY);
	h1.start();
	h2.start();
     }
}