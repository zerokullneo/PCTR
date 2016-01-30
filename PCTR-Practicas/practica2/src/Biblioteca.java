/**
 * Copyright (C) 2015 Jose Manuel Barba Gonzalez <zk at wordpress.com>
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

/**Fichero Biblioteca.java 
  *@author Jose Manuel Barba Gonzalez
  *@version 1.0
  *Programacion Concurrente y de Tiempo Real
  *Area de CC. de la Computacion e I.A.
*/

import java.lang.*;
import java.io.*;

public class Biblioteca
{
     /**
      * Programa que permite crear una pequeña base de datos de Pacientes
      * @param args argumentos de la línea de comandos
      * @throws IOException Controla las excepciones del buffer I/O
      */
     public static void main(String[] args) throws IOException
     {
	Paciente[] consulta = new Paciente[Paciente.MAX];
	Paciente srch;
	InputStreamReader entrada = new InputStreamReader(System.in);
	BufferedReader lectura = new BufferedReader(entrada);
	String nombre, direccion, company;
	int dni,telefono, op, i = 0;
	char letra;
	
	do
	{
	     System.out.println("-- Menu --");
	     System.out.println("1.-Nuevo Paciente.");
	     System.out.println("2.-Eliminar Paciente.");
	     System.out.println("3.-Consultar Paciente.");
	     System.out.println("0.-Salir.");
	     System.out.println("Opcion: ");
	     op = Integer.parseInt(lectura.readLine());
	     
	     switch(op)
	     {
		case 0:
		     break;
		case 1:
		     System.out.println("Introduzca los datos del paciente: ");
		     System.out.println("DNI: ");
		     dni = Integer.parseInt(lectura.readLine());
		     System.out.println("Letra: ");
		     letra = (char) lectura.read();
		     System.out.println("Nombre: ");
		     nombre = lectura.readLine();
		     System.out.println("Direccion: ");
		     direccion = lectura.readLine();
		     System.out.println("Telefono: ");
		     telefono = Integer.parseInt(lectura.readLine());
		     System.out.println("Compañia: ");
		     company = lectura.readLine();
		     consulta[i] = new Paciente(nombre, dni, letra, direccion, telefono, company);
		     i++;
		     break;
		case 2:
		     System.out.println("Introduzca el DNI del paciente a eliminar: ");
		     dni = Integer.parseInt(lectura.readLine());
		     try
		     {
			srch = consulta[0].Buscardni(dni, consulta);
			srch = null;
			i--;
			break;
		     }
		     catch (Exception e)
		     {
			e.toString();
			System.out.println("Paciente no existe.");
			break;
		     }
		case 3:
		     System.out.println("Introduzca el DNI del paciente a consultar: ");
		     dni = Integer.parseInt(lectura.readLine());
		     try
		     {
			srch = consulta[0].Buscardni(dni, consulta);
			srch.MostrarDatos(srch);
			break;
		     }
		     catch (Exception e)
		     {
			System.out.println("Paciente no existe.");
			e.toString();
			break;
		     }
	     }
	}while(op != 0);
     }
}