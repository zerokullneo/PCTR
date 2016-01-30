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

/**Fichero filoApiAN.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**Descripcion
 * 
 */
public class filoApiAN
{
     private boolean[] tenedores = new boolean[5];
     ReentrantLock bloqueo = new ReentrantLock();
     Condition cerrojo = bloqueo.newCondition();

     filoApiAN()
     {
	for(int i = 0; i < tenedores.length; i++)
	     tenedores[i] = true;
     }

     public void EmpezarComer(int i) throws InterruptedException
     {
	bloqueo.lock();
	try
	{
	     while(!tenedores[i] || !tenedores[(i + 1) % 5])
		cerrojo.await();

	     tenedores[i] = false;
	     tenedores[(i + 1) % 5] = false;
	}
	finally
	{
	     bloqueo.unlock();
	}
     }

     public void DejarComer(int i)
     {
	bloqueo.lock();
	try
	{
	     tenedores[i] = true;
	     tenedores[(i + 1) % 5] = true;
	     cerrojo.signalAll();
	}
	finally
	{
	     bloqueo.unlock();
	}
     }
}