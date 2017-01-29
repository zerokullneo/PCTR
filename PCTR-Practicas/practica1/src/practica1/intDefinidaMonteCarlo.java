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
	public static void main(String[] args)
	{
		int d,i;
		Scanner puntos;
		double suma1 = 0, suma2 = 0;

		System.out.println("Introduzca el numero de puntos(minimo10): ");
		puntos = new Scanner(System.in);
		d = puntos.nextInt();
		if(d < 10) d = 10;

		for(i = 0; i < d; i++)
			suma1 = suma1 + Math.sin(Math.random());//f(x)=sin(x)
		
		System.out.println("Resultado de la aproximacion MonteCarlo Funcion f(x) = sin(x): " + suma1/d);
		
		for(i = 0; i < d; i++)
			suma2 = suma2 + Math.random();//f(x) = x

		System.out.println("Resultado de la aproximacion MonteCarlo Funcion f(x) = x: " + suma2/d);
	}
}
