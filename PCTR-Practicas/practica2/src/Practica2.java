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
public class Practica2 {

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
            System.out.println("1.- Ejercicio Paciente/Biblioteca.");
            System.out.println("2.- Ejercicio Ackermann.");
            System.out.println("3.- Ejercicio Estadistica.");
            System.out.println("4.- Ejercicio Complejos.");
            System.out.println("5.- Ejercicio Elipse.");
            System.out.println("0.- Salir.");
            opcion = new Scanner(System.in);
            opt = opcion.nextInt();
            
            switch(opt)
            {
                case 1:
                    System.out.println("Ejecutando Paciente/Biblioteca.");
                    try
                    {
                        Biblioteca.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada: " + e);
                    }
                    break;
                case 2:
                    System.out.println("Ejecutando Ackermann.");
                    try
                    {
                        Ack.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada: " + e);
                    }
                    break;
                case 3:
                    System.out.println("Ejecutando Estadistica.");
                    try
                    {
                        Estadistica.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada: " + e);
                    }
                    break;
                case 4:
                    System.out.println("Ejecutando Complejos.");
                    try
                    {
                        usaComplejos.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada: " + e);
                    }
                    break;
                case 5:
                    System.out.println("Ejecutando Elipse.");
                    try
                    {
                        usaElipse.main(null);
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