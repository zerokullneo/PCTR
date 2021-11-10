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

import static java.lang.Thread.sleep;
import java.util.Scanner;

/**Fichero algHyman.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * Clase que realiza la propuesta de solucion (erronea) de la Exclusion Mutua
 * del matematico Hyman.
 */
public class algHyman implements Runnable
{
	/**
	 * Variable compartida por ambos procesos que se modificara en la
	 * seccion critica e indicara el numero de veces accedidos por cada proceso.
	 */
	private int turnos;
	/**
	 * Variable que simula un numero determinado de instancias de los procesos.
	 */
	private static int vueltas;
	/**
	 * Variable compartida por ambos procesos que se usara para entrar
	 * en la seccion critica.
	 */
	private int turno;
	/**
	 * Variable de condicion del proceso 1,
	 * true=quiereentrar, false=restoproceso.
	 */
	private static volatile boolean C0 = false;
	/**
	 * Variable de condicion del proceso 2,
	 * true=quiereentrar, false=restoproceso.
	 */
	private static volatile boolean C1 = false;
	
	/**
	 * Constructor base que inicializa los estados de las variables vueltas
	 * y turno.
	 * @param nv variable que inicia el numero de vueltas(simulaciones).
	 * @param t variable que inicia el turno de cada proceso o hebra
	 */
	public algHyman(int nv, int t)
	{
		vueltas = nv;
		turno = t;
		turnos = 0;
	}

	/**
	 * Metodo observador sobre la variable turnos.
	 * @return devuelve el numero de turnos accedidos por cada proceso.
	 */
	public int numeroTurnos()
	{
		return turnos;
	}

	/**
	 * Método run sobreescrito para simular dos o mas procesos en ejecución.
	 */
	@Override
	public void run()
	{
		for(int i = 0; i < vueltas; i++)
			switch(turno)
			{
				case 0:
					C0 = true;
					while(turno != 0)
					{
						while(C1 == true);
						turno = 0;
					}
					turnos ++;
					C0 = false;
					//System.out.println("P1");
					break;
				case 1:
					C1 = true;
					while(turno != 1)
					{
						while(C0 == true);
						turno = 1;
					}
					turnos ++;
					C1 = false;
					//System.out.println("P2");
					break;
				default:
					break;
			}
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		int n;
		
		System.out.println("Introduzca el numero N de vueltas: ");
		n = new Scanner(System.in).nextInt();
		
		algHyman p1, p2;

		p1 = new algHyman(n, 0);
		p2 = new algHyman(n, 1);

		//con la interfaz Runnable hay que crear primero los Threads
		Thread EM1 = new Thread(p1);
		Thread EM2 = new Thread(p2);

		EM1.start();
		EM2.start();
		EM1.join();
		EM2.join();
		sleep(200);
		
		System.out.println("Turnos accedidos Proceso 1: " + p1.numeroTurnos());
		System.out.println("Turnos accedidos Proceso 2: " + p2.numeroTurnos());
	}
}
