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
 * Clase que une el segundo y cuarto intento de solucionar la exclusion mutua
 * propuesto por el matematico Dekker.
 */
public class algDekker extends Thread
{
	/**
	 * Variable que simula un numero determinado de instancias de los procesos.
	 */
     public static volatile long max = 100000;
	/**
	 * Variable compartida por ambos procesos que se usara para entrar
	 * en la seccion critica.
	 */
     public static volatile long turno;
	/**
	 * Array que asigna los turnos a cada proceso o hebra.
	 */
     public static volatile long[] turnos;
	/**
	 * Indice del array permisos.
	 */
     public static volatile int indice;
	/**
	 * Array que indica quien tiene los permisos para entrar en la
	 * seccion critica.
	 */
     public static volatile boolean[] permisos;
	/**
	 * Variable compartida por ambos procesos que se modificara en la
	 * seccion critica.
	 */
     public static volatile int n;

	/**
	 * Constructor predeterminado, donde inicializamos las variables indice y n
	 * para que en cada ejecución y cada creación de objetos sean 0.
	 */
	public algDekker()
	{
		indice = 0;
		n = 0;
	}

	/**
	 * Método run sobreescrito para simular dos o mas procesos en ejecución.
	 */
	@Override
	public void run()
     {
		for(int i = 0; i < max; ++i)
		{
			String name = this.getName();
			int numThread = Integer.parseInt(name.replace("Thread-", ""));
			//System.out.println(numThread);
			int otroThread = 0;
			switch(numThread)
			{ //modificacion, añadimos los 3 casos sobre los 3 hilos.
			case 0:
				otroThread = 1;
				break;
			case 1:
				otroThread = 0;
				break;
			/*case 2:
				otroThread = 0;
				break;*/
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
			/*if(indice == 2) //modificacion
				indice = 0;//añadimos una posicion mas
			else*/
				if(indice == 0)//indice == 1
					indice = 1; //indice == 2
			else
				indice = 0;     

			turno = turnos[indice];
			permisos[numThread] = false;
		}
     }

     public static void main(String[] args) throws InterruptedException 
     {
		int nhilos = 2;
		algDekker t1 = new algDekker();
		algDekker t2 = new algDekker();
		//algDekker t3 = new algDekker();

		turnos = new long[nhilos];
		turnos[0] = t1.getId();
		t1.setName("Thread-0");
		turnos[1] = t2.getId();
		t2.setName("Thread-1");
		//turnos[2] = t3.getId();
		//t3.setName("Thread-2");
		turno = turnos[0];

		permisos = new boolean[nhilos];
		for(int i = 0; i < nhilos; ++i) 
		     permisos[i] = true;

		t1.start();
		t2.start();
		//t3.start();
		
		try
		{
			t1.join();
			t2.join();
			//t3.join();
		     System.out.println("Valor de variable compartida: " + n);
		     System.out.println("Valor correcto de variable compartida: " + (nhilos*max));
		}
		catch(InterruptedException e)
		{
		     System.out.println("--" + e + "--");
		}
     }
}