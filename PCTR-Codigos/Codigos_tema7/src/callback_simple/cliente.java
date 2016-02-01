/**
 * @(#)cliente.java
 * @author A.T.
 * @version 1.00 2012/1/11
 */

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class cliente
  extends UnicastRemoteObject
    implements interfazCliente
{
  boolean igualDiez = false;	
  	
  public cliente() throws RemoteException {}
  public void notificarigualDiez() throws RemoteException
  {System.out.println("Contador remoto llego a diez... y sigue...");}
  	   	
 
}
