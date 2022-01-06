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

//package practica9;

/**Fichero RWFileMonitor.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class RWFileMonitor
{
     volatile int readers = 0;
     volatile boolean writing = false;

     synchronized void StartRead()
     {
	while(writing)
	     try
	     {
		wait();
	     }
	     catch (InterruptedException e)
	     {
		System.out.println("Error lectura..." + e);
                return ;
	     }
	
	readers = readers + 1;
	System.out.println("Lector inicia lectura...");
	notifyAll();
     }

     synchronized void EndRead()
     {
	readers = readers - 1;
	if(readers == 0)
	     notifyAll();
	
	System.out.println("Lector finaliza lectura...");
     }

     synchronized void StartWrite()
     {
	while(writing || (readers != 0))
	     try
	     {
		wait();
	     }
	     catch (InterruptedException e)
	     {
		System.out.println("Error escritura..." + e);
                return ;
	     }
	writing = true;
	System.out.println("Escritor inicia escritura...");
     }

     synchronized void EndWrite()
     {
	writing = false;
	notifyAll();
	System.out.println("Escritor finaliza escritura...");
     }
}
