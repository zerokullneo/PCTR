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

/**Fichero atomicServer.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */
import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
/**Descripcion
 * 
 */
public class atomicServer implements Runnable
{
     static AtomicInteger cont = new AtomicInteger();
     Socket conector;

     public atomicServer(Socket s)
     {
	conector = s;
     }

     public void run()
     {
	try
	{
	     cont.incrementAndGet();
	     conector.close();
	     System.out.println("El contador vale " + cont + " .");
	}
	catch(Exception e)
	{
	     System.out.println("Error ..." + e);
	}
     }

     public static void main(String[] args)
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