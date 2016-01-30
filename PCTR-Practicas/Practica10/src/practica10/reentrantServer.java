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

/**Fichero reentrantServer.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */
import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
/**Descripcion
 * 
 */
public class reentrantServer implements Runnable
{
     static ReentrantLock cerrojo=new ReentrantLock();
     static int n = 0;
     Socket conector;

     public reentrantServer(Socket s)
     {
	conector = s;
     }

     public void run()
     {
	cerrojo.lock();

	try
	{
	     conector.close();
	     n++;
	     System.out.println("El contador vale " + n + ".");
	}
	catch(Exception e)
	{
	     System.out.println("Error ..." + e);
	}
	finally
	{
	     cerrojo.unlock();
	}
     }

     public static void main (String[] args)
     {
	ExecutorService ejecutor = Executors.newCachedThreadPool();
	int puerto = 2001;

	try
	{
	     ServerSocket chuff = new ServerSocket (puerto, 3000);
	     while(true)
	     {
		System.out.println("Esperando solicitud de conexion...");
		Socket cable = chuff.accept();
		System.out.println("Recibida solicitud de conexion...");
		ejecutor.execute(new atomicServer(cable));
	     }
	}
	catch(Exception e)
	{
	     System.out.println("Error en sockets..." + e);
	}
     }
}