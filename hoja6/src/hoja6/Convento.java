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

/**Fichero Convento.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class Convento
{
     private static int monjes, tipo, n;
     private static Semaphore em = new Semaphore(1);
     private static Semaphore espera = new Semaphore(0);
     private static Semaphore cocinero = new Semaphore(n);

     public Convento(int nn, int m, int t)
     {
	monjes = m;
	tipo = t;
	n = nn;
     }
     
     public void run()
     {
	switch(tipo)
	{
	     case 1:
		for(int i = 0; i < n; i++)
		{
		     try
		     {
			em.acquire();
		     }catch(InterruptedException e){}
		
		     monjes++;
		em.release();
		}
		break;
	     case 2:
		for(int i = 0; i < n; i++)
		{
		     try
		     {
			em.acquire();
		     }catch(InterruptedException e){}
		     
		     monjes++;
		em.release();
		}
		break;
	}
     }
     
     public static void main(String[] args) throws InterruptedException
     {
	incremento p1 = new incremento(0,1);
	incremento p2 =new incremento(0,2);

	p1.start();
	p2.start();
	p1.join();
	p2.join();
	System.out.println("variable incrementada: " + monjes);
     }
}
