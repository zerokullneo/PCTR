/*@author Antonio Tomeu
 *@version 1.0
 *Clase que implementa la interfaz de objetos servidores remotos
 *Nota: Adaptado de  Liu, M. Computacion Distribuida
 **/
 
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class ImpInterfazServidor
	extends UnicastRemoteObject
		implements InterfazServidor
{
	private Vector ListaClientes;
	
	public ImpInterfazServidor() throws RemoteException
	{
		super();
		ListaClientes = new Vector();
	}
	
	public String Hola() throws RemoteException
	{return("Hola capullo...");}
	
	public synchronized void RegistroCallBack(InterfazCliente ObjetoCallBack) throws RemoteException
	{	
		if(!(ListaClientes.contains(ObjetoCallBack))){ListaClientes.addElement(ObjetoCallBack);
		System.out.println("Nuevo cliente de callback registrado...");
		EfectuarCallBack();}
	}	
	
	public synchronized void QuitarCallBack(InterfazCliente ObjetoCallBack) throws RemoteException
	{
			if(ListaClientes.removeElement(ObjetoCallBack))
			  System.out.println("Cliente eliminado...");
			  else System.out.println("Cliente no registrado...");
	}
	
	private synchronized void EfectuarCallBack()throws RemoteException
	{
		for(int i=0; i<ListaClientes.size(); i++)
		{
			InterfazCliente Cliente = (InterfazCliente) ListaClientes.elementAt(i);
			Cliente.Senial ("Eres el cliente número: " + i);
		}//for
	}
}