/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica8;

import java.util.Scanner;

/**
 *
 * @author zerokullneo
 */
public class Practica8 {

    /**
     * @param args the command line arguments
     */
        public synchronized static void main(String[] args) {
        // TODO code application logic here
        Scanner opcion;
        int opt;
        
        do
        {
            System.out.println("Menu Principal");
            System.out.println("1.- Ejercicio Conductores DGT.");
            System.out.println("2.- Ejercicio Drakkar Vikingo.");
            System.out.println("3.- Ejercicio Lector - Escritor.");
            System.out.println("0.- Salir.");
            opcion = new Scanner(System.in);
            opt = opcion.nextInt();
            
            switch(opt)
            {
                case 1:
                    System.out.println("Ejecutando Conductores DGT...");
                    try
                    {
                        usaConductores.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada - 1: " + e);
                    }
                    break;
                case 2:
                    System.out.println("Ejecutando Drakkar Vikingo...");
                    try
                    {
                        drakkarVikingo.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada - 2: " + e);
                    }
                    break;
                case 3:
                    System.out.println("Ejecutando Lector - Escritor...");
                    try
                    {
                        usalectorEscritor.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada - 3: " + e);
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
