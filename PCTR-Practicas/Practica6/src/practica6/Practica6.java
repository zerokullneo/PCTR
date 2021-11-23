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


package practica6;

import java.util.Scanner;

/**Fichero Practica6.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * Clase general que agrupa los ejercicios de la practica 6.
 */
public class Practica6
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
            System.out.println("1.- Ejercicio Servidor de Hilos con Pool.");
            System.out.println("2.- Ejercicio Array Seguro.");
            System.out.println("3.- Ejercicio Heterogenea.");
            System.out.println("4.- Ejercicio Deadlock.");
            System.out.println("5.- Ejercicio Monte-Carlo Callable.");
            System.out.println("6.- Ejercicios practica 2.");
            System.out.println("0.- Salir.");
            opcion = new Scanner(System.in);
            opt = opcion.nextInt();
            
            switch(opt)
            {
                case 1:
                    System.out.println("Ejecutando Servidor de Hilos con Pool...");
                    try
                    {
                        ServidorHiloconPool.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada: " + e);
                    }
                    break;
                case 2:
                    System.out.println("Ejecutando Array Seguro...");
                    try
                    {
                        arrSeguro.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada: " + e);
                    }
                    break;
                case 3:
                    System.out.println("Ejecutando Heterogenea...");
                    try
                    {
                        usaheterogenea.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada: " + e);
                    }
                    break;
                case 4:
                    System.out.println("Ejecutando Deadlock...");
                    try
                    {
                        deadlock.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada: " + e);
                    }
                    break;
                case 5:
                    System.out.println("Ejecutando Monte-Carlo Callable...");
                    try
                    {
                        integCallable.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada: " + e);
                    }
                    break;
                case 6:
                    System.out.println("Ejecutando practica 2...");
                    try
                    {
					practica2.Practica2.main(null);
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
