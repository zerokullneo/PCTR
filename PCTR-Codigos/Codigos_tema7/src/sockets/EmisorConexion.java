import java.net.*;


/**
*	Este ejemplo ilustra la sintaxis básica de los sockets datagrama orientados
*	a conexión
*   Tomado de Liu, con modificaciones
*/
public class EmisorConexion	{

//	Una aplicación que utiliza un socket datagrama orientado a conexión para
// mandar múltiples mensajes, después recibe uno.
// Se esperan cuatro argumentos de línea de mandato, en orden:
// <nombre de dominio o dirección IP del receptor>
// <número del puerto del socket datagrama del otro proceso>
// <número del puerto del socket datagrama de este proceso>
// <mensaje, una cadena, para mandar>

	public static void main(String[] args) {
	  if (args.length != 4)
	     System.out.println
	     ("Este programa requiere 4 argumentos de línea de mandato");
	  else	{
	     try {
		InetAddress maquinaReceptora = InetAddress.getByName(args[0]);
		 int puertoReceptor = Integer. parseInt(args[1]);
		 int miPuerto = Integer.parseInt(args[2]);
		 String mensaje = args[3];
		 // instancia una socket datagrama para la conexión
		MiSocketDatagrama miSocket = new MiSocketDatagrama(miPuerto);
		 // hace la conexión
		 miSocket.connect(maquinaReceptora, puertoReceptor);
		 for (int i=0; i<10; i++)
		   miSocket.enviaMensaje(maquinaReceptora, puertoReceptor, mensaje);
		 // ahora recibe un mensaje desde el otro extremo
		 System.out.println(miSocket.recibeMensaje( ));
		 // termina la conexión, después cierra el socket
		 miSocket.disconnect( );
		 miSocket.close( );
	      } //fin de try
	      catch (Exception ex) {
		 ex.printStackTrace( );
	      } //fin de match
  } //fin de else
} //fin de main
    }  // fin de class
