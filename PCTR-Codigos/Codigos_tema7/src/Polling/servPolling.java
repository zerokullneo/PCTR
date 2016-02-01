/**
 * @(#)servPolling.java
 * @author A.T.
 * @version 1.00 2012/1/11
 */

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class servPolling 
  extends UnicastRemoteObject
  	implements ejemploPolling
{
	private static int dato = 0;
        
    public void datoInc() throws RemoteException
    {dato++; System.out.println(dato);}
    
    public boolean igualDiez() throws RemoteException
    {return (dato==10);}
    
    public servPolling() throws RemoteException {}
    
    public static void main(String[] args) 
      throws Exception
    {
       servPolling contRemoto = new servPolling(); 		
 	   Naming.bind("Servidor_Polling", contRemoto);
 	   System.out.println("Servidor Remoto Preparado");
    }
}
