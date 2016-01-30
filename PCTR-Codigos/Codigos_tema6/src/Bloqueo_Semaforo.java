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

import java.util.concurrent.*;

/**Fichero Bloqueo_Semaforo.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class Bloqueo_Semaforo
{
     public static void main(String[] args) throws InterruptedException
     {
	Semaphore sem = new Semaphore (2);
	sem.acquire(2);
	System.out.println("Semaforo actualizado a valor 0...");
	System.out.println("y su estado es: "+sem.toString());
	System.out.println("Ahora intentamos adquirirlo...");
	sem.tryAcquire();
	System.out.println("sin bloqueo por no conseguirlo");
	System.out.println("Ahora intentamos adquirirlo...");
	sem.tryAcquire(3L, TimeUnit.SECONDS);
	System.out.println("tras esperar lo indicado sin consguirlo...");
	sem.acquire();
	System.out.println("Aqui no llegaremos nunca...");
     }
}
