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

import java.util.concurrent.*;

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
		mon.takeForks(N);
		mon.releaseForks(N);
	}

	public static void main(String[] args)
	{
		int Nf = 5;
		
		ExecutorService ej = Executors.newFixedThreadPool(Nf);

		for(int i = 0; i < Nf; i++)
			ej.execute(new usaforkMonitor());

		ej.shutdown();
		while(!ej.isTerminated()){}
	}
}
