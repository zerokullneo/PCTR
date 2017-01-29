/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package practica9;

import java.util.Scanner;

/**
 *
 * @author zerokullneo
 */
public class Practica9 {

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
            System.out.println("Menu Principal");
            System.out.println("1.- Ejercicio Usa RW File Monitor.");
            System.out.println("2.- Ejercicio Usa Monitor Impresion.");
            System.out.println("3.- Ejercicio Usa Monitor Cadena.");
            System.out.println("0.- Salir.");
            opcion = new Scanner(System.in);
            opt = opcion.nextInt();
            
            switch(opt)
            {
                case 1:
                    System.out.println("Ejecutando RW File Monitor...");
                    try
                    {
                        UsaRWFileMonitor.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada - 1: " + e);
                        return ;
                    }
                    break;
                case 2:
                    System.out.println("Ejecutando Monitor Impresion...");
                    try
                    {
                        UsamonitorImpresion.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada - 2: " + e);
                        return ;
                    }
                    break;
                case 3:
                    System.out.println("Ejecutando Monitor Cadena...");
                    try
                    {
                        usamonitorCadena.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada - 3: " + e);
                        return ;
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
