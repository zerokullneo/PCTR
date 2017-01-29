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

package practica5;

import java.lang.*;
import java.io.*;
import java.util.*;

/**Fichero algDekker.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class algDekker extends Thread
{
     public static volatile long max = 10000000;
     public static volatile long turno;
     public static volatile long[] turnos;
     public static volatile int indice = 0;
     public static volatile boolean[] permisos;
     public static volatile int n = 0;

     public void run()
     {
	for(int i = 0; i < max; ++i)
	{
	     String name = this.getName();
	     int numThread = Integer.parseInt(name.replace("Thread-", ""));
	     //System.out.println(numThread);
	     int otroThread = 0;
	     switch(numThread)
	     { //modificacion, añadimos los 3 casos sobrelos 3 hilos.
		case 0:
		     otroThread = 1;
		     break;
		case 1:
		     otroThread = 2;
		     break;
		case 2:
		     otroThread = 0;
		     break;
		default:
		     break;
	     }

	     permisos[numThread] = true;

	     while(permisos[otroThread] == true)
	     {
		if(turno == this.getId())
		{
		     permisos[numThread] = false;
		     while(turno == this.getId()){yield();}
		     permisos[numThread] = true;
		}
	     }

	     //Sección crítica
	     n++;

	     //Post-protocolo
	     if(indice == 2) //modificacion
	          indice = 0;//añadimos una posicion mas
	     else
	          if(indice == 1)
		     indice = 2;
		else
		     indice = 1;     

	     turno = turnos[indice];
	     permisos[numThread] = false;
	}
     }

     public static void main(String[] args) throws InterruptedException 
     {
        algDekker t1 = new algDekker();
	algDekker t2 = new algDekker();
	algDekker t3 = new algDekker();

	turnos = new long[3];
	turnos[0] = t1.getId();
	turnos[1] = t2.getId();
	turnos[2] = t3.getId();
	turno = turnos[0];

	permisos = new boolean[3];
	for(int i = 0; i < 3; ++i) 
	     permisos[i] = true;

	t1.start();
	t2.start();
	t3.start();
		
	try
	{
	     t1.join();
	     t2.join();
	     t3.join();
	     System.out.println("Valor de variable compartida: " + n);
	     System.out.println("Valor correcto de variable compartida: " + 3*max);
	}
	catch(InterruptedException e)
	{
	     System.out.println("--" + e + "--");
     	}
     }
}
