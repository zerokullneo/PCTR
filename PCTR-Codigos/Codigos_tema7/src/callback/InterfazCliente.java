/*@author Antonio Tomeu
 *@version 1.0
 *Clase que define el metodo que via callback un objeto servidor puede invocar
 *sobre un objeto cliente
 *Nota: Adaptado de  Liu, M. Computacion Distribuida
 **/
 
import java.rmi.*;

public interface InterfazCliente
	extends java.rmi.Remote
{
	public String Senial(String mensajito) throws java.rmi.RemoteException;
}