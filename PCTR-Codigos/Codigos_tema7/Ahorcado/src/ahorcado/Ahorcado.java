/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado;

import java.rmi.Naming;

/**
 *
 * @author zerokullneo
 */
public class Ahorcado {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws Exception
	{
		ServidorAhorcado OServidor = new ServidorAhorcado();
		Naming.lookup("juegoahorcado");
	}
	
}
