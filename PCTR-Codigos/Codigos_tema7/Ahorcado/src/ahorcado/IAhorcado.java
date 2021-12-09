/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado;

import java.rmi.*;
/**
 *
 * @author zerokullneo
 */
public interface IAhorcado extends Remote
{
	public boolean enviarCaracter(char c) throws RemoteException; 
	public String estadoActual() throws RemoteException;
}
