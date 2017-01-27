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

package practica12;

/**Fichero servVotoRemoto.java
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
 * 
 */
public class servVotoRemoto extends UnicastRemoteObject implements intVotoRemoto
{
     int Votos = 0;
     int VotosSi = 0;
     int VotosNo = 0;
     int VotosNs = 0;

     public servVotoRemoto()throws RemoteException {}

     public void Votar(String v)throws RemoteException
     {
	Votos++;

	if(v.equals("si"))
	     VotosSi++;
	else if(v.equals("no"))
	     VotosNo++;
	else
	     VotosNs++;
     }

     public int Votos() throws RemoteException
     {
	return Votos;
     }

     public int VotosSi() throws RemoteException
     {
	return VotosSi;
     }

     public int VotosNo() throws RemoteException
     {
	return VotosNo;
     }

     public int VotosNs() throws RemoteException
     {
	return VotosNs;
     }

     public static void main(String[]args)
     {
	try
	{
	     intVotoRemoto ORemoto = new servVotoRemoto();
	     Naming.bind("Servidor", ORemoto);
	     System.out.println("Servidor preparado");
	}
	catch(Exception e)
	{
	     System.out.println("Error en el servidor servVotoRemoto..." + e);
	}
     }
}