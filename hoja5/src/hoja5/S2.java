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

package hoja5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**Fichero S2.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * clase que engloba a S1
 */
public class S2
{
     private static final Object semaforo = new Object();
     private static int contador = 0;

     public static void esperar() throws InterruptedException
     {
	synchronized(semaforo)
	{
	     if(contador > 0)
		semaforo.wait();
	     contador--;
	}
     }
     
     public static void senalar()
     {
	synchronized(semaforo)
	{
	     if(contador <= 0)
		semaforo.notify();
	     contador++;
	}
     }

     public static void main(String[] args) throws InterruptedException
     {
	S1 exmt1[] = new S1[1];
	S1 exmt2[] = new S1[1];

	ExecutorService e = Executors.newCachedThreadPool();
	e.execute(exmt1[0] = new S1(1));
	e.execute(exmt2[0] = new S1(1));

	e.shutdown();
	System.out.println(	"El total es: " + contador);
     }
}
