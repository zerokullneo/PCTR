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
public class Omnivoro extends Animal
{
     private String omnivoro;
     
     /**
      *
      * @param o
      */
     public Omnivoro(String o)
     {
	  super(o);
	  if("".equals(o))
	       o = "Omnivoro";
	  
	  omnivoro = o;
     }
     
     /**
      *
      * @return
      */
     public String getOmnivoro(){ return "Soy un Animal de la familia " + omnivoro; }
}
