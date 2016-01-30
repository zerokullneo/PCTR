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

/**Fichero Paciente.java 
  *@author Jose Manuel Barba Gonzalez
  *@version 1.0
  *Programacion Concurrente y de Tiempo Real
  *Area de CC. de la Computacion e I.A.
*/

import java.lang.*;

public class Paciente
{
	public static int MAX = 100;
	private String nombre;
	private int dni;
	private char letra;
	private String direccion;
	private int telefono;
	private String company;
	
	/**
	 * Constructor de la clase Paciente
	 * @param n Recibe el nombre completo del Paciente
	 * @param i Recibe el DNI del Paciente
	 * @param l Recibe la del DNI del Paciente
	 * @param d Recibe la direccion completa del Paciente
	 * @param t Recibe el telefono del Paciente
	 * @param c Recibe la empresa de trabajo del Paciente
	 */
	public Paciente(String n, int i, char l, String d, int t, String c)
	{
		nombre = n;
		dni = i;
		letra = l;
		direccion = d;
		telefono = t;
		company = c;
	}
	
	//observadores
	/**
	 * Método observador del atributo nombre
	 * @return Retorna el valor de "nombre"
	 */
	public String Nombre(){return nombre;}

	/**
	 * Método observador del atributo DNI
	 * @return Retorna el valor de "dni"
	 */
	public int DNI(){return dni;}

	/**
	 * Método observador del atributo direccion
	 * @return Retorna el valor de "direccion"
	 */
	public String Direccion(){return direccion;}

	/**
	 * Método observador del atributo telefono
	 * @return Retorna el valor de "telefono"
	 */
	public int Telefono(){return telefono;}

	/**
	 * Método observador del atributo company
	 * @return Retorna el valor de "company"
	 */
	public String Company(){return company;}

	/**
	 * Función que dado un objeto Paciente muestra los datos ordenados
	 * @param P Objeto Paciente a tratar
	 */
	public void MostrarDatos(Paciente P)
	{
		System.out.println("Datos del Paciente: " + P.dni + P.letra);
		System.out.println("Nombre: " + P.nombre);
		System.out.println("Direccion: " + P.direccion);
		System.out.println("Telefono: " + P.telefono);
		System.out.println("Compañia de Seguro: " + P.company);
	}

	/**
	 * Recibe el parámetro DNI "d" a buscar en en conjunto "c" de objetos
	 * Paciente dados por el vector con datos ya creados, si el DNI "d" no
	 * está en el conjunto "c" retornará el valor nulo.
	 * @param d DNI a buscar en el conjunto de Pacientes dados por el parámetro c
	 * @param c Conjunto de objetos Paciente donde se buscará el DNI dado
	 * por el parámetro d
	 * @return Retorna el objeto Paciente correspondiente al parámetro d(DNI)
	 * referenciado, si d no existe devolverá null.
	 */
	public Paciente Buscardni(int d, Paciente []c)
	{
		for(int i = 0; i < MAX; i++)
			if(c[i].dni == d)
				return c[i];
		return null;
	}

	//modificadores
	/**
	 * Método modificador del atributo nombre
	 * @param n Recibe el nuevo valor para el atributo nombre
	 */
	public void Nombre(String n){if(n != "")nombre = n;}

	/**
	 * Método modificador del atributo dirección
	 * @param d Recibe el nuevo valor para el atributo direccion
	 */
	public void Direccion(String d){if(d != "")direccion = d;}

	/**
	 * Método modificador del atributo teléfono
	 * @param t Recibe el nuevo valor para el atributo telefono
	 */
	public void telefono(int t){if(t>0)telefono = t;}

	/**
	 * Método modificador del atributo company
	 * @param c Recibe el nuevo valor para el atributo company
	 */
	public void Company(String c){if(c != "")company = c;}
}