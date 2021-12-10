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
package practica8;

import static java.lang.Thread.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zerokullneo
 */
public class usaforkMonitor implements Runnable
{
	private static int N;
	private static forkMonitor mon;

	public usaforkMonitor()
	{
		N = 5;
		mon = new forkMonitor(N);
	}

	public void run()
	{
		int i;
		for(;;)
		{
			try
			{
				i = (int) (Math.random()*5);
				//System.out.println("iteracion: " + i);
				mon.takeForks(i);
				sleep(1000);
				mon.releaseForks(i);
				sleep(1000);
			}
			catch (InterruptedException ex)
			{
				Logger.getLogger(usaforkMonitor.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	public static void main(String[] args)
	{
		int Nf = 5;
		
		ExecutorService ej = Executors.newFixedThreadPool(Nf);

		for(int i = 0; i < Nf; i++)
			ej.execute(new usaforkMonitor());

		//ej.shutdown();
		//while(!ej.isTerminated()){}
	}
}
