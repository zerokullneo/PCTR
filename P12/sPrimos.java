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

/**Fichero sPrimos.java
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
public class sPrimos extends UnicastRemoteObject implements iPrimos
{
     public static int nTotal = 0;
     public int li;//Limite inferior
     public int ls;//Limite superior

     public sPrimos() throws RemoteException
     {
	super();
     }

     public boolean esPrimo(int n) throws RemoteException
     {
	if(n <= 1)
	     return(false);

	for(int i = 2; i <= Math.sqrt(n); i++)
	     if(n%i == 0)
		return(false);

	return(true);
     }

     public int NumPrimos(int li, int ls) throws RemoteException
     {
	nTotal = 0;

	for(int i = li; i <= ls; i++)
	     if(esPrimo(i))
		nTotal++;

	return nTotal;
     }

     public static void main(String[]args)
     {
	try
	{
	     iPrimos OR1 = new sPrimos();
	     iPrimos OR2 = new sPrimos();
	     iPrimos OR3 = new sPrimos();
	     iPrimos OR4 = new sPrimos();

	     Naming.bind("Servidor-1", OR1);
	     System.out.println("Servidor 1 preparado");
	     Naming.bind("Servidor-2", OR2);
	     System.out.println("Servidor 2 preparado");
	     Naming.bind("Servidor-3", OR3);
	     System.out.println("Servidor 3 preparado");
	     Naming.bind("Servidor-4", OR4);
	     System.out.println("Servidor 4 preparado");
	}
	catch(Exception e)
	{
	     System.out.println("Error en el servidor sPrimos..." + e);
	}
     }
}