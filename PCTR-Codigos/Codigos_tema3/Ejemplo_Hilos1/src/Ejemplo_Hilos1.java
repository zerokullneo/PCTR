/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zerokullneo
 */
public class Ejemplo_Hilos1 extends Thread
{
	public Ejemplo_Hilos1 (int Tope) //constructor
	{
		T = Tope;
	}

	public void run ()
	{
		for (int i = 1; i <= T; i++)
			System.out.println (i);
	}
	private int T ;     
}
