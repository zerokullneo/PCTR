/*
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

package practica8;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Fichero forkMonitor.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 *
 *
 * Descripcion
 * 
 */
public class forkMonitor
{
	private final int []fork;

	public forkMonitor(int n)
	{
		fork = new int[n];
	}

	public synchronized void takeForks(int i)
	{
		try
		{
			while(fork[i] != 2)
				wait();
			
			fork[i + 1] = fork[i + 1] - 1;
			fork[i - 1] = fork[i - 1] - 1;
		}
		catch (InterruptedException ex)
		{
			Logger.getLogger(forkMonitor.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public synchronized void releaseForks(int i)
	{
		fork[i + 1] = fork[i + 1] + 1;
		fork[i - 1] = fork[i - 1] + 1;

		while(fork[i + 1] == 2)
			notifyAll();
		while(fork[i - 1] == 2)
			notifyAll();
	}
}
