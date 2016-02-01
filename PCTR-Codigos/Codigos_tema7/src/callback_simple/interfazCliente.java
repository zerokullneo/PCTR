/**
 * @(#)interfazCliente.java
 * @author A.T.
 * @version 1.00 2012/1/11
 */

import java.rmi.*;
public interface interfazCliente 
  extends java.rmi.Remote
{
  public void notificarigualDiez() throws RemoteException;   
}