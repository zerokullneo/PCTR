/*
 * Copyright (C) 2021 Jose Manuel Barba Gonzalez <zk at wordpress.com>
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

package ac.arraycircular;

import java.util.*;

/**
 * Fichero arrayCircular.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 *
 *
 * Descripcion
 * 
 */
public class arrayCircular
{
	public static void main(String[] args) {
		
		Vector<Integer> circular = new Vector<>(5);
		circular.add(10);circular.add(20);circular.add(30);circular.add(40);
		circular.add(50);
		int ic = 0, ant, pos;

		System.out.println("{" + circular + "}");

		for(int i = 0; i < 50; i++, ++ic)
		{
			if(ic == 5)
				ic = 0;

			ant = Math.floorMod((ic - 1), 5);
			pos = (ic + 1) % 5;
		
			System.out.println("indice circular: " + ic + ", ant: " + ant + ", pos: " + pos);
		
			System.out.println("Anterior: " + circular.elementAt(ant) + " & Posterior: " + circular.elementAt(pos));
		}
	}
}
