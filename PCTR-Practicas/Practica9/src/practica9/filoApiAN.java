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

import java.util.concurrent.locks.*;

/**
 * Fichero filoApiAN.java
 * @author Jose Manuel Barba Gonzalez <administrador at elyinyang.com>
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */
 /**
 * Descripcion
 * Clase que simula el monitor cena de los filosofos.
 */
public class filoApiAN
{
	/**
	 * Atributo vector que indica la cantidad de tenedores.
	 */
	private boolean[] tenedores = new boolean[5];

	/**
	 * Atributo que controla la exclusion mutua entre los hilos.
	 */
	private ReentrantLock bloqueo = new ReentrantLock();

	/**
	 * Atributo que evalua la condicion para la exclusion mutua entre los hilos.
	 */
	private Condition cerrojo = bloqueo.newCondition();

	/**
	 * Constructor base de la clase.
	 */
	filoApiAN()
	{
		for(int i = 0; i < tenedores.length; i++)
			tenedores[i] = true;
	}

	/**
	 * Metodo que realiza la tarea de comer para un filosofo dado.
	 * @param i parametro que indica el filosofo que va a comer.
	 * @throws InterruptedException
	 */
	public void EmpezarComer(int i) throws InterruptedException
	{
		bloqueo.lock();
		try
		{
			while(!tenedores[i] || !tenedores[(i + 1) % 5])
			cerrojo.await();

			tenedores[i] = false;
			tenedores[(i + 1) % 5] = false;
		}
		finally
		{
			bloqueo.unlock();
		}
	}

	/**
	 * Metodo que realiza la tarea de finalizar el turno para un filosofo dado.
	 * @param i parametro que indica el filosofo que va a dejar de comer.
	 */
	public void DejarComer(int i)
	{
		bloqueo.lock();
		try
		{
			tenedores[i] = true;
			tenedores[(i + 1) % 5] = true;
			cerrojo.signalAll();
		}
		finally
		{
			bloqueo.unlock();
		}
	}
}
