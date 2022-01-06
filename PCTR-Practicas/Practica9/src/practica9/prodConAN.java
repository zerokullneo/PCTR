/* Copyright (C) 2006 M. Ben-Ari. See copyright.txt */

package practica9;

import java.util.concurrent.locks.*;

/**
 * Clase que simula el monitor de Productor-Consumidor.
 */
public class prodConAN
{
	/**
	 * Atributo dimension del array para el buffer.
	 */
	public final int N; //modificacion N = 100;

	/**
	 * Atributo compartido que indica cuantos elementos quedan en el buffer.
	 */
	public static volatile int Count;

	/**
	 * Atributo para calcular la posicion relativa sobre el vector.
	 */
	private int circular;

	/**
	 * Atributo que controla la exclusion mutua entre los hilos.
	 */
	private final ReentrantLock cerrojo;

	/**
	 * Atributo que evalua la condicion para la exclusion mutua entre los hilos.
	 */
	private final Condition bufferNoVacio, bufferNoLleno;

	/**
	 * Atributo que registra los elementos a consumir.
	 */
	public int Buffer[]; //modificacion  = new int[N];a

	/**
	 * Constructor de la clase.
	 * @param dimensionBuff Indica la dimension que tendra el buffer.
	 */
	prodConAN(int dimensionBuff)
	{
		N = dimensionBuff;
		Buffer = new int[N];
		Count = 0;
		circular = 0;
		cerrojo = new ReentrantLock();
		bufferNoVacio = cerrojo.newCondition();
		bufferNoLleno = cerrojo.newCondition();
	}

	/**
	 * Metodo que addiere elementos al buffer.
	 * @param V cantidad de elementos a adderir.
	 */
	public void Append(int V)
	{
		while (Count == N)
			try
			{
				cerrojo.lock();
				bufferNoVacio.await();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			finally
			{
				cerrojo.unlock();
				bufferNoVacio.signal();
			}

		circular = (circular + 1) % N;
		if(circular == -1)
			circular = circular + N;

		Buffer[circular] = V;
		Count = Count + 1;
	}

	/**
	 * Metodo que exrae un elemento del buffer.
	 */
	public void Take()
	{
		while (Count == 0)
			try
			{
				cerrojo.lock();
				bufferNoLleno.await();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			finally
			{
				cerrojo.unlock();
				bufferNoLleno.signal();
			}

		circular = (circular + 1) % N;
		if(circular == -1)
			circular = circular + N;

		Count = Buffer[circular];
		Count = Count - 1;
	}
}