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

/**Fichero usaElipse.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

import java.lang.*;
import java.io.*;

public class usaElipse
{
     public static void main(String args[]) throws IOException
     {
	double xa, yb, xc, yd, p;
	Elipse mielipse;
	InputStreamReader entrada = new InputStreamReader(System.in);
	BufferedReader lectura = new BufferedReader(entrada);

	System.out.println("Introduzca los puntos reales de la elipse - xa yb xc yd: ");
	xa = Integer.parseInt(lectura.readLine());
	yb = Integer.parseInt(lectura.readLine());
	xc = Integer.parseInt(lectura.readLine());
	yd = Integer.parseInt(lectura.readLine());
	mielipse = new Elipse(xa, yb, xc, yd);

	System.out.println("Introduzca un punto para verificar su pertenencia a la elipse: ");
	p = Integer.parseInt(lectura.readLine());
		
	if(mielipse.Pertenece(p) == true)
	     System.out.println("El punto " + p + " Pertence a la elipse");
	else
	     System.out.println("El punto " + p + " NO pertence a la elipse");
	}
}