/* Fichero intDefinidaMonteCarlo.java 
  *@author Jose Manuel Barba Gonzalez
  *@version 1.0
  *Programacion Concurrente y de Tiempo Real
  *Area de CC. de la Computacion e I.A.
*/
package practica1;
import java.io.*;
import java.util.*;
import java.lang.*;

public class intDefinidaMonteCarlo
{
     public static double fx(double x)
     {
	  return x;
     }
	public static void main(String[] args)
	{
		int d,i;
		Scanner puntos;
		double contadorFSinX = 0, contadorFX = 0, coordx, coordy;

		System.out.println("Introduzca el numero de puntos(minimo10): ");
		puntos = new Scanner(System.in);
		d = puntos.nextInt();
		if(d < 10) d = 10;

		for(i = 0; i < d; i++)
		{
		    coordx = Math.sin(Math.random());
		    coordy = Math.sin(Math.random());
		    if(coordy <= coordx)
			 contadorFSinX++;//f(x)=sin(x)
		}
		
		System.out.println("Resultado de la aproximacion MonteCarlo Funcion f(x) = sin(x): " + contadorFSinX/d);
		
		for(i = 0; i < d; i++)
		{
		    coordx = Math.random();
		    coordy = Math.random();
		    if(coordy <= fx(coordx))
			 contadorFX++ ;//f(x) = x
		}

		System.out.println("Resultado de la aproximacion MonteCarlo Funcion f(x) = x: " + contadorFX/d);
	}
}
