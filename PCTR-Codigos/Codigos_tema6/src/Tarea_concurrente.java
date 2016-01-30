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

/**Fichero Tarea_concurrente.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */
import java.util.concurrent.*;
/**Descripcion
 * 
 */
public class Tarea_concurrente extends Thread
{
	Semaphore s;
	private static int c = 0;
	
	public Tarea_concurrente(Semaphore param){s = param;}

	public int verC(){return c;}

	public void run ()
	{
		for(int i = 0; i < 1000; i++)
		{
			try
			{
				s.acquire();
			}
			catch(InterruptedException e)
			{
			     System.out.println("ERROR CRITICO..." + e);
			}
			c++;
			//System.out.println("Hilo "+this.getName()+" entrando a seccion critica");
			s.release();
			//System.out.println("Hilo "+this.getName()+" saliendo de seccion critica");
			c--;
		}
	}
}
