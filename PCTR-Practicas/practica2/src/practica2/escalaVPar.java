/**
 * Copyright (C) 2021 Jose Manuel Barba Gonzalez <zk at wordpress.com>
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

package practica2;

import java.lang.*;
import java.io.*;
import java.util.*;

/**Fichero escalaVectorParalelo.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * Clase que realiza un escalado de vectores de forma paralela.
 */
public class escalaVPar extends Thread
{
	/**
	 * Máximo numero de iteraciones y posiciones del vector.
	 */
	private static int MAX;
	/**
	 * Variable para el Factor de partición del vector.
	 */
	private int factor;
	/**
	 * Variable que especifica el índice de la parte a tratar.
	 */
	private int parte;
	/**
	 * Vector resultado de las operaciones.
	 */
	private int []vector;

	/**
	 * Constructor especificando los parametros de escalaVPar.
	 * @param m Valor maximo de posiciones de la variable vector.
	 * @param f Factor de multiplicacion de los elementos del vector.
	 * @param p Variable que divide el vector en dos mitades, 0 y 1.
	 * @param v Vector de enteros al que se le aplica el factor
	 * multiplicativo.
	 */
	public escalaVPar(int m, int f, int p, int []v)
	{
		MAX = m;
		factor = f;
		parte = p;
		vector = v;
	}

	/**
	 * Método run sobreescrito para calcular por particiones el escalado.
	 */
	@Override
	public void run()
	{
		int i;

		if(parte == 1)
			for(i = 0; i < vector.length/2; i++)
				vector[i] = vector[i] * factor;
		if(parte == 2)
			for(i = MAX/2; i < MAX; i++)
				vector[i] = vector[i] * factor;

		//se muestran las 3 primeras y ultimas posiciones a valor informativo de que se cumple la propiedad
		System.out.println("Vector: " + vector[0] + ", " + vector[1] + ", " + vector[2] + ",..., " + vector[MAX-3] + ", " + vector[MAX-2] + ", " + vector[MAX-1]);
	}

	/**
	 * Clase principal para simular de forma paralela el escalado.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException, InterruptedException
	{
		int MAX = 10000000;
		InputStreamReader entrada = new InputStreamReader(System.in);
		BufferedReader lectura = new BufferedReader(entrada);
		escalaVPar hijo1; 
		escalaVPar hijo2;
		Random r = new Random();
		int []vector = new int[MAX];
		int i ,f;

		//creacion aleatoria de los numeros del vector
		for(i = 0; i < MAX; i++)
			vector[i] = r.nextInt(11-1)+1;

		//se muestran las 3 primeras y ultimas posiciones a valor informativo de que se cumple la propiedad
		System.out.println("Vector: " + vector[0] + ", " + vector[1] + ", " + vector[2] + ",..., " + vector[MAX-3] + ", " + vector[MAX-2] + ", " + vector[MAX-1]);

		System.out.println("Introduzca el factor multiplicativo:");
		f = Integer.parseInt(lectura.readLine());

		hijo1 = new escalaVPar(MAX, f, 1, vector);
		hijo2 = new escalaVPar(MAX, f, 2, vector);

		hijo1.start();
		hijo2.start();
		hijo1.join();
		hijo2.join();
	}
}
