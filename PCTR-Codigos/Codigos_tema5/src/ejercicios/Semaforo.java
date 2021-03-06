
public class Semaforo
{
	private int numSlots = 0;
	private double[] buffer = null;
	private int putIn = 0, takeOut = 0, cont = 0;
	boolean estado;

	public Semaforo(int numSlots)
	{
		this.numSlots = numSlots;
		buffer = new double[numSlots];
		estado = false;
	}

	public synchronized void esperar(double valor)
	{
		while (cont == numSlots) //estado == false:condición de buffer lleno
		try
		{
			wait();
		}
		catch (InterruptedException e)
		{
			System.err.println("wait interrumpido");
		}
		buffer[putIn] = valor;
		putIn = (putIn + 1) % numSlots;
		cont++;
		notifyAll(); //inserción en e.m.
	}

	public synchronized double continuar()
	{
		double valor;
		while (cont == 0) //estado == true; condición de buffer vacío
		try
		{
			wait();
		}
		catch (InterruptedException e)
		{
			System.err.println("wait interrumpido");
		}
		valor = buffer[takeOut];
		takeOut = (takeOut + 1) % numSlots;
		cont--;
		notifyAll();
		return valor; //extracción en e.m.
	}
}
