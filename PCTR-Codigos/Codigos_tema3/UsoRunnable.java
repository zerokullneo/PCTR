/*Otra forma de crear hilos concurrentes
*Utiliza Runnable como medio de definir el trabajo que el hilo  *debe hacer
*@author Antonio J. Tomeu
 *
*/
public class UsoRunnable implements Runnable
{
	private String Cadena;
	public UsoRunnable(String Palabra)
	{Cadena=Palabra;}
	
	public void run()                      
	{
       	 for(;;)
	  System.out.println(Cadena);
       }
    public static void main(String[] args) 
    {
    	UsoRunnable Hilo1 = new UsoRunnable("Hola");
    	UsoRunnable Hilo2 = new UsoRunnable("Adios");
    	new Thread(Hilo1).start();
    	new Thread(Hilo2).start();
    }
}