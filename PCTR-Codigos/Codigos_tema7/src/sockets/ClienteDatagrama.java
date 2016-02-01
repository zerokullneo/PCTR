/*Ejemplo de cliente con sockets de datagrama
 *@Antonio Tomeu
 *@version 1.0
 */
 
import java.net.*;
import java.io.*;

public class ClienteDatagrama
{
	public static void main (String[] args)
	{
		byte [] buffer = new byte[20];
		String Cadena  = "";
		String Accion;
		DatagramPacket Entrada = null;
		DatagramPacket Salida  = null;
		try
		{
			//creamos un socket de datagrama sobre un puerto local
			DatagramSocket misocket = new DatagramSocket ();
			//Obtenemos la direccion del servidor
			InetAddress DirIP = InetAddress.getLocalHost();
			Accion = "sumar";
			buffer = Accion.getBytes();
			//preparamos el paquete a enviar...
			Salida = new DatagramPacket(buffer, Accion.length(), DirIP, 3002);
			//enviamos el paquete...
			misocket.send(Salida);
		}//try
		catch (Exception e) {System.err.println(e);}
		
	}//main
}//ClienteDatagrama