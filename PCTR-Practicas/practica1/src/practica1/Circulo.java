/* Fichero Circulo.java 
  *@author Jose Manuel Barba Gonzalez
  *@version 1.0
  *Programacion Concurrente y de Tiempo Real
  *Area de CC. de la Computacion e I.A.
*/
package practica1;
import java.util.Scanner;
import java.lang.*;

public class Circulo
{
	//v=(pi*r²*h)/3
	public static void main(String[] args)
	{
		double pi = 3.141516;
		Scanner diametro, altura;
		double volumen;
		double d, h, r;

		System.out.println("Introduzca la altura: ");
		altura = new Scanner(System.in);
		h = altura.nextDouble();
		System.out.println("Introduzca el diametro: ");
		diametro = new Scanner(System.in);
		d = diametro.nextDouble();

		r = d/2;
		volumen = (pi*(r*r)*h)/3;
		System.out.println("El volumen del cono con radio "+r+" y altura "+h+" es "+volumen);
	}  
}
