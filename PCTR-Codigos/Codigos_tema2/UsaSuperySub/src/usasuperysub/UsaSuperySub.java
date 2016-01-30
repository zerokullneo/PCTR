/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usasuperysub;

/**
 *
 * @author zerokullneo
 */
public class UsaSuperySub
{

     /**
      * @param args the command line arguments
      */
     public static void main(String[] args)
     {
	// TODO code application logic here
	Superclase A = new Superclase(10);
	Subclase B = new Subclase();
	A.accion(); //superclase usa metodo original
	B.accion(3,4); //subclase usa metodo sobreescrito
	A.hola();
	B.hola(); //y esto, que significa?
     }
     
}
