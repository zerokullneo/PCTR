/**
 * @(#)Serv_Hola_Mundo.java
 *
 *
 * @author 
 * @version 1.00 2009/5/3
 */


import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
	
public class Serv_Hola_Mundo 
	implements Hola_Mundo {
	
    public Serv_Hola_Mundo() {}

    public String Mensaje() {
	return "En un lugar de la Mancha, de cuyo nombre no quiere acordarme...";
    }
	
    public static void main(String args[]) {
	
	try {
	    Serv_Hola_Mundo obj_rem = new Serv_Hola_Mundo();
	    Hola_Mundo stub = (Hola_Mundo) UnicastRemoteObject.exportObject(obj_rem, 0);

	    // Registradon el objeto servidor en el servicio de nombres
	    Registry registry = LocateRegistry.getRegistry();
	    registry.bind("Hola", stub);

	    System.out.println("Servidor Remoto Preparado...");
	} catch (Exception e) {
	    System.err.println("Error en Servidor: " + e.toString());
	    e.printStackTrace();
	}
    }
}
