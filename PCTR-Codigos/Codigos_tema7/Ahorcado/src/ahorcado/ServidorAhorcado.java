/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author zerokullneo
 */
public class ServidorAhorcado extends UnicastRemoteObject implements IAhorcado
{
	String palabra = "frio", estado = "****";
	
	public boolean enviarCaracter(char c) throws RemoteException
	{
		System.out.println("Se prueba el caracter " + c);
		if(palabra.contains("" + c))
		{
			char[] nuevoEstado = estado.toCharArray();
			for(int i = 0; i < nuevoEstado.length; i++)
				if(palabra.charAt(i) == c)
					nuevoEstado[i] = c;
			estado = new String(nuevoEstado);
			return true;
		}
		else return false;
	}
	
	public String estadoActual() throws RemoteException
	{
		System.out.println("El estado actual es " + estado);
		return estado;
	}
}
