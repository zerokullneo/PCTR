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

/**Fichero Complejos.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

import java.lang.*;

public class Complejos
{
	private int a,c;
	private int bi,di;

	/**
	 * Constructor de un número complejo
	 * @param a Variable de la Parte real del primer operando
	 * @param b Variable de la Parte imaginaria del primer operando
	 * @param c Variable de la Parte real del segundo operando
	 * @param d Variable de la Parte imaginaria del segundo operando
	 */
	public Complejos(int a, int b, int c, int d)
	{
		a = a;
		bi = b;
		c = c;
		di = d;
	}
	
	//observadores
	/**
	 * Método observador de la Parte real del primer operando
	 * @return Devuelve la Parte real del primer operando
	 */
	public int ComplejoA(){return a;}

	/**
	 * Método observador de la Parte imaginaria del primer operando
	 * @return Devuelve la Parte imaginaria del primer operando
	 */
	public int ComplejoBi(){return bi;}

	/**
	 * Método observador de la Parte real del segundo operando
	 * @return Devuelve la Parte real del segundo operando
	 */
	public int ComplejoC(){return c;}

	/**
	 * Método observador de la Parte imaginaria del segundo operando
	 * @return Devuelve la Parte imaginaria del segundo operando
	 */
	public int ComplejoDi(){return di;}
	
	/**
	 * Método Suma de dos números complejos.
	 * @return suma [a + bi] + [c + di] = [a + c] + [b + d]i
	 */
	public String Suma()
	{
		String out = "C = " + (a+c) + " + " + (bi+di) + "i";
		return out;
	}

	/**
	 * Método Resta de dos números complejos.
	 * @return resta [a + bi] - [c + di] = [a - c] + [b - d]i
	 */
	public String Resta()
	{
		String out = "C = " + (a-c) + " + " + (bi-di) + "i";
		return out;		
	}

	/**
	 * Método Producto de dos números complejos.
	 * @return producto [a + bi] * [c + di] = [ac - bd] + [ad + bc]i
	 */
	public String Producto()
	{
		String out = "C = " + ((a*c)-(bi*di)) + " + " + ((a*di)+(bi*c)) + "i";
		return out;
	}

	/**
	 * Método Cociente de dos números complejos.
	 * @return cociente [ac + bd]/[c^2 + d^2] + [bc - ad]/[c^2 + d^2]i
	 */
	public String Cociente()
	{
		String out = "C = " + (((a*c) + (bi*di))/((c*c)+(di*di))) + " + " + (((bi*c)-(a*di))/((c*c)+(di*di))) + "i";
		return out;	
	}

	/**
	 * Método Módulo de dos números complejos.
	 * @return modulo r1=|z|=sqrt(a^2 + b^2) y r2=|z|=sqrt(c^2 + d^2)
	 */
	public String Modulo()
	{
		String out = "Complejo A = " + Math.sqrt((a*a)+(bi*bi)) + "i\nComplejo B = " + Math.sqrt((c*c)+(di*di)) + "i";
		return out;
	}
}