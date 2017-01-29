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

/**Fichero ServidorHilosinPool.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class ServidorHilosinPool extends Thread
{
    private static Socket enchufe;
    private static boolean condicion;

    public ServidorHilosinPool(Socket s)
    {
        enchufe = s; this.start();
    }

    public synchronized void ConexionEntrante()
    {
        try
	{
	    BufferedReader entrada = new BufferedReader(new InputStreamReader(enchufe.getInputStream()));
	    String datos = entrada.readLine();
	    int j;
	    int i = Integer.valueOf(datos).intValue();

	    for(j=1; j<=10; j++)
	    {
                System.out.println("El hilo "+this.getName()+" escribiendo el dato " + i);
		sleep(1000);
	    }

	    System.out.println("El hilo "+this.getName()+"cierra su conexion...");
	}
	catch(Exception e)
	{
	     System.out.println("Error en ConexionEntrante..." + e);
	}
    }

    public synchronized void run()
    {
        while(condicion == false)
	ConexionEntrante();
    }

    public static void main (String[] args)
    {
        int i;
	int puerto = 2001;

	try
	{
	    ServerSocket chuff = new ServerSocket(puerto, 3000);

	    while(true)
	    {
                System.out.println("Esperando solicitud de conexion...");
		Socket cable = chuff.accept();
		System.out.println("Recibida solicitud de conexion...");
		new ServidorHilosinPool(cable);
		Thread tel1 = new Thread(new ServidorHilosinPool(cable));
		Thread tel2 = new Thread(new ServidorHilosinPool(cable));
		Thread tel3 = new Thread(new ServidorHilosinPool(cable));

                tel1.start();
		tel2.start();
		tel3.start();
		tel1.join();
		tel2.join();
		tel3.join();
		cable.close();
	    }
	}
	catch(Exception e)
	{
	    System.out.println("Error en sockets..." + e);
	}
    }
}