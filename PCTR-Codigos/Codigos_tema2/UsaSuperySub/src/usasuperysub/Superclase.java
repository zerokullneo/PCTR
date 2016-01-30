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
public class Superclase
{
     	private int i;
	public Superclase(int dato) {i=dato;}
	public void accion()
	{
		for(int cont=1;cont<i; cont++)
			System.out.println("Superclase escribiendo...");
	}
	public void hola()
	{
		System.out.println("hola");
	}
}
