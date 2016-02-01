import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hola_Mundo 
	extends Remote {
    String Mensaje() throws RemoteException;
}
