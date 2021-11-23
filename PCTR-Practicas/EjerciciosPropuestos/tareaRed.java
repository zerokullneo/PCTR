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

package practica6;

import java.util.*;
import java.io.*;
import java.net.*;

/**Fichero tareaRed.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class tareaRed implements Runnable
{
     private String dir;
     private String datos;
     private RandomAccessFile volcado;
     private URL url;
     private Integer j;

     public tareaRed(String d, int i)
     {
	dir=d;
	j=new Integer(i);
     }

     public void run()
     {
	try
	{
	     url =  new URL(dir);
	}
	catch(MalformedURLException e)
        {
            System.out.println("ERROR - tareaRed: " + e);
        }
	
	System.out.println("Contactando con " + dir);
	
	try
	{
	     String name = j.toString()+".html";
	     volcado = new RandomAccessFile(name, "rw");
	     BufferedReader lector = new BufferedReader(new InputStreamReader(url.openStream()));
	     do
	     {
		datos = lector.readLine();
		if(datos!=null)
		     volcado.writeChars(datos);

		//System.out.println("escribiendo...");
	     }while(datos!=null);
	     volcado.close();
	}
	catch(IOException e)
        {
            System.out.println("ERROR - tareaRed: " + e);
        }
     }
}
