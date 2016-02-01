/*@author Antonio Tomeu
 *@version 1.0
 *Clase que implementa el metodo que via callback un objeto servidor puede invocar
 *sobre un objeto cliente
 *Nota: Adaptado de  Liu, M. Computacion Distribuida
 **/
 
import java.rmi.*;
import java.rmi.server.*;

public class ImpInterfazCliente
	extends UnicastRemoteObject
		implements InterfazCliente
{
	public ImpInterfazCliente() throws RemoteException
	{
		super();
	}
	
	public String Senial(String mensajito)
	{
		String Respuesta = "Senial recibida: "+mensajito;
		System.out.println(Respuesta);
		return (Respuesta);
	}
}