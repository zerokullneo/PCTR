/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica7;

import static java.lang.Thread.sleep;
import java.util.Scanner;

/**
 *
 * @author Jose Manuel Barba Gonzalez <zk at wordpress.com>
 */
public class Practica7
{

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
            System.out.println("1.- Ejercicio Cliente - Servidor con Pool.");
            System.out.println("2.- Ejercicio Cliente - Servidor sin Pool.");
            System.out.println("3.- Ejercicio Fichero Compartido.");
            System.out.println("4.- Ejercicio Monte-Carlo Concurrente.");
            System.out.println("5.- Ejercicio Monte-Carlo Concurrente PI.");
            System.out.println("0.- Salir.");
            opcion = new Scanner(System.in);
            opt = opcion.nextInt();
            
            switch(opt)
            {
                case 1:
                    System.out.println("Ejecutando Cliente - Servidor con Pool...");
                    try
                    {
                        ServidorHiloconPool.main(null);
                        sleep(1000);
                        clienteMultiple.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada - 1: " + e);
                    }
                    break;
                case 2:
                    System.out.println("Ejecutando Cliente - Servidor sin Pool...");
                    try
                    {
                        ServidorHilosinPool.main(null);
                        sleep(1000);
                        clienteMultiple.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada - 2: " + e);
                    }
                    break;
                case 3:
                    System.out.println("Ejecutando Fichero Compartido...");
                    try
                    {
                        ficheroSeguro.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada - 3: " + e);
                    }
                    break;
                case 4:
                    System.out.println("Ejecutando Monte-Carlo Concurrente...");
                    try
                    {
                        System.out.println("1.- Unico Monte-Carlo Concurrente.");
                        System.out.println("2.- Future Monte-Carlo Concurrente.");
                        System.out.println("3.- Multiple Monte-Carlo Concurrente.");
                        opcion = new Scanner(System.in);
                        opt = opcion.nextInt();

                        switch(opt)
                        {
                            case 1:
                               intParalelauniCont.main(null);
                               break;
                            case 2:
                                intParaleloFutureCont.main(null);
                                break;
                            case 3:
                                intParalelomultiCont.main(null);
                                break;
                            default:
                                break;
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada - 4: " + e);
                    }
                    break;
                case 5:
                    System.out.println("Ejecutando Monte-Carlo Concurrente PI...");
                    try
                    {
                        System.out.println("1.- Unico Monte-Carlo Concurrente PI.");
                        System.out.println("2.- Future Monte-Carlo Concurrente PI.");
                        System.out.println("3.- Multiple Monte-Carlo Concurrente PI.");
                        opcion = new Scanner(System.in);
                        opt = opcion.nextInt();

                        switch(opt)
                        {
                            case 1:
                               piMonteCarloUni.main(null);
                               break;
                            case 2:
                                piMonteCarloFuture.main(null);
                                break;
                            case 3:
                                piMonteCarloMulti.main(null);
                                break;
                            default:
                                break;
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada - 5: " + e);
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
