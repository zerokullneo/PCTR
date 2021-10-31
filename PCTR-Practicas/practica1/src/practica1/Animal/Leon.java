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
public class Leon extends Carnivoro
{
     private String leon;
     
     /**
      *
      * @param l
      */
     public Leon(String l)
     {
	  super("");
	  if("".equals(l))
	       l = "León";
	  
	  leon = l;
     }
     
     /**
      *
      * @return
      */
     public String getLeon(){ return "Soy un " + leon; }
     
     /**
      *
      * @param l
      */
     public void setLeon(String l)
     {
	  leon = l;
     }
}
