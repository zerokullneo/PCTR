/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

import java.util.Scanner;

/**
 *
 * @author Jose Manuel Barba Gonzalez
 */
public class Practica3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner opcion;
        int opt;
        
        do
        {
            System.out.println("Menu");
            System.out.println("1.- Ejercicio Poligonos.");
            System.out.println("2.- Ejercicio Cajero Automatico.");
            System.out.println("3.- Ejercicio Hilo.");
            System.out.println("4.- Ejercicio Vector Lineal.");
            System.out.println("5.- Ejercicio Vector Paralelo.");
            System.out.println("0.- Salir.");
            opcion = new Scanner(System.in);
            opt = opcion.nextInt();
            
            switch(opt)
            {
                case 1:
                    System.out.println("Ejecutando Poligonos.");
                    try
                    {
                        UsaTodo.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada: " + e);
                    }
                    break;
                case 2:
                    System.out.println("Ejecutando Cajero Automatico.");
                    try
                    {
                        Usa_Cajero.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada: " + e);
                    }
                    break;
                case 3:
                    System.out.println("Ejecutando Hilo.");
                    try
                    {
                        Usa_Hilo.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada: " + e);
                    }
                    break;
                case 4:
                    System.out.println("Ejecutando Vector Lineal.");
                    try
                    {
                        escalaVector.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada: " + e);
                    }
                    break;
                case 5:
                    System.out.println("Ejecutando Vector Paralelo.");
                    try
                    {
                        escalaVectorParalelo.main(null);
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
