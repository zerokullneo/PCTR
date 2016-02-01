/*Ejemplo de cliente de sockets
 *@Antonio Tomeu
 *@version 1.0
 */
 
import java.io.*;
import java.net.*;

public class SocketCliente	
{
	public static void main (String [] args)
		throws IOException
	{	
		//llamando al ordenador del despacho de al lado...
		InetAddress dir_IP = InetAddress.getByName("localhost");
		Socket enchufe = new Socket (dir_IP, 3001);
		System.out.println("Datos socket creado: "+enchufe);
		try{
			
			  	System.out.println("socket intentando leer...");
				BufferedReader entrada = new BufferedReader(
					                         new InputStreamReader(
					                         	 enchufe.getInputStream()));
				                         	 
				String cadena = entrada.readLine();	                         	 
				System.out.println(cadena);
			
		   }finally{ System.out.println("se cierra la conexión...");
		             enchufe.close();
		        
					}
	}//main		
}//SocketCliente