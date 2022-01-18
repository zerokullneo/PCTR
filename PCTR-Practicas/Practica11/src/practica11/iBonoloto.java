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

/**Fichero iBonoloto.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

import java.rmi.*;

/**Descripcion
 * Interfaz que tiene como funcion establecer la comunicacion en ambos sentidos entre
 * el servidor y el cliente para una simple simulacion de apuestas de Bonoloto.
 */
public interface iBonoloto extends Remote
{
	/**
	 * Metodo que reinicia la apuesta generada para simular una nueva apuesta con distintos numeros.
	 * @throws RemoteException 
	 */
	public void resetServidor() throws RemoteException;

	/**
	 * Metodo que compara los vectores, el primero de la apuesta generada y el segundo de la
	 * apuesta del cliente pasada por parametro.
	 * @param apuesta parametro que recoje la apuesta del cliente para su verificacion.
	 * @return Devuelve "true" si los 6 numeros coinciden exactamente, y "false" si hay
	 * al menos un numero de diferencia.
	 * @throws RemoteException 
	 */
	public boolean compApuesta(int[] apuesta)  throws RemoteException;
}
