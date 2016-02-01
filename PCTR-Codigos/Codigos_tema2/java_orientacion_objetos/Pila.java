/*Ejemplo de uso de la clase Stack
 *@author Antonio Tomeu
 *@version 1.0
*/
import java.util.*;
public class Pila
{
	public static void main (String [] args)
	{
		Stack pila = new Stack();
		if(pila.isEmpty()) System.out.println("pila esta vacia...");
		pila.push ("Hola");
		if(!pila.isEmpty()) System.out.println("pila no esta vacia...");
		Integer i = new Integer(2);
		pila.push(i);
		double [] k = new double [20];
		for(byte j = 0; j < k.length; j++) k[j]=2*j;
		pila.push(k);
		Thread H = new Thread();
		pila.push(H);
		System.out.println("El tope actual es "+pila.peek().toString());
		System.out.println(pila.pop().toString());
		System.out.println("El tope actual es "+pila.peek().toString());
	}	
}	

