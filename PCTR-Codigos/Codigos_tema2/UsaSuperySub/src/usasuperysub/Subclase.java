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
public class Subclase extends Superclase //hereda de superclase
{
	public Subclase()
	{
		super(3);
	}
	//sobreescribe el metodo accion, con otro compartamiento
	public void accion(double a, double b)
	{
		System.out.println("La hipotenusa es "+Math.sqrt(Math.pow(a,2)+Math.pow(b,2)));
	}
}
