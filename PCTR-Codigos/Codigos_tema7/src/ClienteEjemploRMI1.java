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

/**Fichero ClienteEjemploRMI1.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */
import java.rmi.*;
import java.rmi.registry.*;
/**Descripcion
 * 
 */
public class ClienteEjemploRMI1
{
     public static void main(String[] args) throws Exception
     {
	int a =  10;
	int b = -10;

	//En esta ocasion trabajamos sin gestor de seguridad
	//System.setSecurityManager(new RMISecurityManager());

	//Se obtiene una referencia a la interfaz del objeto remoto
	//SIEMPRE debe convertirse el retorno del metodo Naming.lookup
	//a un objeto de interfaz remoto

	IEjemploRMI1 RefObRemoto = (IEjemploRMI1)Naming.lookup("//localhost/Servidor");

	System.out.println(RefObRemoto.Suma(a,b));	
	System.out.println(RefObRemoto.Resta(a,b));	
	System.out.println(RefObRemoto.Producto(a,b));	
	System.out.println(RefObRemoto.Cociente(a,b));	
     }
}
