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

package practica9;

import java.io.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**Fichero UsaRWFileMonitor.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class UsaRWFileMonitor implements Runnable
{
     private static final int N = 10;
     RandomAccessFile fichero;
     private static RWFileMonitor raw = new RWFileMonitor();

     UsaRWFileMonitor(RandomAccessFile file)
     {
	fichero = file;
     }

     public void run()
     {
	try
	{
	     while(fichero.getFilePointer() <= fichero.length())
		System.out.println(fichero.readChar());
	     raw.StartRead();
	     raw.EndRead();
	     raw.StartRead();
	     raw.EndRead();
	     raw.StartRead();
	     raw.EndRead();
	}
	catch (EOFException e)
	{
	     System.out.println("ERROR apertura de fichero..." + e);
	}
	catch(IOException ex)
	{
	     Logger.getLogger(UsaRWFileMonitor.class.getName()).log(Level.SEVERE, null, ex);
	}
     }

     public static void main(String[] args) throws Exception
     {
	File ruta = new File("datos.dat");
	ExecutorService ej = Executors.newFixedThreadPool(N);
	
	
	     RandomAccessFile fich = new RandomAccessFile(ruta, "r");
	     
	     for(int i = 0; i < N; i++)
		ej.execute(new UsaRWFileMonitor(fich));

	     ej.shutdown();
	     while(!ej.isTerminated()){}

	     fich.close();
       }
}
