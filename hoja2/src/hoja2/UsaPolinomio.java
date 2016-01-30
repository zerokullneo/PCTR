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

package hoja2;

/**Fichero UsaPolinomio.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class UsaPolinomio
{
     public static void main(String[] args)
     {
	double[] coeficientes= new double[args.length];
	for(int i= 0; i < args.length; i++)
	coeficientes[i]= Double.parseDouble(args[i]);
	Polinomio p = new Polinomio(coeficientes);

	double x= 3;
	System.out.println(p.evalua_1(x));
	System.out.println(p.evalua_2(x));
	System.out.println(p.evalua_3(x));
	System.out.println(p.evalua_4(x));

	p.test(1);
	p.test(2);
	p.test(5);
	p.test(10);
	p.test(20);
	p.test(50);
	p.test(100);
	p.test(200);
	p.test(500);
	p.test(1000);
     }
}