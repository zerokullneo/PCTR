/**Ejemplo de Hilos Concurrentes
 * Muestra la creacion y ejecución concurrente de varios hilos
 * @author Antonio Tomeu
 */
 
 public class Hola_Adios extends Thread
 {
 	private String Cadena;
 	
 	public Hola_Adios (String Palabra)
 	{Cadena = Palabra;}
 	
 	public void run ()
 	{
 	  for(;;) 	
 	    System.out.println(Cadena);
 	}
 	
 	public static void main (String[] args)
 	{
 	   	new Hola_Adios ("Hola").start();
 		new Hola_Adios ("Hola").start();
 		new Hola_Adios ("Adios").start();
 		new Hola_Adios ("Adios").start();
 		 		      
 	}	
 	
 }