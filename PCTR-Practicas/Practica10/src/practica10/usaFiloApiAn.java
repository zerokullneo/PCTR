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

package practica10;

/**Fichero usaFiloApiAn.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */
import java.util.concurrent.*;
/**Descripcion
 * 
 */
public class usaFiloApiAn implements Runnable
{
     static filoApiAN mesa = new filoApiAN();
     int i;

     usaFiloApiAn(int i)
     {
	this.i = i;
     }

     @Override
     public void run()
     {
	try
	{
	     mesa.EmpezarComer(i);
	     System.out.println("Filosofo " + (i + 1) + " comiendo...");
	     mesa.DejarComer(i);
	     System.out.println("Filosofo " + (i + 1) + " ha terminado.");
	}
	catch(InterruptedException e)
	{
	     System.out.println("ERROR ejecucion filosofos..." + e);
	}
     }

     public static void main(String[] args)
     {
	usaFiloApiAn[] filosofos = new usaFiloApiAn[5];
	ExecutorService ejecutor = Executors.newFixedThreadPool(5);

	for(int i = 0; i < filosofos.length; i++)
	{
	     filosofos[i] = new usaFiloApiAn(i);
	     ejecutor.execute(filosofos[i]);
	}
	ejecutor.shutdown();
	while(!ejecutor.isTerminated()){}
     }
}