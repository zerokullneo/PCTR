/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.Animal;

/**
 *
 * @author zerokullneo
 */
public class Animal
{

     /**
      *
      */
     private final String animal;
     
     /**
      *
      * @param a
      */
     public Animal(String a)
     {
	  if("".equals(a))
	       a = "Animal";

	  animal = a;
     }
     
     /**
      *
      * @return
      */
     public String getAnimal(){ return animal;}
     
     
}
