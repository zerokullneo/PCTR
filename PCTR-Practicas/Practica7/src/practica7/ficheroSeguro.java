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

import java.util.*;
import java.io.*;
import java.util.concurrent.*;
import java.util.Scanner;

/**Fichero ficheroSeguro.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class ficheroSeguro 
{
    private String dir;
    private String datos;
    private RandomAccessFile volcado;
    private Integer j;

    public ficheroSeguro(String d, int i)
    {
	dir=d;
	j=new Integer(i);
    }

    public void run()
    {
        synchronized(this)
	{
            try
	    {
		String name = j.toString() + dir + ".html";
		volcado = new RandomAccessFile(name, "rw");
		do
		{
		     datos = volcado.readLine();
		     if(datos!=null)
			volcado.writeChars(datos);
		}while(datos!=null);
		volcado.close();
	    }
            catch(IOException e)
	    {
                System.out.println("ERROR..." + e);
	    }
	}
    }

    public static void main(String[] args) throws Exception
    {
	long iniTiempo=0;
	LinkedList<ficheroSeguro> tareas = new LinkedList<ficheroSeguro>();
	int nNuc = Runtime.getRuntime().availableProcessors();
	float Cb = 0;
	int tamPool = (int)(nNuc/(1-Cb));
	ThreadPoolExecutor ept = new ThreadPoolExecutor(tamPool,tamPool,0L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());

	ept.prestartAllCoreThreads();
	try
	{
	     int cont = 0;
	     String linea=" ";      
	     RandomAccessFile direcciones = new RandomAccessFile("/home/zerokullneo/github/netbeans/Pctr-Practicas/practica7/src/practica7/direccionesRed.txt","r");
	     iniTiempo = System.nanoTime();
	     while(linea!=null)
	     {
		linea =(String)direcciones.readLine();
		if(linea!=null)tareas.add(new ficheroSeguro(linea, cont));
		cont++;
	     }
	     direcciones.close();
	}
	catch (EOFException e)
        {
            System.out.println("Error EOF: " + e);
        }
	
	for(Iterator iter = tareas.iterator(); iter.hasNext();) 
	     ept.execute((Runnable)iter.next());

	ept.shutdown();
	while(!ept.isTerminated()){}

	long finTiempo = System.nanoTime();
	System.out.println("Numero de Nucleos: " + nNuc);
	System.out.println("Coficiente de Bloqueo: " + Cb);
	System.out.println("Tamano del Pool: " + tamPool);
	System.out.println("Tiempo Total (segundos): " + (finTiempo-iniTiempo)/1.0e9);                              
     }
}
