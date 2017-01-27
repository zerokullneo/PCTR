/* Fichero NewtonRaphson.java 
  *@author Jose Manuel Barba Gonzalez
  *@version 1.0
  *Programacion Concurrente y de Tiempo Real
  *Area de CC. de la Computacion e I.A.
*/

import java.io.*;
import java.util.*;
import java.lang.*;

public class NewtonRaphson
{

	public static void main(String[] args)
	throws IOException
	{
		double p,h;
		int d,i,j;
		Scanner aproximacion, iteraciones;
		double []vector;
		double []vect;

		System.out.println("Introduzca la aproximacion inicial: ");
		aproximacion = new Scanner(System.in);
		h = aproximacion.nextDouble();
		System.out.println("Introduzca las iteraciones para la aproximacion(minimo 10): ");
		iteraciones = new Scanner(System.in);
		d = iteraciones.nextInt();
		if(d < 10) d = 10;

		System.out.println("Funcion f(x) = cos(x) - x^3");
		vector = new double[d];
		vector[0] = (h/1) - ((Math.cos(h)-1)/(-Math.sin(h)-1));
		for(i = 1; i < d && vector[i-1] > 0.0; i++)
		{	//f(x)=cos(x) - x³
			vector[i] = (h/i) - ((Math.cos(h)-(i*i*i))/(-Math.sin(h)-(i*i)));
			System.out.println("Iteracion "+i+", aproximacion: "+vector[i]);
		}

		System.out.println("Funcion f(x) = x^2 - 5");
		vect = new double[d];
		vect[0] = (h/1) - (((1*1)-5)/1);
		for(j = 1; j < d && vect[j-1] > 0.0; j++)
		{	//f(x)=x² - 5
			vect[j] = (h/j) - (((j*j)-5)/j);
			System.out.println("Iteracion "+j+", aproximacion: "+vect[j]);
		}		
	}  
}
