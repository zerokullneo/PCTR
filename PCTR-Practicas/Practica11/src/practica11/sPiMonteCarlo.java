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

/**Fichero sPiMonteCarlo.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.*;
import java.lang.*;

/**Descripcion
 * Servidor PiMonteCarlo que recoje las peticiones de calculos de los clientes relacionados
 * con éste servidor.
 */
public class sPiMonteCarlo extends UnicastRemoteObject implements iPiMonteCarlo
{
	/**
	 * Atributo numero de puntos totales que se evaluaran en la aproximacion
	 * de la integral MonteCarlo.
	 */
	public static int nPuntosTotal;

	/**
	 * Atributo Coordenada x del punto.
	 */
	public static double x;

	/**
	 * Atributo Coordenada y del punto.
	 */
	public static double y;

	/**
	 * Atributo Numero de punton tetales que estan dentro de la aproximacion
	 * de la integral MonteCarlo.
	 */
	public static double cont = 0;

	/**
	 * Constructor por defecto declarado para la captura de excepciones.
	 * @throws RemoteException 
	 */
	public sPiMonteCarlo() throws RemoteException{}

	/**
	 * Metodo para reiniciar el calculo de puntos de la aproximacion.
	 * @throws RemoteException 
	 */
	public synchronized void reset() throws RemoteException
	{
		x = 0;
		y = 0;
		nPuntosTotal = 0;
		cont = 0;
		System.out.println("Aproximacion reseteada, valor actual: 0");
	}

	/**
	 * Metodo que recibe una determinada cantidad de puntos a verificar si estan
	 * dentro de la integral.
	 * @param nPuntos Cantidad de puntos a verificar por el metodo MonteCarlo
	 * @throws RemoteException 
	 */
	public synchronized void masPuntos(int nPuntos) throws RemoteException
	{
		nPuntosTotal += nPuntos;

		for(int i = 0; i < nPuntos; i++)
		{
			x = Math.random();
			y = Math.random();

			if((Math.pow(x,2) + Math.pow(y,2)) <= 1)
			cont++;
		}

		//System.out.println("Puntos generados: " + nPuntos + ", la nueva aproximacion es: " + );
	}

	/**
	 * Metodo observador que devuelve el valor actual de la aproximacion.
	 * @return Devuelve el calculo de puntos dentro de la aproximacion.
	 * @throws RemoteException 
	 */
	public double aproxActual() throws RemoteException
	{
		return (4*cont/nPuntosTotal);
	}

	public static void main(String[] args) throws Exception
	{
		try
		{
			iPiMonteCarlo ObRemoto = new sPiMonteCarlo(); //Se crea un objeto remoto
			Naming.bind("ServerMonteCarlo", ObRemoto); //Se registra el servicio
			System.out.println("SERVIDOR APROXIMACION DEL NUMERO PI POR EL METODO DE MONTE CARLO");
		}
		catch(Exception e)
		{
			System.out.println("Problemas en el servidor MonteCarlo..." + e.getMessage());
		}
	}
}
