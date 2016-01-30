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

/**Fichero tryTwo.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class tryTwo extends Thread
{
     private int tipoHilo;
     private static volatile int nVueltas = 1000000;
     private static volatile int n = 0;
     private static volatile boolean C1 = false;
     private static volatile boolean C2 = false;

     public tryTwo(int tipoHilo)
     {
	this.tipoHilo = tipoHilo;
     }

     public void run()
     {
	switch(tipoHilo)
	{
	     case 1:
	     {
		for(int i=0; i<nVueltas; i++)
		{
		     while(C2==true);
		     C1 = true;
		     n++;
		     C1 = false;
		}
		break;
	     }
	     case 2:
	     {
		for(int i=0; i<nVueltas;i++)
		{
		     while(C1==true);
		     C2 = true;
		     n--;
		     C2 = false;
		}
		break;
	     }
	}
     }

     public static void main(String[] args) throws InterruptedException
     {
	tryTwo h1 = new tryTwo(1);
	tryTwo h2 = new tryTwo(2);

	h1.start();
	h2.start();
	h1.join();
	h2.join();
	System.out.println(n);
    }
}
