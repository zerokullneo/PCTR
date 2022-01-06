/*
 * Copyright (C) 2021 Jose Manuel Barba Gonzalez <administrador at elyinyang.com>
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

package practica9;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Fichero barrera.java
 * @author Jose Manuel Barba Gonzalez <administrador at elyinyang.com>
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */
 /**
 * Descripcion
 * Clase que simula una carrera mediante la tecnica de CyclicBarrier.
 */
public class barrera implements Runnable
{
	/**
	 * Atributo del dorsal del competidor.
	 */
     private int dorsal;

	/**
	 * Atributo vector que recoje los tiempos de los participantes.
	 */
	private int[] tiempos=new int[100];

	/**
	 * Atributo que selecciona al azar un participante.
	 */
	private Random rand;

	/**
	 * Atributo que controla la barrera de la meta entre los hilos.
	 */
	private static final CyclicBarrier meta  = new CyclicBarrier(100);

	/**
	 * Constructor vacio.
	 */
	public barrera(){}

	/**
	 * Constructor con parámetro de entrada.
	 * @param i Numero de dorsal de corredor.
	 */
	public barrera(int i)
	{
		this.dorsal = i;
		rand = new Random(i + 3);
		tiempos[i] = 0;
	}

	/**
	 * Observador del tiempo total.
	 * @return Devuelve el tiempo con respecto al dorsal.
	 */
	public int gettiempo(){return tiempos[this.dorsal];}

	/**
	 * Observador del dorsas de corredor.
	 * @return Devuelve el dorsal de corredor.
	 */
	public int getdorsal(){return this.dorsal;}
	
	/**
	 * Modificador de tiempo con respecto al dorsal.
	 * @param t Parametro de entrada que actualiza el tiempo.
	 */
	public void settiempo(int t){tiempos[this.dorsal] = t;}

	/**
	 * Metodo run sobrecargado.
	 */
	@Override
	public void run()
	{
		int tmp = 0;
		long inicCronom;
		long finCronom;

		for(int i = 0; i < 3; i++)
		{
			inicCronom = System.currentTimeMillis();
			try
			{
				Thread.sleep(this.rand.nextInt(180));
			}
			catch(Exception e)
			{
				System.out.println("Error en sockets..." + e.getLocalizedMessage());
			}
			finCronom = System.currentTimeMillis();
			tmp += (finCronom-inicCronom);
		}
		tiempos[this.getdorsal()] = tmp;
	}

	public static void main(String[] args)
	{
		ExecutorService ejecutar = Executors.newCachedThreadPool();
		barrera[] carrera = new barrera[100];

		for(int i=0;i<100;i++)
		{
			carrera[i]=new barrera(i);
			ejecutar.execute(carrera[i]);
		}

		ejecutar.shutdown();
	
		while(!ejecutar.isTerminated()){}

		int ganador=0;
		for(int i = 0; i < carrera[0].tiempos.length; i++)
			if(carrera[i].tiempos[ganador] > carrera[i].tiempos[i])
				ganador = i;

		System.out.println("El ganador ha sido el dorsal "+ ganador + " ha tardado "+ carrera[ganador].tiempos[ganador]/1.0e3 +" segundos .");
	}
}
