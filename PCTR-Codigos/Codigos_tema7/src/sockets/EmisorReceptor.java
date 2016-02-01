import java.net.*;

/**
*		Este ejemplo ilustra un proceso que envía y después recibe
*		utilizando un socket datagrama.
*       Adaptado de Liu (Computacion Distribuida)
*/
public class EmisorReceptor 
{
 //  Una aplicación que manda y que después recibe un mensaje utilizando
 //  un socket datagrama sin conexión:
 //  Se esperan cuatro argumentos de línea de mandato, en orden:
 //  <nombre de dominio o dirección IP del receptor>
 //  <número de puerto del socket datagrama del receptor>
 //  <mensaje, una cadena, para mandar>

  public static void main(String[ ] args) 
  {
	  if (args.length != 4)
	    System.out.println
	    ("Este programa requiere 4 argumentos de línea de mandato");
	  else {
	    try {
	      InetAddress maquinaReceptora = InetAddress.getByName(args[0]);
		int puertoReceptor = Integer.parseInt(args[1]);
		int miPuerto = Integer.parseInt(args[2]);
		String mensaje = args[3];
	      MiSocketDatagrama miSocket = new MiSocketDatagrama(miPuerto);
		//  instancia un socket datagrama para enviar
		//  y recibir datos
		miSocket.enviaMensaje( maquinaReceptora, puertoReceptor,mensaje);
		//  ahora espera recibir un datagrama por el socket
		System.out.println(miSocket.recibeMensaje());
		miSocket.close();
	    } // fin de try
	    catch (Exception ex) {
	      ex.printStackTrace();
	    } // fin de catch
    } // fin de else
  } // fin de main

} // fin de class
