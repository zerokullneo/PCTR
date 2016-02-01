/*@author Antonio Tomeu
 *@version 1.0
 *Clase que define la interfaz de objetos servidores remotos
 *Nota: Adaptado de  Liu, M. Computacion Distribuida
 **/
 
import java.rmi.*;

public interface InterfazServidor
	extends Remote
{
	public String Hola() throws RemoteException;
	public void RegistroCallBack(InterfazCliente ObjetoCallBack) throws RemoteException;
	public void QuitarCallBack(InterfazCliente ObjetoCallBack) throws RemoteException;
}