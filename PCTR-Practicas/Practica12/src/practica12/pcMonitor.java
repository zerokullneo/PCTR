/**
 * Copyright (C) 2017 Jose Manuel Barba Gonzalez <zk at wordpress.com>
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

package practica12;

import java.util.concurrent.Semaphore;

/**Fichero pcMonitor.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class pcMonitor extends Thread
{
    private static int tamBuffer = 100, n = 1000;
    private static double [] buffer;
    private static int InPtr = 0;
    private static int OutPtr = 0;
    protected Object Cerrojo = new Object ();
    private static Semaphore em = new Semaphore(1);
    private static Semaphore espacios  = new Semaphore(tamBuffer);
    private static Semaphore elementos = new Semaphore(0);

    private int tipoHilo;

    public pcMonitor(int tipo)
    {
        tipoHilo = tipo;
        buffer = new double[tamBuffer];
    }

    public  void run()
    {
        switch(tipoHilo)
	{
	    case 0:
	    {synchronized(Cerrojo){
                for(int i = 0; i < n; ++i)
		{
		    try
		    {
                        espacios.acquire();
		    }
		    catch(InterruptedException e)
                    {
                        System.out.println("elementos productor... " + e);
                    }
		    try
		    {
                        em.acquire();
		    }
                    catch(InterruptedException e)
                    {
                        System.out.println("exclusion mutua productor... " + e);
                    }

                    buffer[InPtr] = Math.random();
		    System.out.println("Hilo productor insertando " + buffer[InPtr] + " en buffer");
		    
                    InPtr = (InPtr + 1) % tamBuffer;

                    em.release();
		    elementos.release();
                    
		}
                }
	    }
	    case 1:
	    {synchronized(Cerrojo){
                for(int i = 0; i < n/2; ++i)
		{
		    try
		    {
                        elementos.acquire();
		    }
		    catch(InterruptedException e)
                    {
                        System.out.println("elementos consumidor... " + e);
                    }
		    try
		    {
                        em.acquire();
		    }
		    catch(InterruptedException e)
                    {
                        System.out.println("exclusion mutua consumidor... " + e);
                    }

                    System.out.println("Hilo consumidor extrayendo " + buffer[OutPtr] + " de buffer");
                    OutPtr = (OutPtr + 1) % tamBuffer;
		    
                    em.release();
                    espacios.release();
		}
                }
	    }
	}
    }
}