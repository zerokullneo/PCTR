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

package practica3;

import java.lang.*;
import java.io.*;
import java.util.*;

/**Fichero escalaVector.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class escalaVector
{
     private static int MAX=1000000;

     public static void main(String args[]) throws IOException
     {
	InputStreamReader entrada = new InputStreamReader(System.in);
	BufferedReader lectura = new BufferedReader(entrada);
	Random r = new Random();
	int []vector = new int[MAX];
	int i, f;
		
	for(i = 0; i < MAX; i++)
	     vector[i] = r.nextInt(11-1)+1;
	//se muestran las 3 primeras posiciones a valor informativo de que se cumple la propiedad
	System.out.println("Vector: " + vector[0] + ", " + vector[1] + ", " + vector[2]);
		
	System.out.println("Introduzca el factor multiplicativo:");
	f = Integer.parseInt(lectura.readLine());

	for(i = 0; i < MAX; i++)
	     vector[i] = vector[i] * f;
	//se muestran las 3 primeras posiciones a valor informativo de que se cumple la propiedad
	System.out.println("Vector: " + vector[0] + ", " + vector[1] + ", " + vector[2]);
     }
}
