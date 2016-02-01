import java.net.*;


/**
*	Este ejemplo ilustra la sintaxis b�sica de los sockets datagrama orientados
*	a conexi�n
*   Tomado de Liu, con modificaciones
*/
public class EmisorConexion	{

//	Una aplicaci�n que utiliza un socket datagrama orientado a conexi�n para
// mandar m�ltiples mensajes, despu�s recibe uno.
// Se esperan cuatro argumentos de l�nea de mandato, en orden:
// <nombre de dominio o direcci�n IP del receptor>
// <n�mero del puerto del socket datagrama del otro proceso>
// <n�mero del puerto del socket datagrama de este proceso>
// <mensaje, una cadena, para mandar>

	public static void main(String[] args) {
	  if (args.length != 4)
	     System.out.println
	     ("Este programa requiere 4 argumentos de l�nea de mandato");
	  else	{
	     try {
		InetAddress maquinaReceptora = InetAddress.getByName(args[0]);
		 int puertoReceptor = Integer. parseInt(args[1]);
		 int miPuerto = Integer.parseInt(args[2]);
		 String mensaje = args[3];
		 // instancia una socket datagrama para la conexi�n
		MiSocketDatagrama miSocket = new MiSocketDatagrama(miPuerto);
		 // hace la conexi�n
		 miSocket.connect(maquinaReceptora, puertoReceptor);
		 for (int i=0; i<10; i++)
		   miSocket.enviaMensaje(maquinaReceptora, puertoReceptor, mensaje);
		 // ahora recibe un mensaje desde el otro extremo
		 System.out.println(miSocket.recibeMensaje( ));
		 // termina la conexi�n, despu�s cierra el socket
		 miSocket.disconnect( );
		 miSocket.close( );
	      } //fin de try
	      catch (Exception ex) {
		 ex.printStackTrace( );
	      } //fin de match
  } //fin de else
} //fin de main
    }  // fin de class
