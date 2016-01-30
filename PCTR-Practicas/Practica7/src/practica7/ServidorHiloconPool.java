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

package practica7;

import java.net.*;
import java.io.*;

/**Fichero ServidorHiloconPool.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class ServidorHiloconPool implements Runnable
{
     Socket enchufe;
     public ServidorHiloconPool(Socket s)
     {
     	enchufe = s;
     }

     public synchronized void run()
     {
	try
	{
	     BufferedReader entrada = new BufferedReader(new InputStreamReader(enchufe.getInputStream()));
	     String datos = entrada.readLine();
	     int j;
	     int i = Integer.valueOf(datos).intValue();

	     for(j=1; j<=10; j++)
	     {
		System.out.println("El hilo " + this.getClass().getName() + " escribiendo el dato " + i);
		Thread.currentThread().sleep(1000);//especifico para la clase Runnable.
	     }

	     enchufe.close();
	     System.out.println("El hilo " + this.getClass().getName() + "cierra su conexion...");
	}
	catch(Exception e)
	{
	     System.out.println("Error...");
	}
     }//run

     public static void main (String[] args)
     {
	int puerto = 2001;

	try
	{
	     ServerSocket chuff = new ServerSocket(puerto, 3000);

	     while(true)
	     {
		System.out.println("Esperando solicitud de conexion...");
		Socket cable = chuff.accept();
		System.out.println("Recibida solicitud de conexion...");
		new ServidorHiloconPool(cable);
	     }
	}
	catch(Exception e)
	{
	     System.out.println("Error en sockets..." + e);
	}
     }
}
