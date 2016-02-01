/*Ejemplo de uso de la clase InetAddress
 *@Antonio Tomeu
 *@version 1.0
 */
 
import java.net.*;

public class PruebaRed1
{
	public static void main(String [] args)
	  throws Exception
	{
		InetAddress DirIP = InetAddress.getByName("www.uca.es");
		System.out.println("La IP del servidor de la UCA es: "+DirIP.toString());
		InetAddress LocalIP = InetAddress.getLocalHost();
		System.out.println("y la IP de su maquina es: "+LocalIP.toString());
		DirIP = InetAddress.getByName("www.google.com");
		System.out.println("La IP del servidor de Google es: "+DirIP.toString());
		   
	}//main
}//PruebaRed1