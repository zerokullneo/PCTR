/**
 * @(#)interfazServidor.java
 * @author A.T.
 * @version 1.00 2012/1/11
 */

import java.rmi.*;
public interface interfazServidor
  extends Remote
 {
    public void datoInc() throws RemoteException;
    public void registrarCallBack(interfazCliente objetoCliente) throws RemoteException;
    
    
}