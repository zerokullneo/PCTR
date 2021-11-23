/**
 * Copyright (C) 2021 Jose Manuel Barba Gonzalez <zk at wordpress.com>
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
package practica6;

import java.util.*;
import java.io.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

/**Fichero usaheterogenea.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * Clase para realizar pruebas con un Pool de Threads las "nVueltas" indicadas 
 * sobre la clase heterogenea.
 */
public class usaheterogenea
{
	public static void main(String[] args)
	{
		int nNuc = Runtime.getRuntime().availableProcessors();
		float Cb = 0.5f;
		int tampool = (int)(nNuc/(1-Cb));
		int nVueltas = 10000;
		AtomicInteger nn= new AtomicInteger(0);

		LinkedList<heterogenea> hebrasHeterogenea = new LinkedList<>();
		ThreadPoolExecutor ept = new ThreadPoolExecutor(tampool, tampool, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
		ept.prestartAllCoreThreads();
		
		for(int it = 0; it < tampool; it++)
			hebrasHeterogenea.add(new heterogenea(nn, 0, nVueltas));
		
		for(Iterator itHebra = hebrasHeterogenea.iterator(); itHebra.hasNext();)
			ept.execute((Runnable)itHebra.next());
		
		ept.shutdown();
		while(!ept.isTerminated()){}

		System.out.println("Variable n: " + hebrasHeterogenea.getLast().getN());
		System.out.println("Variable m: " + hebrasHeterogenea.getLast().getM());
	}
}
