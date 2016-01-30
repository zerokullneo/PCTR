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

package hoja8;

import java.util.concurrent.*;

/**Fichero Filosofo.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class Filosofo implements Runnable
{
     private int idFil;
     protected static Semaphore espera = new Semaphore(1);
     private static Semaphore[] cuchara = new Semaphore[5];

     public Filosofo(int idfil)
     {
	idFil=idfil;
     }

     public void run()
     {
	for(;;)
	{
	     try
	     {
		System.out.println("Filosofo.." + idFil + "..pensando");
		espera.acquire(0);
		cuchara[idFil].acquire();
		cuchara[(idFil+1)%5].acquire();
		System.out.println("Filosofo.." + idFil + "..zampando");
		cuchara[idFil].release();
		cuchara[(idFil+1)%5].release();
		espera.release(1);
	     }
	     catch(InterruptedException e)
	     {
		System.out.println("Error: " + e);
	     }
	}
     }

     public static void main(String args[])
     {
	int nFil = 5;
	ExecutorService ejecutor = Executors.newFixedThreadPool(nFil);

	for(int i = 0; i < nFil; i++)
	     Filosofo.cuchara[i]= new Semaphore(1);

	for(int j = 0; j < nFil; j++)
	     ejecutor.execute(new Filosofo(j));
	ejecutor.shutdownNow();
     }
}
