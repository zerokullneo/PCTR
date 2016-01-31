/**
 * @author David Moreno Del Valle
 */


import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.*;
import java.lang.*;

public class sPiMonteCarlo
 extends UnicastRemoteObject
 	implements iPiMonteCarlo
{

	public static int nPuntosTotal;
	public static double x;
	public static double y;
	public static double cont = 0;

	public sPiMonteCarlo() throws RemoteException{}

	public synchronized void reset()
		throws RemoteException
	{
		x = 0;
		y = 0;
		nPuntosTotal = 0;
		cont = 0;

		System.out.println("Aproximacion reseteada, valor actual: 0");
	}

	public synchronized void masPuntos(int nPuntos)
		throws RemoteException
	{
		nPuntosTotal += nPuntos;
		for(int i = 0; i<nPuntos; i++)
		{
			x = Math.random();
			y = Math.random();
			if(Math.pow(x,2)+Math.pow(y,2)<=1) cont++;
		}

		System.out.println("Se han generado "+nPuntos+" puntos nuevos, la nueva aproximacion es: "+(4*cont/nPuntosTotal));
	}

	public static void main(String[] args)
		throws Exception
	{
		iPiMonteCarlo ObRemoto = new sPiMonteCarlo(); //Se crea un objeto remoto
		Naming.bind("Servidor",ObRemoto); //Se registra el servicio
		System.out.println("APROXIMACION DEL NUMERO PI POR EL METODO DE MONTE CARLO");
	}
}
