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
public class Hiena extends Carnivoro
{
     private String hiena;
     
     /**
      *
      * @param h
      */
     public Hiena(String h)
     {
	  super("");
	  if("".equals(h))
	       h = "Hiena";
	  
	  hiena = h;
     }
     
     /**
      *
      * @return
      */
     public String getHiena(){ return "Soy una " + hiena; }
     
     /**
      *
      * @param h
      */
     public void setHiena(String h)
     {
	  hiena = h;
     }
}
