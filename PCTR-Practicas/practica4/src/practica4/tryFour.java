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
package practica4;

/**Fichero tryFour.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * Clase que realiza el cuarto intento de solucionar la exclusion mutua.
 */
public class tryFour extends Thread
{
	/**
	 * Variable que diferencia dos hilos simulando dos procesos diferentes.
	 */
	private int tipoHilo;
	/**
	 * Variable que simula un numero determinado de instancias de los procesos.
	 */
	private static volatile int nVueltas = 10000;
	/**
	 * Variable compartida por ambos procesos que se modificara en la
	 * seccion critica.
	 */
	private static volatile int n;
	/**
	 * Variable de condicion del proceso 1,
	 * true=quiereentrar, false=restoproceso.
	 */
	private static volatile boolean C1;
	/**
	 * Variable de condicion del proceso 2,
	 * true=quiereentrar, false=restoproceso.
	 */
	private static volatile boolean C2;

	/**
	 * Constructor base que recibe como parametro un entero.
	 * @param tHilo Variable que simula o distingue entre los dos procesos.
	 */
	public tryFour(int tHilo)
	{
		tipoHilo = tHilo;
		n = 0;
		C1 = false;
		C2 = false;
	}

	/**
	 * Metodo run sobreescrito que simula la ejecucion de dos procesos
	 * simultaneamente.
	 */
	@Override
	public void run()
	{
		switch(tipoHilo)
		{
			case 1:
			{
				for(int i=0; i < nVueltas; i++)
				{
					C1 = true;
					while(C2==true);
					C1 = false;
					//sleep(1);
					System.out.println(i);
					C1 = true;
					n++;
					C1 = false;
				}
				break;
			}
			case 2:
			{
				for(int i=0; i < nVueltas; i++)
				{
					C2 = true;
					while(C1==true);
					C2 = false;
					//sleep(2);
					System.out.println(i);
					C2 = true;
					n--;
					C2 = false;
				}
				break;
			}
		}
	}

	public static void main(String[] args) throws InterruptedException
	{
		tryFour h1 = new tryFour(1);
		tryFour h2 = new tryFour(2);
		h1.start(); h2.start();
		h1.join(); h2.join();
		System.out.println(n);
	}
}
