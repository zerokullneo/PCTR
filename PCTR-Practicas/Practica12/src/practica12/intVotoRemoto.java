/**
 * @author David Moreno Del Valle
 */

import java.rmi.*;

public interface intVotoRemoto extends Remote {

   public void Votar(String v)throws RemoteException;
   public int Votos() throws RemoteException;
   public int VotosSi()throws RemoteException;
   public int VotosNo()throws RemoteException;
   public int VotosNs()throws RemoteException;

}
