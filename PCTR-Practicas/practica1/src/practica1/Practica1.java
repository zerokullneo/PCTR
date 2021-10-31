 /*
 
* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Jose M Barba
 */
public class Practica1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner opcion;
        int opt;
        String[] s;
        
        do
        {
            System.out.println("Menu");
            System.out.println("1.- Jerarquia de Clases.");
            System.out.println("2.- Newton-Raphson.");
            System.out.println("3.- Definida MonteCarlo.");
            System.out.println("4.- Secuencia Estadística.");
            System.out.println("5.- Complejos.");
            System.out.println("0.- Salir.");
            opcion = new Scanner(System.in);
            opt = opcion.nextInt();
            
            switch(opt)
            {
                case 1:
                    System.out.println("Ejercicio Jerarquia de Clases.");
                    try
                    {
                        jerarquiaClases.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada: " + e);
                    }
                    break;
                case 2:
                    System.out.println("Ejercicio Newton-Raphson.");
                    try
                    {
                        NewtonRaphson.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada: " + e);
                    }
                    break;
                case 3:
                    System.out.println("Ejercicio Definida MonteCarlo.");
                    intDefinidaMonteCarlo.main(null);
                    break;
                case 4:
                    System.out.println("Secuencia Estadística.");
                    try
		    {
			 Estadistica.main(null);
		    }
		    catch(Exception e)
		    {
			 System.out.println("Error entrada: " + e);
		    }
                    break;
                case 5:
                    System.out.println("Ejercicio Complejos.");
                    try
                    {
                        usaComplejos.main(null);
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
