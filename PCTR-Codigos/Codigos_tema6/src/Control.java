
/**Ejemplo de Hilo hijo controlado por hilo padres
 * Muestra la creacion y ejecución concurrente de varios hilos
 * @author Antonio Tomeu
 */

import java.io.*;
import java.util.*;

public class Control extends Thread
{
	//No se declara un constructor explicito.Se usara el disponible por defecto

	public void run()
	{
		for(;;)
		  System.out.println("Trabajando");
	}


	public static void main(String[] args)
	  throws IOException
	{
		int c;

		Control Hilo = new Control(); //usando el constructor implicito
		Hilo.start();
		//un poquito de interfoliacion
		for(int i=1; i<=100; i++)
		  System.out.println("Hola soy el padre");
		//Ahora el hilo padre bloquea al hijo.
		Hilo.suspend();
		System.out.println("Hijo suspendido");
		//Ahora reactivamos al hijo, que pasa a listo.
		System.out.println("Pulsa 223 para despertar al hijo");
		do {
			Scanner in = new Scanner(System.in);
            System.out.print("Teclea un entero ");
            c = in.nextInt();
		   }
		 while(c != 223);
		Hilo.resume();
		//un poquito de interfoliacion otra vez.
		for(int i=1; i<=100; i++)
		  System.out.println("Hola soy el padre");
		//Ahora destruimos al hijo. Esto no debe hacerse NUNCA...
		//como vera cuando compile, ya que el compilador le avisara...
		//de estar utilizando un API derogada.
		//Hilo.stop();
		System.out.println("Padre finalizando...");

	}

}

