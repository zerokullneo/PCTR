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

package practica10;

/**Fichero clienteContador.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */
import java.net.*;
import java.io.*;
/**Descripcion
 * 
 */
public class clienteContador
{
     public static void main (String[] args)
     {
	int i = (int)(Math.random()*10);
	int puerto = 2001;

	for(int k = 0; k < 30; k++)
	{
	     try
	     {
		System.out.println("Realizando conexion...");
		Socket cable = new Socket("localhost", puerto);
		System.out.println("Realizada conexion a " + cable);
		PrintWriter salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(cable.getOutputStream())));
		salida.println(i);
		salida.flush();
		System.out.println("Cerrando conexion...");
		cable.close();
	     }
	     catch(Exception e)
	     {
		System.out.println("Error en sockets..." + e);
	     }
	}
     }
}