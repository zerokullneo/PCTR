/**
 * @author David Moreno Del Valle
 */


import java.util.*;
import java.net.*;
import java.rmi.*;

public class clientVotoRemoto {

    public static void main(String[]args){
    	try{
    		intVotoRemoto ORemoto = (intVotoRemoto)Naming.lookup("//localhost/Servidor");

    		Scanner v = new Scanner(System.in);
    		System.out.println("Introduce voto(si/no/ns):");

    		String a = v.nextLine();

	    	ORemoto.Votar(a);

	    	System.out.println("Votos Totales:"+ORemoto.Votos());
	    	System.out.println("Votos con Si:"+ORemoto.VotosSi());
	    	System.out.println("Votos con No:"+ORemoto.VotosNo());
	    	System.out.println("Votos con NS:"+ORemoto.VotosNs());
    	}catch(Exception e){}

}
}
