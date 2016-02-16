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

/**Fichero clientVotoRemoto.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

import java.util.*;
import java.net.*;
import java.rmi.*;

/**Descripcion
 * 
 */
public class clientVotoRemoto
{
     public static void main(String[]args)
     {
	try
	{
	     intVotoRemoto ORemoto = (intVotoRemoto)Naming.lookup("//localhost/Servidor");

	     Scanner v = new Scanner(System.in);
	     System.out.println("Introduce voto(si/no/ns):");

	     String a = v.nextLine();

	     ORemoto.Votar(a);

	     System.out.println("Votos Totales:" + ORemoto.Votos());
	     System.out.println("Votos con Si:" + ORemoto.VotosSi());
	     System.out.println("Votos con No:" + ORemoto.VotosNo());
	     System.out.println("Votos con NS:" + ORemoto.VotosNs());
	}
	catch(Exception e)
	{
	     System.out.println("Error en el cliente clientVotoRemoto..." + e);
	}
     }
}