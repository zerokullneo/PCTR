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

/**Fichero ServidorEjemploRMI0.java
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
public class ServidorEjemploRMI0
{
     public static void main (String args[])
     {
	try
	{
	     EjemploRMI0 ObjExport = new EjemploRMI0();
	     Naming.rebind("//localhost:3005/miholamundo1", ObjExport);
	     Naming.rebind("//localhost:3005/miholamundo2", ObjExport);
	     Naming.rebind("//localhost:3005/miholamundo3", ObjExport);
	     System.out.println("Servidor Hola Mundo preparado con varios objetos remotos activos...");
	}
	catch (Exception excr)
	{
	     System.out.println("Error en servidor... " + excr);
	}
     }
}
