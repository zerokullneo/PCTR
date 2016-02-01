/*Otra forma de crear hilos concurrentes dandoles nombre
 *Utiliza Runnable como medio de definir el trabajo que el hilo debe hacer
 *especificando este en el metodo run. Una vez especificado, tal trabajo es 
 *dado a un trabajador (un hilo), creado explicitamente mediante new Tread(objeto)
 *objeto es de clase Runnable, y le indica al hilo el trabajo (recogido en run)
 *a ejecutar.
 *@author Antonio J. Tomeu
 *
*/

public class UsoRunnable2 implements Runnable
{
	private int Iter;
	public UsoRunnable2(int Dato)
	{Iter = Dato;}
	
	public void run()
	{
		for(int i=1;i<=Iter;i++)
		  System.out.println("Trabajando");
	}	
	
	public static void main(String[] args)
	  throws InterruptedException
	{
		Runnable HiloA = new UsoRunnable2(10);
		Runnable HiloB = new UsoRunnable2(20);
		Runnable HiloC = new UsoRunnable2(10);
		
		//esta version del constructor Thread crea el un hilo con el codigo
		//ejecutable indicado por la implementacion de Runnable, y el asigna
		//el nombre que el programador quiere.
		Thread A = new Thread(HiloA, "Mi Hilo");
		Thread B = new Thread(HiloB, "Tu Hilo"); //sin nombre
		Thread C = new Thread(HiloC);
		A.start();
		B.start();
		C.start();
		//el metdo getName() de un objeto de la clase Thead devuelve el nombre
		//del hilo
		System.out.println(A.getName());
		System.out.println(B.getName());
		//no tenia nombre, pero se le dio uno en tiempo de ejecucion.
		System.out.println(C.getName()); 
		A.join();
		B.join();
		C.join();
		
	}
}