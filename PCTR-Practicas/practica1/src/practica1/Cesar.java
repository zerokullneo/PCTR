/* Fichero Cesar.java 
  *@author Jose Manuel Barba Gonzalez
  *@version 1.0
  *Programacion Concurrente y de Tiempo Real
  *Area de CC. de la Computacion e I.A.
*/
package practica1;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Cesar
{
	public static void main(String[] args)
	throws Exception
	{
		int n, i, value;
		char []tmp;
		char []tmpcif;
		String clave, clave_cif;
		Scanner numero;

		System.out.println("Introduzca el numero para sumar a la clave: ");
		numero = new Scanner(System.in);
		n = numero.nextInt();

		System.out.println("Introduzca su contrasena: ");
		BufferedReader dato = new BufferedReader(new InputStreamReader(System.in));
		clave = dato.readLine();

		System.out.println("Funcion E(x) = x + n mod 27");
		tmp = new char[clave.length()];
		tmp = clave.toCharArray();
		tmpcif = new char[clave.length()];
		for(i = 0; i < clave.length(); i++)
		{
			value = (tmp[i] + n % 27);
			tmpcif[i] = (char) value;
		}	
		clave_cif = new String(tmpcif);
		System.out.println(clave_cif);
		
		desCesar descifra = new desCesar(n,clave_cif);
		clave = descifra.Descifra();
		System.out.println(clave);
	}
}