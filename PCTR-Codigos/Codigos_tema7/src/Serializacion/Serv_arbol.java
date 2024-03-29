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

package Serializacion;

/**Fichero Serv_arbol.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;
/**Descripcion
 * 
 */
public class Serv_arbol extends UnicastRemoteObject implements IArbol
{
     public Serv_arbol() throws RemoteException
     {
	super();
     }

     public void Listado_Remoto(Arbol t, int n) throws RemoteException
     {
	for(int i = 0; i < t.nivel; i++)
	     System.out.print("  ");
	System.out.println("nodo " + t.id);

	if(t.nivel <= n && t.izq != null)
	     Listado_Remoto(t.izq, n);

	if(t.nivel <= n && t.der != null)
	     Listado_Remoto(t.der, n);
     }

     public static void main(String []args) throws Exception
     {
	Serv_arbol ORemoto = new Serv_arbol();
	Naming.bind("Servidor", ORemoto);
	System.out.println("Servidor Remoto Preparado");
     } 
}
