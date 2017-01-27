/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoja2;

import java.util.Scanner;

/**
 *
 * @author Jose Manuel Barba Gonzalez <zk at wordpress.com>
 */
public class Hoja2
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
            System.out.println("--- Menu Hoja 2 ---");
            System.out.println("1.- UsacPlanetario.");
            System.out.println("2.- UsaSemaforo.");
            System.out.println("3.- UsaPunto.");
            System.out.println("4.- UsaMatriz.");
            System.out.println("5.- UsaPolinomio.");
            System.out.println("6.- Suma.");
            System.out.println("7.- Automata Celular.");
            System.out.println("0.- Salir.");
            opcion = new Scanner(System.in);
            opt = opcion.nextInt();
            
            switch(opt)
            {
                case 1:
                    System.out.println("Ejercicio Planetario.");
                    UsacPlanetario.main(null);
                    break;
                case 2:
                    System.out.println("Ejercicio Semaforo.");
                    try
                    {
                        UsaSemaforo.main(null);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error entrada: " + e);
                    }
                    break;
                case 3:
                    System.out.println("Ejercicio Punto.");
                    UsaPunto.main(null);
                    break;
                case 4:
                    System.out.println("Ejercicio Matriz.");
                    UsaMatriz.main(null);
                    break;
                case 5:
                    System.out.println("Ejercicio Polinomio.");
                    UsaPolinomio.main(null);
                    break;
                case 6:
                    System.out.println("Ejercicio Suma.");
                    Suma.main(null);
                    break;
                case 7:
                    System.out.println("Ejercicio Automata Celular.");
                    AutomataCelular.main(null);
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
