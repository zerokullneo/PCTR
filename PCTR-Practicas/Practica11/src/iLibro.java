/**
 * @author David Moreno Del Valle
 */


import java.rmi.*;

public interface iLibro extends Remote {

    public void insertar(Libro l) throws RemoteException;
    public void eliminar(Libro l) throws RemoteException;
    public void consultarBD() throws RemoteException;
    public Libro consultarA(String A) throws RemoteException;
    public Libro consultarN(String N) throws RemoteException;

}
