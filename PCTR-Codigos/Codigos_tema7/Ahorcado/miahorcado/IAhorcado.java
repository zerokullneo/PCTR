import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAhorcado extends Remote {
    public boolean enviarCaracter(char c) throws RemoteException;
    public String estadoActual() throws RemoteException;
}
