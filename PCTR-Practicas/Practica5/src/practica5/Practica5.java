/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

import java.util.Scanner;

/**
 *
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
            System.out.println("1.- Ejercicio Algoritmo de Dekker.");
            System.out.println("2.- Ejercicio Algoritmo de Eisenberg-McGuire.");
            System.out.println("3.- Ejercicio Algoritmo de Lamport.");
            System.out.println("0.- Salir.");
            opcion = new Scanner(System.in);
            opt = opcion.nextInt();
            
            switch(opt)
            {
                case 1:
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
                case 2:
                    System.out.println("Ejecutando Algoritmo de Eisenberg-McGuire.");
                    try
                    {
                        algEisenbergMcGuire.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada: " + e);
                    }
                    break;
                case 3:
                    System.out.println("Ejecutando Algoritmo de Lamport.");
                    try
                    {
                        algoLamport.main(null);
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
