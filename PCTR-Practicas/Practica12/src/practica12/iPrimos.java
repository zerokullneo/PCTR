/**
 * @author David Moreno Del Valle
 */


import java.rmi.*;

public interface iPrimos extends Remote {

    public int NumPrimos(int li, int ls) throws RemoteException;
    public boolean esPrimo(int n) throws RemoteException;

}
