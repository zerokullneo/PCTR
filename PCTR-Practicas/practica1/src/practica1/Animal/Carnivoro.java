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
public class Carnivoro extends Animal
{
     private String carnivoro;
     
     /**
      *
      * @param c
      */
     public Carnivoro(String c)
     {
	  super(c);
	  if("".equals(c))
	       c = "Carnivoro";
	  
	  carnivoro = c;
     }
     
     /**
      *
      * @return
      */
     public String getCarnivoro(){ return "Soy un Animal de la familia " + carnivoro; }
}
