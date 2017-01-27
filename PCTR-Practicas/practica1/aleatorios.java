/* Fichero aleatorios.java 
  *@author Jose Manuel Barba Gonzalez
  *@version 1.0
  *Programacion Concurrente y de Tiempo Real
  *Area de CC. de la Computacion e I.A.
*/

import java.io.*;
import java.util.*;
import java.lang.*;

public class aleatorios
{
	public static void main(String[] args)
	throws Exception
	{
		int n;
		double a;
		Scanner numero;

		System.out.println("Introduzca el número para generar la secuencia aleatoria(minimo 10): ");
		numero = new Scanner(System.in);
		n = numero.nextInt();
		if(n < 10) n = 10;

		for(int i = 0; i < n; i++)
		{
			a = Math.random();
			System.out.println("n "+(i+1)+": "+a);
		}
	}
}
