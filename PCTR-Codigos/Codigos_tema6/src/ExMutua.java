/*Ejemplo de Exclusion Mutua entre Hilos
 *@author Antonio J. Tomeu
 *Varios hilos concurrentes modifican un contador protegido bajo e.m.
 *El metodo que incrementa al contador es synchronized
 *Crea un array de hilos que incrementan bajo e.m. el contador
 *Sintaxis de uso: java ExMutua n m  donde:
 *n es el numero de hilos concurrentes
 *m es el valor inicial del contador
*/

class ObCritico
{
	private int Dato; //Contiene el objeto critico
	
	public ObCritico (int VInicial) //el constructor
	{Dato = VInicial;} 
	
	public synchronized void Incremento() //e ejecutar bajo e.m.
	{Dato++;}
	
	public int Valor () //hace una lectura. No necesita e.m.
	{return (Dato);}
}	

public class ExMutua extends Thread
{
	private ObCritico SC;
	
	public ExMutua (ObCritico SecCritica)
	{SC = SecCritica;}
	
	public void run()
	{
		for(;;)
		{
		  SC.Incremento();
		  System.out.println("El hilo con id. "+getName()+" ha ajustado el objeto a valor "+SC.Valor());	
		}  
	}	
	
	public static void main(String[] args)
	{
		if (args.length !=2)
		  { System.err.println ("Sintaxis: java ExMutua n m");
		    System.exit (1);
		  }	
		  
		int NumHilos = Integer.valueOf(args[0]).intValue(); //fija numero de hilos
		ObCritico ContadorCritico = new ObCritico (Integer.valueOf(args[1]).intValue());
				ExMutua [] Hilos = new ExMutua [NumHilos];
		for(int i=0; i<=NumHilos-1; i++)
		{Hilos[i] = new ExMutua (ContadorCritico);}
		for(int i=0; i<=NumHilos-1; i++)
		{Hilos[i].start();}
	}	
}	