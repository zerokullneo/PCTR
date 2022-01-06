/*
 * Copyright (C) 2021 Jose Manuel Barba Gonzalez <administrador at elyinyang.com>
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

package practica9;

import java.util.Scanner;

/**
 * Fichero Practica9.java
 * @author Jose Manuel Barba Gonzalez <administrador at elyinyang.com>
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */
 /**
 * Descripcion
 * Ejercicios correspondientes a la practica 9.
 */
public class Practica9
{
	/**
	 * @param args Argumentos de la linea de comandos.
	 */
	public static void main(String[] args)
	{
		// TODO code application logic here
		Scanner opcion;
		int opt;
        
		do
		{
			System.out.println("Menu Principal");
			System.out.println("1.- Ejercicio Usa Cuenta Corriente ReentrantLock.");
			System.out.println("12.- Ejercicio Usa Cuenta Corriente Semaphore");
			System.out.println("2.- Ejercicio Usa Barrera Ciclica.");
			System.out.println("3.- Ejercicio Usa Filosofos API A.Nivel.");
			System.out.println("4.- Ejercicio Usa Productor/Consumidor API A.Nivel.");
			System.out.println("5.- Ejercicio Tiempos Tecnicas de Control.");
			System.out.println("0.- Salir.");
			opcion = new Scanner(System.in);
			opt = opcion.nextInt();
            
			switch(opt)
			{
				case 1:
					System.out.println("Ejecutando Usa Cuenta Corriente ReentrantLock...");
					try
					{
						cCRL.main(null);
					}
					catch(Exception e)
					{
						System.out.println("Error entrada - 1: " + e.getLocalizedMessage());
						return ;
					}
					break;
				case 12:
					System.out.println("Ejecutando Usa Cuenta Corriente Semaphore...");
					try
					{
						ccSem.main(null);
					}
					catch(Exception e)
					{
						System.out.println("Error entrada - 12: " + e.getLocalizedMessage());
						return ;
					}
					break;
				case 2:
					System.out.println("Ejecutando Usa Barrera Ciclica...");
					try
					{
						barrera.main(null);
					}
					catch(Exception e)
					{
						System.out.println("Error entrada - 2: " + e.getLocalizedMessage());
						return ;
					}
					break;
				case 3:
					System.out.println("Ejecutando Usa Filosofos API A.Nivel...");
					try
					{
						usaFiloApiAn.main(null);
					}
					catch(Exception e)
					{
						System.out.println("Error entrada - 3: " + e.getLocalizedMessage());
						return ;
					}
					break;
				case 4:
					System.out.println("Ejecutando Usa Productor/Consumidor API A.Nivel...");
					try
					{
						usaProdConAn.main(null);
					}
					catch(Exception e)
					{
						System.out.println("Error entrada - 4: " + e.getLocalizedMessage());
						return ;
					}
					break;
				case 5:
					System.out.println("Ejecutando Tiempos Tecnicas de Control...");
					try
					{
						tiempos.main(null);
					}
					catch(Exception e)
					{
						System.out.println("Error entrada - 5: " + e.getLocalizedMessage());
						return ;
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
