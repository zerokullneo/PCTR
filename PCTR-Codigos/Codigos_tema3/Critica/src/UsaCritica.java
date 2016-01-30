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

/**Fichero UsaCritica.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class UsaCritica extends Thread
{
     public void run()
     {
	Critica ref = new Critica();
	for(int i = 0; i < 10000; i++)
	     ref.inc();
     }
     
     public static void main (String [] args) throws InterruptedException
     {
	Critica P = new Critica();
	UsaCritica []h = new UsaCritica[4];

	for(int i = 0; i < h.length; i++)
	     h[i] = new UsaCritica();
	for(int i = 0; i < h.length; i++)
	     h[i].start();
	for(int i = 0; i < h.length; i++)
	     h[i].join();
	
	System.out.println(P.get());
     }
}
