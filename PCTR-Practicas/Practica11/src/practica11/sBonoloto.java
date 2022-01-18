/**
 * Copyright (C) 2022 Jose Manuel Barba Gonzalez <zk at wordpress.com>
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

//package practica11;

/**Fichero sBonoloto.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

import java.util.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.rmi.*;
import java.net.*;

/**Descripcion
 * Servidor Bonoloto que recoje las peticiones de apuestas de los clientes relacionados
 * con éste servidor.
 */
public class sBonoloto extends UnicastRemoteObject implements iBonoloto
{
	/**
	 * Atributo vector que guarda la apuesta actual generada por el servidor.
	 */
	public int [] Apuesta = new int[6];

	/**
	 * Atributo que indica la cantidad de numeros que pueden ser seleccionados, nuestro caso
	 * particular 49 numeros simulando la Bonoloto española.
	 */
	private final int nNumeros = 49;

	/**
	 * Constructor por defecto declarado para la captura de excepciones.
	 * @throws RemoteException 
	 */
	public sBonoloto() throws RemoteException
	{
		super();
	}

	/**
	 * Metodo que reinicia la apuesta generada para simular una nueva apuesta con distintos numeros.
	 * @throws RemoteException 
	 */
	public void resetServidor() throws RemoteException
	{
		Random p = new Random();

		for(int i = 0; i < Apuesta.length; i++)
		{
			int n = p.nextInt(nNumeros);
			Apuesta[i] = n + 1;
			System.out.print(Apuesta[i] + " ");
		}
		System.out.println("");
	}

	/**
	 * Metodo que compara los vectores, el primero de la apuesta generada y el segundo de la
	 * apuesta del cliente pasada por parametro.
	 * @param apuesta parametro que recoje la apuesta del cliente para su verificacion.
	 * @return Devuelve "true" si los 6 numeros coinciden exactamente, y "false" si hay
	 * al menos un numero de diferencia.
	 * @throws RemoteException 
	 */
	public boolean compApuesta(int[] apuesta) throws RemoteException
	{
		Arrays.sort(Apuesta);
		Arrays.sort(apuesta);

		for(int i = 0; i < Apuesta.length; i++)
			if(Apuesta[i] != apuesta[i])
				return false;

		return true;
	}

	public static void main(String[]args)
	{
		try
		{
			iBonoloto ORemoto = new sBonoloto();

			Naming.bind("ServerBonoloto", ORemoto);

			System.out.println("Servidor Bonoloto preparado");
		}
		catch (Exception e)
		{
			System.out.println("Problemas en el servidor Bonoloto..." + e.getMessage());
		}
	}
}
