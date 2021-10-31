/**
 * Copyright (C) 2015 Jose Manuel Barba Gonzalez <zk at wordpress.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**Fichero usaComplejos.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

package practica1;

import java.lang.*;
import java.io.*;

public class usaComplejos
{
     public static void main(String args[]) throws IOException
     {
	int a, b, c, d, op;
	Complejos suma, resta, mult, div, mod;
	InputStreamReader entrada = new InputStreamReader(System.in);
	BufferedReader lectura = new BufferedReader(entrada);

	do
	{
	     System.out.println("-- Menu --");
	     System.out.println("1.- Suma.");
	     System.out.println("2.- Resta.");
	     System.out.println("3.- Producto.");
	     System.out.println("4.- Cociente");
	     System.out.println("5.- Modulo");
	     System.out.println("0.- Salir.");
	     System.out.println("Opcion: ");
	     op = Integer.parseInt(lectura.readLine());
			
	     switch(op)
	     {
		case 0:
		     break;
		case 1://suma [a + bi] + [c + di] = [a + c] + [b + d]i
		     System.out.println("Introduzca los numeros reales (a c): ");
		     a = Integer.parseInt(lectura.readLine());
		     c = Integer.parseInt(lectura.readLine());
		     System.out.println("Introduzca los numeros complejos (bi di): ");
		     b = Integer.parseInt(lectura.readLine());
		     d = Integer.parseInt(lectura.readLine());
		     suma = new Complejos(a, b, c, d);
		     System.out.println(suma.Suma());
		     break;
		case 2://resta [a + bi] - [c + di] = [a - c] + [b - d]i
		     System.out.println("Introduzca los numeros reales (a c): ");
		     a = Integer.parseInt(lectura.readLine());
		     c = Integer.parseInt(lectura.readLine());
		     System.out.println("Introduzca los numeros complejos (bi di): ");
		     b = Integer.parseInt(lectura.readLine());
		     d = Integer.parseInt(lectura.readLine());
		     resta = new Complejos(a, b, c, d);
		     System.out.println(resta.Resta());
		     break;
		case 3://producto [a + bi] * [c + di] = [ac - bd] + [ad + bc]i
		     System.out.println("Introduzca los numeros reales (a c): ");
		     a = Integer.parseInt(lectura.readLine());
		     c = Integer.parseInt(lectura.readLine());
		     System.out.println("Introduzca los numeros complejos (bi di): ");
		     b = Integer.parseInt(lectura.readLine());
		     d = Integer.parseInt(lectura.readLine());
		     mult = new Complejos(a, b, c, d);
		     System.out.println(mult.Producto());
		     break;
		case 4://cociente [ac + bd]/[c^2 + d^2] + [bc - ad]/[c^2 + d^2]i
		     System.out.println("Introduzca los numeros reales (a c): ");
		     a = Integer.parseInt(lectura.readLine());
		     c = Integer.parseInt(lectura.readLine());
		     System.out.println("Introduzca los numeros complejos (bi di): ");
		     b = Integer.parseInt(lectura.readLine());
		     d = Integer.parseInt(lectura.readLine());
		     div = new Complejos(a, b, c, d);
		     System.out.println(div.Cociente());
		     break;
		case 5://modulo r=|z|=sqrt(a^2 + b^2)
		     System.out.println("Introduzca los numeros reales (a b): ");
		     a = Integer.parseInt(lectura.readLine());
		     b = Integer.parseInt(lectura.readLine());
		     System.out.println("Introduzca los numeros complejos (c d): ");
		     c = Integer.parseInt(lectura.readLine());
		     d = Integer.parseInt(lectura.readLine());
		     mod = new Complejos(a, b, c, d);
		     System.out.println(mod.Modulo());
		     break;
	     }
	}while(op != 0);
     }
}