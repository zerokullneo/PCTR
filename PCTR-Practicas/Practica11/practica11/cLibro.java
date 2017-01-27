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

/**Fichero cLibro.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

import java.io.*;
import java.util.*;
import java.net.*;
import java.rmi.*;

/**Descripcion
 * 
 */
public class cLibro
{
     public static void main(String[]args)
     {
	try
	{
	     iLibro ORemoto = (iLibro)Naming.lookup("//localhost/Servidor");
	     Scanner p = new Scanner(System.in);
	     Scanner a = new Scanner(System.in);
	     Scanner t = new Scanner(System.in);
		int op;

		do{
			System.out.println("-------MENU------");
			System.out.println("1-Insertar un libro.");
			System.out.println("2-Eliminar un libro.");
			System.out.println("3-Consultar BD.");
			System.out.println("4-Consultar por Autor.");
			System.out.println("5-Consultar por titulo.");
			System.out.println("0-Salir.");
			System.out.println("Seleccione una opcion:");
			op = p.nextInt();

			switch(op)
			{
				case 1:
					System.out.println("Insertar Libro");
					System.out.println("Introduzca el titulo:");
					String tit = t.nextLine();
					System.out.println("Introduzca el autor:");
					String aut = a.nextLine();

					Libro Lib = new Libro(tit,aut);

					ORemoto.insertar(Lib);
				break;
				case 2:
					System.out.println("Eliminar Libro");
					System.out.println("Introduzca el titulo:");
					String titulo = t.nextLine();
					System.out.println("Introduzca el autor:");
					String autor = a.nextLine();

					Lib = new Libro(titulo,autor);

					ORemoto.eliminar(Lib);
					break;
				case 3:
					ORemoto.consultarBD();
					break;
				case 4:
					System.out.println("Consulta por Autor");
					System.out.println("Introduzca el Autor:");
					String CAutor = a.nextLine();

					Libro res = new Libro();
		     
					res = ORemoto.consultarA(CAutor);
		     
					System.out.println("Autor: " + res.VerAutor());
					System.out.println("Titulo: " + res.VerTitulo());
					break;
				case 5:
					System.out.println("Consulta por Titulo");
					System.out.println("Introduzca el Titulo del libro:");
					String CTitulo = t.nextLine();

					res = new Libro();

					res = ORemoto.consultarN(CTitulo);

					System.out.println("Autor: " + res.VerAutor());
					System.out.println("Titulo: " + res.VerTitulo());
					break;
			}
		}while(op != 0);
	}
	catch(Exception e)
	{
	     System.out.println("Problema en cliente..." + e);
	}
	
	System.out.println("Cliente Terminado.");
     }
}
