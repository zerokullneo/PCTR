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

/**Fichero Ack.java 
  *@author Jose Manuel Barba Gonzalez
  *@version 1.0
  *Programacion Concurrente y de Tiempo Real
  *Area de CC. de la Computacion e I.A.
*/

import java.lang.*;
import java.io.*;

public class Ack
{
     /**
      * @param m Primer número natural
      * @param n Segundo número natural
      * @return Retorna la multiplicación por dos mas la exponenciación en base 2 hasta la exponenciación iterada
      */
     public static int Ack(int m, int n)
     {
	if(m == 0)
	     return n + 1;
	else
	     if(n == 0 && m > 0)
		return Ack(m-1, 1);
	     else
		return Ack(m-1, Ack(m, n-1));
     }

     /**
      * Programa de prueba para la función Ackermann
      * @param args argumentos de la línea de comandos
      * @throws IOException Controla las excepciones del buffer I/O
      */
     public static void main(String args[]) throws IOException
     {
	int n, m, ackk;
	InputStreamReader entrada = new InputStreamReader(System.in);
	BufferedReader lectura = new BufferedReader(entrada);

	System.out.println("Introduzca el valor de m: ");
	m = Integer.parseInt(lectura.readLine());
	System.out.println("Introduzca el valor de n: ");
	n = Integer.parseInt(lectura.readLine());

	ackk = Ack(m,n);
		
	System.out.println("El resultado es: " + ackk);
     }
}