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

package hoja6;

import java.util.concurrent.Semaphore;

/**Fichero incremento.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class incremento extends Thread
{
     private static int n, tipo;
     private static Semaphore em = new Semaphore(1);
     
     public incremento(int nn, int t)
     {
	n = nn;
	tipo = t;
     }
     
     public void run()
     {
	switch(tipo)
	{
	     case 1:
		for(int i = 0; i < 2000; i++)
		{
		     try
		     {
			em.acquire();
		     }catch(InterruptedException e){}
		
		     n++;
		em.release();
		}
		break;
	     case 2:
		for(int i = 0; i < 2000; i++)
		{
		     try
		     {
			em.acquire();
		     }catch(InterruptedException e){}
		     
		     n++;
		em.release();
		}
		break;
	}
     }
     
     public static void main(String[] args) throws InterruptedException
     {
	new incremento(0,1).start();
	new incremento(0,2).start();
	/*incremento p1 = new incremento(0,1);
	incremento p2 =new incremento(0,2);

	p1.start();
	p2.start();
	p1.join();
	p2.join();*/
	System.out.println("variable incrementada: " + n);
     }
}
