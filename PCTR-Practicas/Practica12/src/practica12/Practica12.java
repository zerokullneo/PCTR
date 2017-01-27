/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica12;

import java.util.Scanner;

/**
 *
 * @author Jose Manuel Barba Gonzalez <zk at wordpress.com>
 */
public class Practica12
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
	     System.out.println("--- Menu Practica 12 ---");
	     System.out.println("1 .- Pi Secuencial.");
	     System.out.println("2 .- Pi Paralelo.");
	     System.out.println("3 .- Productor-Consumidor Monitor.");
	     System.out.println("0 .- Salir.");
	     op = opcion.nextInt();
	     
	     switch(op)
	     {
		case 1:
		     System.out.println("Ejecutando Pi Secuencial...");
		     piSecuencial.main(null);
		     break;
		case 2:
		     System.out.println("Ejecutando Pi Paralelo...");
		     try
		     {
			piParalelo.main(null);
		     }
		     catch (InterruptedException e)
		     {
			System.out.println("Error Pi Paralelo..." + e);        
		     }
		     break;
		case 3:
		     System.out.println("Ejecutando Productor-Consumidor Monitor...");
		     try
		     {
			pcHebras.main(null);
		     }
		     catch (InterruptedException e)
		     {
			System.out.println("Error Productor-Consumidor Monitor..." + e);        
		     }
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
