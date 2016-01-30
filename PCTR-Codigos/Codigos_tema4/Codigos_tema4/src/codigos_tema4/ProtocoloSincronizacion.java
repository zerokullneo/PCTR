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

import java.util.concurrent.*;

/**Fichero ProtocoloSincronizacion.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class ProtocoloSincronizacion extends Thread
{
     private int tipoHilo;
     private static int nVueltas = 1000000;
     private static int n = 0;
     private static Semaphore s = new Semaphore(0);

     public ProtocoloSincronizacion(int tipoHilo)
     {
	this.tipoHilo=tipoHilo;
     }
     
     public void run()
     {
	switch(tipoHilo)
	{
	     case 1:
	     {
		for(int i=0; i<nVueltas; i++)
		{
		     System.out.println("Aumentando... "+ n);
		     s.release(); //signal(S)
		     n++;
		}
		break;
	     }
	     case 2:
	     {
		for(int i=0; i<nVueltas;i++)
		{//wait(S)
     		     System.out.println("Dismenuyendo... "+ n);
		     try
		     {
			s.acquire();
		     }
		     catch(InterruptedException e){System.out.println("Error: " + e);}
		     n--;
		}
		break;
	     }
	}
     }

     public static void main(String[] args)throws InterruptedException
     {
	ProtocoloSincronizacion h1 = new ProtocoloSincronizacion(1);
	ProtocoloSincronizacion h2 = new ProtocoloSincronizacion(2);

	h1.start();
	h2.start();
	h1.join();
	h2.join();
	System.out.println(n);
     }
}
