/**
 * Copyright (C) 2021 Jose Manuel Barba Gonzalez <zk at wordpress.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package practica4;

import java.util.Scanner;

/**Fichero Practica4.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * Clase de la practica 4 que muestra el menu de seleccion sobre los ejercicios
 * propuestos.
 */
public class Practica4
{
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args)
	{
		// TODO code application logic here
		Scanner opcion;
		int opt;

		do
		{
			System.out.println("Menu Principal");
			System.out.println("1.- Ejercicio Intento TryThree.");
			System.out.println("2.- Ejercicio Intento Four.");
			System.out.println("3.- Ejercicio Algoritmo de Dekker.");
			System.out.println("4.- Ejercicio Algoritmo de Eisenberg&McGuire.");
			System.out.println("5.- Ejercicio Algoritmo de Hyman.");
			System.out.println("0.- Salir.");
			opcion = new Scanner(System.in);
			opt = opcion.nextInt();

			switch(opt)
			{
				case 1:
					System.out.println("Ejecutando Intento TryThree.");
					try
					{
						tryThree.main(null);
					}
					catch(Exception e)
					{
					System.out.println("Error entrada: " + e);
					}
					break;
				case 2:
					System.out.println("Ejecutando Intento Four.");
					try
					{
						tryFour.main(null);
					}
					catch(Exception e)
					{
						System.out.println("Error entrada: " + e);
					}
					break;
				case 3:
					System.out.println("Ejecutando Algoritmo de Dekker.");
					try
					{
						algDekker.main(null);
					}
					catch(Exception e)
					{
						System.out.println("Error entrada: " + e);
					}
					break;
				case 4:
					System.out.println("Ejecutando Algoritmo de Eisenberg&McGuire.");
					try
					{
						algEisenbergMcGuire.main(null);
					}
					catch(Exception e)
					{
						System.out.println("Error entrada: " + e);
					}
					break;
				case 5:
					System.out.println("Ejecutando Algoritmo de Hyman.");
					try
					{
						algHyman.main(null);
					}
					catch(Exception e)
					{
						System.out.println("Error entrada: " + e);
					}
					break;
				case 0:
					System.out.println("Saliendo...");
					break;
				default:
					System.out.println("Opcion Incorrecta.");
					break;
			}
		}while(opt != 0);
	}
}
