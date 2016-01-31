/**
 * @author David Moreno Del Valle
 */



import java.rmi.*;

public interface iPiMonteCarlo
 extends Remote
 {
 	public void reset() throws RemoteException;
 	public void masPuntos(int nPuntos) throws RemoteException;
 }
