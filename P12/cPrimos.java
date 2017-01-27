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

package practica12;

/**Fichero cPrimos.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

import java.util.*;
import java.net.*;
import java.rmi.*;
import java.text.*;

/**Descripcion
 * 
 */
public class cPrimos
{
     public static void main(String[]args)
     {
	try
	{
	     iPrimos OR1 = (iPrimos)Naming.lookup("//localhost/Servidor-1");
	     iPrimos OR2 = (iPrimos)Naming.lookup("//localhost/Servidor-2");
	     iPrimos OR3 = (iPrimos)Naming.lookup("//localhost/Servidor-3");
	     iPrimos OR4 = (iPrimos)Naming.lookup("//localhost/Servidor-4");

	     int nNuc = Runtime.getRuntime().availableProcessors();
	     Scanner leer = new Scanner(System.in);
	     System.out.println("Introducir rango:");
	     int linf = leer.nextInt();//Limite inferior del rango
	     int lsup = leer.nextInt();//Limite superior del rango
	     int Total = 0;
	     int tbloque = (int)(lsup-linf)/nNuc;//tBloque sera el rango de cada hilo
	     lsup = linf + tbloque;

	     iPrimos [] v = new iPrimos[nNuc];
	     v[0] = OR1;
	     v[1] = OR2;
	     v[2] = OR3;
	     v[3] = OR4;

	     Date d = new Date();//Objeto de la clase Date
	     DateFormat df = new SimpleDateFormat("HH:mm:ss:SSS");
	     long inicCronom = System.currentTimeMillis();//se prepara el cronometro
	     d.setTime(inicCronom);//activaci�n del cronometro

	     for(int i = 0; i < v.length; i++)
	     {
		Total += v[i].NumPrimos(linf,lsup);
		linf=lsup;
		lsup = lsup + tbloque;
	     }

	     long finCronom = System.currentTimeMillis();//se detiene el cronometro
	     d.setTime(finCronom);
	     System.out.println("En el rango especificado hay " + Total + " numeros primos...");
	     System.out.println("Tiempo total de analisis:" + (finCronom - inicCronom) + " milisegundos");
	}
	catch(Exception e)
	{
	     System.out.println("Error en el cliente cPrimos..." + e);
	}
     }
}