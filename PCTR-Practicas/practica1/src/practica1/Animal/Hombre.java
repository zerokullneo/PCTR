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
public class Hombre extends Omnivoro
{
     private String hombre;
     
     /**
      *
      * @param h
      */
     public Hombre(String h)
     {
	  super("");
	  if("".equals(h))
	       h = "Hombre";
	  
	  hombre = h;
     }
     
     /**
      *
      * @return
      */
     public String getHombre(){ return "Soy un " + hombre; }
     
     /**
      *
      * @param h
      */
     public void setHombre(String h)
     {
	  hombre = h;
     }
}
