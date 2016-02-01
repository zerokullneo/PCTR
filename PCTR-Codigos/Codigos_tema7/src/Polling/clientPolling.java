/**
 * @(#)clientPolling.java
 * @author A.T.
 * @version 1.00 2012/1/11
 */

import java.rmi.*;
import java.rmi.registry.*;

public class clientPolling 
{
    
  public static void main(String[] args) 
  	throws Exception
  {
  	ejemploPolling RefObRemoto = (ejemploPolling)Naming.lookup("//localhost/Servidor_Polling");
		  	
	while(!RefObRemoto.igualDiez())
	{System.out.println("Incremento remoto del contador");
	  RefObRemoto.datoInc();
	}
	System.out.print("El contador remoto llego a diez y se sale...");  		 
		 	
  }
}
