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

import java.util.Scanner;

/**Fichero UsacPlanetario.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class UsacPlanetario
{
     /**
     * @param args the command line arguments
     */
     public static void main(String[] args)
     {
	// TODO code application logic here
	String n;
	float m,d,ds,p,alb;
	//La clase Scanner lee del teclado los parametros introducidos por
	//el teclado luego se parsea con las diferentes funciones.
	Scanner CP = new Scanner(System.in);
	cPlanetario P1;
	cPlanetario P2;

	System.out.printf("Introducir datos: (nombre masa diametro distanciasol periodo albedo atmosfera(si/no))");
	n = CP.next();
	m = (float) CP.nextFloat();
	d = (float) CP.nextFloat();
	ds = (float) CP.nextFloat();
	p = (float) CP.nextFloat();
	alb = (float) CP.nextFloat();
	
	P1 = new cPlanetario(n, m, d, ds, p, alb, true);
	P2 = new cPlanetario("Marte",(float) 60000000.127,(float) 6258.14,(float) 182827330.234,(float) 1.6,(float) 5.2, false);
	System.out.println("Constante gravitacional entre " + P1.mostrar_nombre() + " y " + P2.mostrar_nombre() + ": " + P1.gravedad(P1,P2));
     }
}
