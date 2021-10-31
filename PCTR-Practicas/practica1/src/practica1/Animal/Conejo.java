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
public class Conejo extends Hervivoro
{
     private String conejo;
     
     /**
      *
      * @param c
      */
     public Conejo(String c)
     {
	  super("");
	  if("".equals(c))
	       c = "Conejo";
	  
	  conejo = c;
     }
     
     /**
      *
      * @return
      */
     public String getConejo(){ return "Soy un " + conejo; }
     
     /**
      *
      * @param c
      */
     public void setConejo(String c)
     {
	  conejo = c;
     }
}
