/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

import java.util.Scanner;

/**
 * Balancear la carga de cada hebra, ejemplo numeros primos la primera tarea tendra numeros mas livianos que la ultima,
 * la interfaz callable siempre va unido a Future.
 * @author zerokullneo
 */
public class Practica5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner opcion;
        int opt;
        
        do
        {
            System.out.println("Menu Principal");
            System.out.println("1.- Ejercicio Producto de Matrices Secuencial.");
            System.out.println("2.- Ejercicio Producto de Matrices Paralelo.");
            System.out.println("3.- Ejercicio Resaltado de Imagen Secuencial.");
		  System.out.println("4.- Ejercicio Resaltado de Imagen Paralelo.");
		  System.out.println("5.- Ejercicio Numeros Perfectos Secuencial.");
		  System.out.println("6.- Ejercicio Numeros Perfectos Paralelo.");
            System.out.println("0.- Salir.");
            opcion = new Scanner(System.in);
            opt = opcion.nextInt();
            
            switch(opt)
            {
                case 1:
                    System.out.println("Ejecutando Producto de Matrices Secuencial.");
                    try
                    {
                        prodMatricesSecuencial.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada: " + e);
                    }
                    break;
                case 2:
				 System.out.println("Ejecutando Producto de Matrices Paralelo.");
				 try
				 {
					 prodMatricesParalelo.main(null);
				 }
				 catch(Exception e)
				 {
					 System.out.println("Error entrada: " + e);
				 }
				 break;
			 case 3:
                    System.out.println("Ejecutando Resaltado de Imagen Secuencial.");
                    try
                    {
                        resImagen.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada: " + e);
                    }
                    break;
			case 4:
                    System.out.println("Ejecutando Resaltado de Imagen Paralelo.");
                    try
                    {
                        resImagenPar.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada: " + e);
                    }
                    break;
			case 5:
                    System.out.println("Ejecutando Numeros Perfectos Secuencial.");
                    try
                    {
                        numPerfectos.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada: " + e);
                    }
                    break;
			case 6:
                    System.out.println("Ejecutando Numeros Perfectos Paralelo.");
                    try
                    {
                        numPerfectosParalelo.main(null);
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
