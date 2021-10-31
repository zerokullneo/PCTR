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
public class Hervivoro extends Animal
{
     private String hervivoro;
     
     /**
      *
      * @param h
      */
     public Hervivoro(String h)
     {
	  super(h);
	  if("".equals(h))
	       h = "Hervivoro";

	  hervivoro = h;
     }
     
     /**
      *
      * @return
      */
     public String getHervivoro(){ return "Soy un Animal de la familia " + hervivoro; }
}
