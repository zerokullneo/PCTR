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

/**Fichero iPiMonteCarlo.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

import java.net.*;
import java.io.*;
import java.rmi.*;

/**Descripcion
 * Interfaz que tiene como funcion establecer la comunicacion en ambos sentidos entre
 * el servidor y el cliente para el calculo de la integral MonteCarlo.
 */
public interface iPiMonteCarlo extends Remote
{
	/**
	 * Metodo para reiniciar el calculo de puntos de la aproximacion.
	 * @throws RemoteException 
	 */
     public void reset() throws RemoteException;

	/**
	 * Metodo que recibe una determinada cantidad de puntos a verificar si estan
	 * dentro de la aproximacion.
	 * @param nPuntos Cantidad de puntos a verificar por el metodo MonteCarlo
	 * @throws RemoteException 
	 */
	public void masPuntos(int nPuntos) throws RemoteException;

	/**
	 * Metodo observador que devuelve el valor actual de la aproximacion.
	 * @return Devuelve el calculo de puntos dentro de la aproximacion.
	 * @throws RemoteException 
	 */
	public double aproxActual() throws RemoteException;
}
