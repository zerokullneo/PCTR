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
/**Fichero volcadoRedSecuencial.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class volcadoRedSecuencial
{
     public static void navegarURL(String d, int i)
     {
	String dir=d;
	String datos;
	RandomAccessFile volcado;
	URL url;
	Integer j=new Integer(i);

	try
	{
	     url =  new URL(dir);
	     System.out.println("Contactando con "+dir);
	     String name = j.toString()+".html";
	     volcado = new RandomAccessFile(name, "rw");
	     BufferedReader lector = new BufferedReader(new InputStreamReader(url.openStream()));
	     do
	     {
		datos = lector.readLine();
		if(datos!=null)
		     volcado.writeChars(datos);
	     }while(datos!=null);
	     volcado.close();
	}
	catch(IOException e){System.out.println("Error - RedSecuencial: " + e);}
     }

     public static void main(String[] args)
     {
	long iniTiempo = System.nanoTime();
	try
	{
            int cont=0;
	    String linea=" ";
	    RandomAccessFile direcciones = new RandomAccessFile("direccionesRed.txt","r");
	    while(linea!=null)
	    {
		linea =(String)direcciones.readLine();
		if(linea!=null)
		     navegarURL(linea, cont);
		cont++;
	    }
	     direcciones.close();
	}
	catch(FileNotFoundException e) {System.out.println(e);}
	catch(IOException e) {System.out.println(e);}
	
	long finTiempo = System.nanoTime();
	System.out.println("Tiempo Total (segundos): "+(finTiempo-iniTiempo)/1.0e9);
     }
}
