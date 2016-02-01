/*Ejemplo de servidor de sockets
*@Antonio Tomeu
*@version 1.0
*/

import java.io.*;
import java.net.*;

public class SocketServidor
{
    public static final int port = 3001; //pues ahora con otro puerto

    public static void main (String [] args)
        throws IOException
    {
        //unas cuantas conexiones...
        ServerSocket GenSocket = new ServerSocket(port, 30);
        System.out.println("El servidor esta escuchando en: "+ GenSocket);
        while(true){
        
        try{
        
            //a la espera de solicitud de conexion desde cliente...
            
            Socket enchufe = GenSocket.accept();
            PrintWriter salida= new PrintWriter(
                                    new BufferedWriter(
                                        new OutputStreamWriter(
                                            enchufe.getOutputStream())),true);
            
            //Dando mejor servicio... todo sea por Bolonia...
            salida.println("Saludo, estimado estudiante de Ingenieria Informatica...");
			System.out.println("A la espera de nueva solicitud en: "+ GenSocket);          
                     
       } finally { //System.out.println("se cierra la conexión actual...");
                   //GenSocket.close();
                 }//finally
      }//while           
    }//main
}//SocketServidor