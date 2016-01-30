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

/**Fichero prueba_var_atomic.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

import java.util.concurrent.atomic.*;
import java.util.concurrent.*;

class Hilo implements Runnable
{
     AtomicInteger cont; //Instancia compartida por todas las tareas
     int valor;

     public Hilo(AtomicInteger cont){this.cont=cont;}

     public void run()
     {
	for(int i=0; i<1000; i++)valor = this.cont.incrementAndGet();
     }
}

/**Descripcion
 * 
 */
public class prueba_var_atomic
{
     public static void main(String[] args)throws Exception
     {
	AtomicInteger cont = new AtomicInteger(0);
	ThreadPoolExecutor miPool = new ThreadPoolExecutor(10, 10, 60000L,TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
	miPool.prestartAllCoreThreads();
	Hilo[] tareas = new Hilo[100];

	for (int i=0; i<100; i++)
	{
	     tareas[i] = new Hilo(cont);
	     miPool.execute(tareas[i]);
	}
		
	miPool.shutdown();
	Thread t= Thread.currentThread();
	t.sleep(3000);
	System.out.println(cont.get());
     }
}
