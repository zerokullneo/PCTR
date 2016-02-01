/**Ejemplo de Hilos Concurrentes
 * Muestra la creacion y ejecución concurrente de varios hilos
 * @author Antonio Tomeu
 */
 
 public class Hola_Adios extends Thread
 {
 	private String Cadena;
 	
 	private void otrometodo()
	{System.out.println ("otro metodo");}
	  
 	public Hola_Adios (String Palabra)
 	{Cadena = Palabra;}
 	
 	public void run ()
 	{
 	  for(int i=1; i<100; i++){ 	
 	    System.out.println(Cadena);
 	    this.otrometodo(); // run puede invocar otros metodos de la clase
		Integer p = new Integer(3); //o crear objetos
 	  }	
 	}
 	
 	public static void main (String[] args)
 	{
 	   	new Hola_Adios ("Hola").start();
 		new Hola_Adios ("Hola").start();
 		new Hola_Adios ("Adios").start();
 		new Hola_Adios ("Adios").start();
 		 		      
 	}	
 	
 }