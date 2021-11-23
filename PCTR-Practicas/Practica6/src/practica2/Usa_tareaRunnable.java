/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica2;

/**Descripcion
 * Clase que simula las acciones recogidas por parámetro.
 */
public class Usa_tareaRunnable
{
     public static void main(String[] args) throws Exception
     {
	  tareaRunnable tareaUno = new tareaRunnable("inc");
	  tareaRunnable tareaDos = new tareaRunnable("dec");
	  Thread h1 = new Thread(tareaUno);
	  Thread h2 = new Thread(tareaDos);
	  
	  h1.start(); h2.start();
	  h1.join(); h2.join();
	  System.out.println("Valor de n es " + tareaUno.getDato() + " con Runnable");
     }
}
