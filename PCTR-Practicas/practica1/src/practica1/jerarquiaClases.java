/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.Scanner;

/**
 *
 * @author zerokullneo
 */
public class jerarquiaClases {
     public static void main(String[] args)
     {
	  Scanner entrada;
	  practica1.Animal.Conejo conejo = new practica1.Animal.Conejo("");
	  practica1.Animal.Leon leon = new practica1.Animal.Leon("Simba");
	  practica1.Animal.Hiena hiena = new practica1.Animal.Hiena("");
	  practica1.Animal.Hombre sapiens = new practica1.Animal.Hombre("Juanito");
	  
	  System.out.println("Haciendo uso de las clases Conejo y Hervivoro...");
	  System.out.println(conejo.getHervivoro());
	  System.out.println(conejo.getConejo());
	  
	  System.out.println("Haciendo uso de las clases León o Hiena y Carnivoro...");
	  System.out.println(leon.getCarnivoro());
	  System.out.println(leon.getLeon());
	  
	  System.out.println(hiena.getCarnivoro());
	  System.out.println(hiena.getHiena());
	  
	  System.out.println("Modificando el objeto Hiena...");
	  entrada = new Scanner(System.in);
	  String animal = entrada.next();
	  hiena.setHiena(animal);
	  System.out.println(hiena.getCarnivoro());
	  System.out.println(hiena.getHiena());
	  
	  System.out.println("Haciendo uso de las clases Hombre y Omnivoro...");
	  System.out.println(sapiens.getOmnivoro());
	  System.out.println(sapiens.getHombre());
     }
}
