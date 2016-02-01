class Sincro
	
{	int Turno;
	
	public Sincro(int t)
	{Turno = t;}
	
	public synchronized void metodo1()
	{
		while(Turno != 1)	
		  try {wait();} catch (Exception e){}
		System.out.println(" Turno al hilo1...");  
		Turno=2;
		notifyAll();
	}
	
	public synchronized void metodo2()
	{
		while(Turno != 2)
		  try {wait();} catch (Exception e){}
		System.out.println("Turno al hilo 2...");  
		Turno = 3;
		notifyAll();
	}
	
	
	public synchronized void metodo3()
	{
		while(Turno != 3)	
		  try {wait();} catch (Exception e){}
		System.out.println("Turno al hilo 3...");  
		Turno = 1;
		notifyAll();
	}
	
}//Sincro
	
	class Hilo1 extends Thread
	{
		Sincro ref;
		public Hilo1(Sincro obj){ref=obj;}
		public void run()
		{
			for(;;){ref.metodo1();}
		}	
	}//Hilo1
	
	
class Hilo2 extends Thread
	{
		Sincro ref;
		public Hilo2(Sincro obj){ref=obj;}
		public void run()
		{
			for(;;){ref.metodo2();}
		}	
	}//Hilo2
	
	class Hilo3 extends Thread
	{
		Sincro ref;
		public Hilo3(Sincro obj){ref=obj;}
		public void run()
		{
			for(;;){ref.metodo3();}
		}	
	}//Hilo3
	

	
	
public class Sincronizacion
{	
	public static void main (String [] args)	
	{
		Sincro m = new Sincro(2);
		new Hilo1(m).start();
		new Hilo2(m).start();
		new Hilo3(m).start();
		System.out.println("hilos lanzados...");
		
	}//main	
}//Sincronizacion
