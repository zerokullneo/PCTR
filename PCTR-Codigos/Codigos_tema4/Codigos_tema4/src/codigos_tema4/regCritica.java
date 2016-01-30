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

/**Fichero regCritica.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class regCritica extends Thread
{
     private static int n = 0; //RECURSO COMPARTIDO...
     private int tipoHilo;
     private static int nVuel = 10000;
     private static Object cerrojo = new Object();

     public regCritica(int t)
     {
	this.tipoHilo = t;
     }

     public void run()
     {
	switch(tipoHilo)
	{
	     case 1:
	     {
		for(int i=0; i<nVuel; i++)
		     synchronized(cerrojo){n++;} //region critica...
		break;
	     }
	     case 2:
	     {
		for(int j=0; j<nVuel; j++)
		     synchronized(cerrojo){n--;} //region critica...
		break;
	     }
	}
     }

     public static void main(String[] args) throws InterruptedException
     {
	regCritica h1 = new regCritica(1);
	regCritica h2 = new regCritica(2);

	h1.start();
	h2.start();
	h1.join();
	h2.join();
	
	System.out.println(n);
    }
}
