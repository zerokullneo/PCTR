/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.util.Scanner;

/**
 *
 * @author zerokullneo
 */
public class Practica2
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
			System.out.println("Menu");
			System.out.println("1.- Ejercicio Hebra n compartida.");
			System.out.println("2.- Ejercicio Tarea Runnable.");
			System.out.println("31.- Ejercicio Escalar Vector.");
			System.out.println("32.- Ejercicio Escalar Vector Paralelo.");
			System.out.println("4.- Ejercicio Cuenta Corriente.");
			System.out.println("5.- Ejercicio Lambda.");
			System.out.println("0.- Salir.");
			opcion = new Scanner(System.in);
			opt = opcion.nextInt();

			switch(opt)
			{
				case 1:
					System.out.println("Ejecutando Hebra n compartida.");
					try
					{
						//Usa_Hebra.main(null);
						System.out.println("No disponible por falta de espacio en la subida de ficheros.");
					}
					catch(Exception e)
					{
						System.out.println("Error entrada: " + e);
					}
					break;
				case 2:
					System.out.println("Ejecutando Tarea Runnable.");
					try
					{
						Usa_tareaRunnable.main(null);
					}
					catch(Exception e)
					{
						System.out.println("Error entrada: " + e);
					}
					break;
				case 31:
					System.out.println("Ejecutando Escalar Vector.");
					try
					{
						//escalaVector.main(null);
						System.out.println("No disponible por falta de espacio en la subida de ficheros.");
					}
					catch(Exception e)
					{
						System.out.println("Error entrada: " + e);
					}
					break;
				case 32:
					System.out.println("Ejecutando Escalar Vector Paralelo.");
					try
					{
						escalaVPar.main(null);
					}
					catch(Exception e)
					{
						System.out.println("Error entrada: " + e);
					}
					break;
				case 4:
					System.out.println("Ejecutando Cuenta Corriente.");
					try
					{
						redCajeros.main(null);
					}
					catch(Exception e)
					{
						System.out.println("Error entrada: " + e);
					}
					break;
				case 5:
					System.out.println("Ejecutando Lambda.");
					try
					{
						hebraLambda.main(null);
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