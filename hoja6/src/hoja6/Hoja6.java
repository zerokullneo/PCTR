/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoja6;

import java.util.Scanner;

/**
 *
 * @author Jose Manuel Barba Gonzalez <zk at wordpress.com>
 */
public class Hoja6
{

     /**
      * @param args the command line arguments
      */
     public static void main(String[] args) throws InterruptedException
     {
	// TODO code application logic here
	Scanner opcion = new Scanner(System.in);
	int op;

	do
	{
	     System.out.println("--- Menu Hoja 6 ---");
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
		     System.out.println("Ejecutando 1, Hola Mundo Concurrente...");
		     prodConControlado.main(null);
		     break;
		case 2:
		     System.out.println("Ejecutando 2, Par Impar ...");
		     ProyectosArquitectura.main(null);
		     break;
		case 3:
		     System.out.println("Ejecutando 3, Integral MonteCarlo Paralelo...");
		     try
		     {
			incremento.main(null);
		     }
		     catch (InterruptedException e)
		     {
			System.out.println("Error inicio incremento..." + e);
		     }
		     break;
		case 4:
		     System.out.println("Ejecutando 4, Convento...");
		     try
		     {
			Convento.main(null);
		     }
		     catch (InterruptedException e)
		     {
			System.out.println("Error inicio Convento..." + e);
		     }
		     break;
		case 5:
		     System.out.println("Ejecutando 4, Automata Celular Paralelo...");
		     prodConControlado.main(null);
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
