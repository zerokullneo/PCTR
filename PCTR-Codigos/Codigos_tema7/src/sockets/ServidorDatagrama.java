/*Ejemplo de servidor con n sockets de datagrama
 *@Antonio Tomeu
 *@version 1.0
 */
 
import java.net.*;
import java.io.*;

public class ServidorDatagrama
{
	public static void main (String[] args)
	{
		byte [] buffer = new byte[20];
		String Cadena  = "";
		String Accion;
		DatagramPacket Entrada  = null;
		DatagramPacket Salida   = null;
		DatagramSocket misocket = null;
		InetAddress IPCliente   = null;
		try
		{
			//creamos un socket de datagrama sobre un puerto local
			misocket = new DatagramSocket(3002);
			//se esperan peticiones de clientes...
			System.out.println("Esperando peticiones de clientes...");
			while(true)
			{
				Entrada = new DatagramPacket(buffer, buffer.length);
				misocket.receive(Entrada);
				//aqui iria activacion del hilo de tratamiento
				//de la solicitud.
				buffer = Entrada.getData();
				IPCliente = Entrada.getAddress(); //por si queremos responder...
				System.out.println("Se solicito desde el cliente hacer operacion de: "+new String(buffer));
				
			}//while
	    }catch (Exception e) {System.err.println(e);}
	    //cerramos la conexion...
	    misocket.close();
	 }//main 
}//ServidorDatagrama	   