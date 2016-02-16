/**
 * Copyright (C) 2016 Jose Manuel Barba Gonzalez <zk at wordpress.com>
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

package practica11;

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
 * 
 */
public class sPiMonteCarlo
 extends UnicastRemoteObject
 	implements iPiMonteCarlo
{

	public static int nPuntosTotal;
	public static double x;
	public static double y;
	public static double cont = 0;

	public sPiMonteCarlo() throws RemoteException{}

	public synchronized void reset()
		throws RemoteException
	{
		x = 0;
		y = 0;
		nPuntosTotal = 0;
		cont = 0;

		System.out.println("Aproximacion reseteada, valor actual: 0");
	}

	public synchronized void masPuntos(int nPuntos)
		throws RemoteException
	{
		nPuntosTotal += nPuntos;
		for(int i = 0; i<nPuntos; i++)
		{
			x = Math.random();
			y = Math.random();
			if(Math.pow(x,2)+Math.pow(y,2)<=1) cont++;
		}

		System.out.println("Se han generado "+nPuntos+" puntos nuevos, la nueva aproximacion es: "+(4*cont/nPuntosTotal));
	}

	public static void main(String[] args)
		throws Exception
	{
		iPiMonteCarlo ObRemoto = new sPiMonteCarlo(); //Se crea un objeto remoto
		Naming.bind("Servidor",ObRemoto); //Se registra el servicio
		System.out.println("APROXIMACION DEL NUMERO PI POR EL METODO DE MONTE CARLO");
	}
}
