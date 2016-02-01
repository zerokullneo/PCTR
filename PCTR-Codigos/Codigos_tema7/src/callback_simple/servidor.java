/**
 * @(#)servidor.java
 * @author A.T.
 * @version 1.00 2012/1/11
 */

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.*;

public class servidor
  extends UnicastRemoteObject
  	implements interfazServidor
{
	private static int dato = 0;
	private static Vector<interfazCliente> listClientes = new Vector<interfazCliente>();
	static interfazCliente ClientRemoto;
	
        
    public void datoInc() throws RemoteException
    {dato++; 
     System.out.println(dato);
     if(dato==10) hacerCallBack();
    }
    
    public void registrarCallBack(interfazCliente objetoCliente) throws RemoteException
    {listClientes.addElement(objetoCliente);
     System.out.println("Se registró un objeto remoto para callback...");
    }
    
    private void hacerCallBack() throws RemoteException
    {
    	for(int i=0;i<listClientes.size();i++)
    	  listClientes.elementAt(i).notificarigualDiez();
    }	
    
    
    public servidor() throws RemoteException {}
    
    public static void main(String[] args) 
      throws Exception
    {
       servidor contRemoto = new servidor(); 		
 	   Naming.bind("//localhost/Servidor_Incremento", contRemoto);
 	   System.out.println("Servidor Incremento Remoto Preparado");
    }
}
