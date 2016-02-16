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

package practica11;

/**Fichero cBonoloto.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

import java.util.*;
import java.net.*;
import java.rmi.*;

/**Descripcion
 * 
 */
public class cBonoloto
{
     public static void main(String[]args)
     {
	try
	{
	     iBonoloto ORemoto = (iBonoloto)Naming.lookup("//localhost/Servidor");
	     ORemoto.resetServidor();
	     int [] a = new int[6];
	     Scanner p = new Scanner(System.in);

	     System.out.println("Introduce apuesta:");

	     for(int i = 0; i < 6; i++)
		a[i] = p.nextInt();

	     boolean acierto = ORemoto.compApuesta(a);

	     if(acierto)
		System.out.println("Apuesta premiada");
	     else
		System.out.println("Apuesta no premiada");

	}
	catch(Exception e)
	{
	     System.out.println("Problema en cliente..." + e);
	}

	System.out.println("Cliente Terminado.");
     }
}
