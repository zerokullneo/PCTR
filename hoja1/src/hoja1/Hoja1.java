/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoja1;

import java.util.Scanner;

/**
 *
 * @author Jose Manuel Barba Gonzalez <zk at wordpress.com>
 */
public class Hoja1
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
	     System.out.println("--- Menu Hoja 1 ---");
	     System.out.println("1 .- Ejercicio 1.");
	     System.out.println("2 .- Ejercicio 2.");
	     System.out.println("3 .- Ejercicio 3.");
	     System.out.println("4 .- Ejercicio 4.");
	     System.out.println("0 .- Salir.");
	     op = opcion.nextInt();
	     
	     switch(op)
	     {
		case 1:
		     System.out.println("Ejecutando 1, Interes Tipo Fijo...");
		     interesTipoFijo.main(null);
		     break;
		case 2:
		     System.out.println("Ejecutando 2, Rectangulo * ...");
		     Rectangulo.main(null);
		     break;
		case 3:
		     System.out.println("Ejecutando 3, Medicina Cockroft-Gault...");
		     mediCalc.main(null);
		     break;
		case 4:
		     System.out.println("Ejecutando 4, Raiz por Biseccion...");
		    raizporBiseccion.main(null);
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
