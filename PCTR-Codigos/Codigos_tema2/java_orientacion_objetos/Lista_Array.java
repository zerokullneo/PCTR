/*Ejemplo de uso de la clase ArrayList
 *@author Antonio Tomeu
 *@version 1.0
**/

import java.util.*;
import java.lang.*;
public class Lista_Array
{
	public static String toString(ArrayList L) //sobrecarga del metodo toString
	{
		Object [] P;
		String aux = new String();
		aux = "(";
		P = L.toArray(); //se convierte la lista en un array de objetos
		for(int i = 0; i < P.length; i++)
		aux = aux+" "+P[i].toString();
		return aux+")";
	}

public static void main (String [] args)	
	{
	ArrayList Lista1 = new ArrayList(); 		
  	ArrayList Lista2 = new ArrayList(50);
	System.out.println("Estado actual de la Lista1");
	System.out.println(toString(Lista1));
	Integer i = new Integer(2);		
	Float   j = new Float (-256.321f);	
	Thread Hilo = new Thread(); //insertamos un hilo...
	Lista1.add(i);
	Lista1.add("Hola");
	Lista1.add(j);
	Lista1.add(Hilo); 		
	System.out.println("Estado actual de la Lista1");
	System.out.println(toString(Lista1));
	if(Lista1.isEmpty())System.out.println("Lista1 vacia...");
	if(Lista2.isEmpty())System.out.println("Lista2 vacia...");  
	Lista1.set(2,"Hola otra vez"); //reemplaza la posicion 2 por nuevo contenido
	System.out.println("Estado actual de la Lista1");
	System.out.println(toString(Lista1));			
	}
} 	
