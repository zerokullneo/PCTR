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

//package practica11;

/**Fichero cPiMonteCarlo.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;

/**Descripcion
 * 
 */
public class cPiMonteCarlo
{
     public static void main(String[] args) throws Exception
     {
	int puntos = 0;
	int op;
	Scanner r = new Scanner(System.in);
	iPiMonteCarlo RefObRemoto = (iPiMonteCarlo)Naming.lookup("//localhost/Servidor");

	do
	{
		System.out.println("-------MENU------.");
		System.out.println("Indique que desea hacer:");
		System.out.println("1. Añadir mas puntos a la aproximacion");
		System.out.println("2. Resetear la aproximacion");
		System.out.println("0. Salir");
		System.out.println("OPCION: ");
	     op = r.nextInt();

	     switch(op)
	     {
		case 1:
		     System.out.print("Indique cuantos puntos desea añadir: ");
		     puntos = r.nextInt();
		     RefObRemoto.masPuntos(puntos);
		     break;
		case 2:
		     RefObRemoto.reset();
		     break;
		case 3:
		     break;
	     }
	}while(op != 0);
     }
}
