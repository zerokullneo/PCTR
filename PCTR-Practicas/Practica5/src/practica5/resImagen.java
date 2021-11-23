/**
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

package practica5;

import java.lang.*;
import java.io.*;
import java.util.*;

/**Fichero resImagen.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * funcion Subramanian.
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * Clase que realiza el resaltado de una imagen de forma secuencial.
 */
public class resImagen extends CargaImagen
{
	/**
	 * Variable que determina da dimension de la matriz.
	 */
	private static int n, m;
	/**
	 * Variable matriz que determina la imagen cargada.
	 */
	private static int matriz[][];

	/**
	 * Constructor especificando los parametros.
	 * @throws IOException 
	 */
	public resImagen()throws IOException
	{
		matriz = cargar("uca.png");
		n = matriz.length;
		m = matriz.length;
	}

	/**
	 * Metodo observador del atributo Matriz.
	 * @return Devuelve la matriz vectorizada.
	 */
	public static int[][] mostrar_matriz(){ return matriz; }

	/**
	 * Metodo que vectoriza la matriz que contiene los codigos de colores.
	 * @param img Referente al objeto al que se le modificara la matriz.
	 * @return Devuelve el objeto "img" con la matriz de colores vectorizada.
	 */
	public static resImagen vectorizar(resImagen img)
	{
		//xi,j = (4xi,j − xi+1,j − xi,j+1 − xi−1,j − xi,j−1 )/8
		int c;
		for(int i = 1; i < n-1; i++)
			for(int j = 1; j < m-1; j++)
			{
				c = ((4 * matriz[i][j]) - (matriz[i+1][j]) - ( matriz[i][j+1]) - (matriz[i-1][j]) - (matriz[i][j-1]))/8;
				if(c > 255)
				c = 255;
				if(c < 0)
					c = 0;
				matriz[i][j] = c;
			}
		return img;
	}

	public static void main(String[] args) throws IOException
	{
		//ConvertirAGris("uca.png", "uca_g.png");
		resImagen imagen = new resImagen();
		long finTiempo, inicTiempo = System.nanoTime();
		imagen = vectorizar(imagen);

		guardar(imagen.mostrar_matriz(),"ucares.png");

		finTiempo = System.nanoTime();
		System.out.println("Tiempo... " + (finTiempo-inicTiempo)/1.0e9);
	}
}