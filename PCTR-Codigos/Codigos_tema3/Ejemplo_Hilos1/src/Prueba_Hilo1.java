/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zerokullneo
 */
public class Prueba_Hilo1 //Hace uso de la clase anterior
{
	public static void main (String [] args) throws InterruptedException
	{
		Ejemplo_Hilos1 Hilo1 = new Ejemplo_Hilos1 (1225);
		Ejemplo_Hilos1 Hilo2 = new Ejemplo_Hilos1 (3435);
		Ejemplo_Hilos1 Hilo3 = new Ejemplo_Hilos1 (3435);
		Ejemplo_Hilos1 Hilo4 = new Ejemplo_Hilos1 (3435);
		Ejemplo_Hilos1 Hilo5 = new Ejemplo_Hilos1 (3435);
		Hilo1.start ();  //Ahora se lanzan ambos hilos...
		Hilo1.join ();
		Hilo2.start ();
		Hilo2.join ();
		Hilo3.start ();
		Hilo3.join ();
		Hilo4.start ();
		Hilo4.join ();
		Hilo5.start ();
		Hilo5.join ();
		System.out.println ("Hilos terminados");
	}
}
