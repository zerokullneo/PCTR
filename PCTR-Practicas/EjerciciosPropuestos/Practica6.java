/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica6;

import java.util.Scanner;

/**
 *
 * @author zerokullneo
 */
public class Practica6
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
            System.out.println("1.- Ejercicio Volcado de Red Secuencial.");
            System.out.println("2.- Ejercicio Volcado de Red Paralelo.");
            System.out.println("3.- Ejercicio Matriz Concurrente.");
            System.out.println("4.- Ejercicio Resaltar imagen.");
            System.out.println("5.- Ejercicio Resaltar imagen Grano Fino.");
            System.out.println("6.- Ejercicio Resaltar imagen Grano Grueso.");
            System.out.println("0.- Salir.");
            opcion = new Scanner(System.in);
            opt = opcion.nextInt();
            
            switch(opt)
            {
                case 1:
                    System.out.println("Ejecutando Volcado de Red Secuencial...");
                    try
                    {
                        volcadoRedSecuencial.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada: " + e);
                    }
                    break;
                case 2:
                    System.out.println("Ejecutando Volcado de Red Paralelo...");
                    try
                    {
                        String[] ar = new String[1];
			ar[0] = "0.5";
                        volcadoRed.main(ar);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada: " + e);
                    }
                    break;
                case 3:
                    System.out.println("Ejecutando Matriz Concurrente...");
                    try
                    {
                        String[] ar = new String[2];
			ar[0] = "10"; ar[1] = "0.5";
                        matVectorConcurrente.main(ar);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada: " + e);
                    }
                    break;
                case 4:
                    System.out.println("Ejecutando Resaltar imagen...");
                    try
                    {
                        resImagen.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada: " + e);
                    }
                    break;
                case 5:
                    System.out.println("Ejecutando Resaltar imagen Grano Fino...");
                    try
                    {
                        String[] ar = new String[1]; 
			ar[0] = "0.5";
                        resImagenParFin.main(ar);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada: " + e);
                    }
                    break;
                case 6:
                    System.out.println("Ejecutando Resaltar imagen Grano Grueso...");
                    try
                    {
                        resImagenParGru.main(null);
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
