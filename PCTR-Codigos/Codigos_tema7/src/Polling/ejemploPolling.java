/**
 * @(#)ejemploPolling.java
 * @author A.T.
 * @version 1.00 2012/1/11
 */

import java.rmi.*;
public interface ejemploPolling
  extends Remote
 {
    public void datoInc() throws RemoteException;
    public boolean igualDiez() throws RemoteException;
    
}