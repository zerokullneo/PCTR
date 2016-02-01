/**
 * @(#)Client_Hola_Mundo.java
 *
 *
 * @author 
 * @version 1.00 2009/5/3
 */


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client_Hola_Mundo {

    private Client_Hola_Mundo() {}

    public static void main(String[] args) {

	try {
	    Registry registry = LocateRegistry.getRegistry("localhost");
	    Hola_Mundo stub = (Hola_Mundo) registry.lookup("Hola");
	    String respuesta = stub.Mensaje();
	    System.out.println(respuesta);
	} catch (Exception e) {
	    System.err.println("Error en el cliente: " + e.toString());
	    e.printStackTrace();
	}
    }
}
