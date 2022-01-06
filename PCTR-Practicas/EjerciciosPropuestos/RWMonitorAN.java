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

/**Fichero RWMonitorAN.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */
import java.io.RandomAccessFile;
import java.io.File;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import java.util.Random;
/**Descripcion
 * 
 */
public class RWMonitorAN
{
     volatile int readers = 0;
     volatile boolean writing = false;
     ReentrantLock l = new ReentrantLock();
     Condition c1 = l.newCondition();
     Condition c2 = l.newCondition();

     synchronized void StartRead()
     {
	l.lock();
	while(writing)
	     try
	     {
		c1.await();
	     }
	     catch (InterruptedException e)
	     {
		System.out.println("Error lectura..." + e);
	     }
	
	readers = readers + 1;
	System.out.println("Lector inicia lectura...");
	c1.signalAll();
	l.unlock();
     }

     synchronized void EndRead()
     {
	readers = readers - 1;
	if(readers == 0)
	     notifyAll();
	
	System.out.println("Lector finaliza lectura...");
     }

     synchronized void StartWrite()
     {
	l.lock();
	while(writing || (readers != 0))
	     try
	     {
		c2.await();
	     }
	     catch (InterruptedException e)
	     {
		System.out.println("Error escritura..." + e);
	     }
	writing = true;
	System.out.println("Escritor inicia escritura...");
	c2.signalAll();
	l.unlock();
     }

     synchronized void EndWrite()
     {
	writing = false;
	notifyAll();
	System.out.println("Escritor finaliza escritura...");
     }
}
