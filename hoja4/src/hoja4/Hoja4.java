/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hoja4;

import java.util.Scanner;

/**
 *
 * @author Jose Manuel Barba Gonzalez <zk at wordpress.com>
 */
public class Hoja4
{
     /**
      * @param args the command line arguments
      */
     public static void main(String[] args)
     {
	// TODO code application logic here
	Scanner opcion = new Scanner(System.in);
	int op;
	do
	{
	     System.out.println("--- Menu Hoja 4 ---");
	     System.out.println("1 .- Ejercicio 1.");
	     System.out.println("2 .- Ejercicio 2.");
	     System.out.println("3 .- Ejercicio 3.");
	     System.out.println("4 .- Ejercicio 4.");
	     System.out.println("5 .- Ejercicio 5.");
	     System.out.println("0 .- Salir.");
	     op = opcion.nextInt();
	     
	     switch(op)
	     {
		case 1:
		     System.out.println("Ejecutando 1, Hola mundo concurrente...");
		     holaMundoRunnable.main(null);
		     break;
		case 2:
		     System.out.println("Ejecutando 2, Par o Impar Runnable...");
		     Usa_ParImparRunnable.main(null);
		     break;
		case 3:
		     System.out.println("Ejecutando 3, Prioridad Runnable...");
		     prioridadMain.main(null);
		     break;
		case 4:
		     System.out.println("Ejecutando 4, Thread yield()...");
		     hilosYield.main(null);
		     break;
		case 5:
		     System.out.println("Ejecutando 5, hilos daemon...");
		     hDaemon.main(null);
		     break;
		case 0:
		     break;
		default:
		     System.out.println("Opción Incorrecta.");
		     break;
	     }
	}while(op != 0);
	
     }
     
}
