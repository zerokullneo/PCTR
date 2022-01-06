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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package practica8;

import java.util.Scanner;

/**Fichero Practica8.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 *
 *
 * Descripcion
 * Clase principal que agrupa los ejercicios de la práctica 8.
 */
public class Practica8
{
	/**
	 * @param args argumentos de la entrada estandar.
	 */
	public synchronized static void main(String[] args)
	{
		// TODO code application logic here
		Scanner opcion;
		int opt;

		do
		{
			System.out.println("Menu Principal");
			System.out.println("1.- Ejercicio Monitor de Impresion.");
			System.out.println("2.- Ejercicio Monitor Fork.");
			System.out.println("0.- Salir.");
			opcion = new Scanner(System.in);
			opt = opcion.nextInt();

			switch(opt)
			{
				case 1:
					System.out.println("Ejecutando Monitor de Impresion...");
					try
					{
						UsamonitorImpresion.main(null);
					}
					catch(Exception e)
					{
						System.out.println("Error entrada - 1: " + e.getMessage() + ", " + e.getStackTrace());
					}
					break;
				case 2:
					System.out.println("Ejecutando Monitor Fork...");
					try
					{
						usaforkMonitor.main(null);
					}
					catch(Exception e)
					{
						System.out.println("Error entrada - 2: " + e.getMessage() + ", " + e.getStackTrace());
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
