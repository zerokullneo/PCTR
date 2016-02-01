/*Ejemplo de uso de Servicios Existentes
 *@Antonio Tomeu
 *@version 1.0
 */

import java.net.*;
import java.io.*;

public class ClienteEco
{
	public static void main (String[] args)
	  throws IOException
	{
		
		Socket conexion = new Socket("una.ip.valida", 7);
	
		try{
				
			PrintWriter salida = new PrintWriter (conexion.getOutputStream());
			InputStream entrada = conexion.getInputStream();
			
			for(int i = 0; i < args.length-1; i++)
			  salida.print(args[i]+" ");
			salida.println (args[args.length-1]);
			int c;
			
			while ((c=entrada.read()) != 1){
				System.out.print((char) c);
				if((char)c == '\n') break;
			}//while
	 	   System.out.println();
		   salida.close();  entrada.close(); conexion.close();

		} finally {System.out.println("Error");}
		  
	}//main
}//ClienteEco