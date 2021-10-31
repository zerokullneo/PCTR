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

/**Fichero Estadistica.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

package practica2;

import java.lang.*;
import java.io.*;

/**Descripcion
 * Realiza cálculos estadisticos.
 */
public class Estadistica
{
     /**
      * Programa que calcula la moda, la mediana, la varianza y desviación
      * típica dados unos "n" valores de entrada.
      * @param args argumentos de la línea de comandos
      * @param i controla el bucle 
      * @param n pide los n valores a tratar
      * @param sum suma de los n valores
      * @param media calcula la media estadistica
      * @param var calcula la varianza estadistica
      * @param valores vector de valores introducidos por teclado
      * @throws IOException Controla las excepciones del buffer I/O
      */
     public static void main(String args[]) throws IOException
     {
	int i = 0, n = 0, m, sum = 0;
	double media = 0, var = 0;
	int []valores;
	InputStreamReader entrada = new InputStreamReader(System.in);
	BufferedReader lectura = new BufferedReader(entrada);

	System.out.println("Indique cuantos n valores va a introducir: ");
	n = Integer.parseInt(lectura.readLine());
	valores = new int[n];
	System.out.println("Introduzca valores de n: ");

	do
	{
	     m = Integer.parseInt(lectura.readLine());
	     valores[i] = m;
	     sum = sum + m;
	     i++;
	}while(n > i);

	media = sum/n;
	System.out.println("El valor de la media es: " + media);
	System.out.println("El valor de la mediana es: " + valores[n/2]);
	for(i=0; i < n; i++) var = var + ((valores[i]-media)*(valores[i]-media));
	var = var/n;
	System.out.println("El valor de la varianza es: " + var);
	System.out.println("El valor de la desviacion tipica es: " + Math.sqrt(var));
     }
}