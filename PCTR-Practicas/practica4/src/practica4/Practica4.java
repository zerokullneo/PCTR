/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import java.util.Scanner;
/**
 *
 * @author zerokullneo
 */
public class Practica4 {

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
            System.out.println("1.- Ejercicio producto de una matriz.");
            System.out.println("2.- Ejercicio producto de matrices.");
            System.out.println("3.- Ejercicio Analisis.");
            System.out.println("0.- Salir.");
            opcion = new Scanner(System.in);
            opt = opcion.nextInt();
            
            switch(opt)
            {
                case 1:
                    System.out.println("Ejecutando producto de una matriz.");
                    try
                    {
                        matVector.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada: " + e);
                    }
                    break;
                case 2:
                    System.out.println("Ejecutando producto de matrices.");
                    try
                    {
                        matVectorConcurrente.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada: " + e);
                    }
                    break;
                case 3:
                    System.out.println("Ejecutando Analisis.");
                    try
                    {
                        UsaprodMatConcurrente.main(null);
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
