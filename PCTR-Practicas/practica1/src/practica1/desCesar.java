/* Fichero desCesar.java 
  *@author Jose Manuel Barba Gonzalez
  *@version 1.0
  *Programacion Concurrente y de Tiempo Real
  *Area de CC. de la Computacion e I.A.
*/
package practica1;
import java.io.*;
import java.util.*;
import java.lang.*;

public class desCesar
{
	private int n;
	private String clave;
	
	public desCesar(int num, String cad)
	{
		n = num;
		clave = new String(cad);
	}
	public int Numero(){return n;}
	public String Clave(){return clave;}

	public String Descifra()
	{
		int i, value;
		char []tmp;
		char []tmpcif;
		String clave_cif;

		System.out.println("Funcion E(x) = x - n mod 27");
		tmp = new char[clave.length()];
		tmp = clave.toCharArray();
		tmpcif = new char[clave.length()];
		for(i = 0; i < clave.length(); i++)
		{
			value = (tmp[i] - n % 27);
			tmpcif[i] = (char) value;
		}	
		clave_cif = new String(tmpcif);
		//System.out.println(clave_cif);
		return clave_cif;
	}
}