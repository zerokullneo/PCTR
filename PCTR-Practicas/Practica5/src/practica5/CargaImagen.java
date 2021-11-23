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

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**Fichero CargaImagen.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * Clase que permite cargar en memoria una imagen en forma de matriz.
 */
public class CargaImagen
{
	/**
	* Carga una imagen en una matriz. La imagen es convertida automáticamente
	* a una escala de niveles de grises [0-255].
	* @param fichero La imagen
	* @return La matriz que representa la imagen en escala de grises.
	* @throws IOException 
	*/
	public static int[][] cargar(String fichero) throws IOException{
        
		BufferedImage imagen = ImageIO.read(new File(fichero));

		int[][] matriz = new int[imagen.getHeight()][imagen.getWidth()];
        
		for(int i = 0 ; i < imagen.getHeight() ; ++i)
		{
			for(int j = 0 ; j < imagen.getWidth() ; ++j)
			{
				Color c = new Color(imagen.getRGB(j, i));
				matriz[i][j] = (int) ((c.getRed() + c.getGreen() + c.getBlue()) / 3);
			}
		}
        
		return matriz;
	}
    
	/**
	 * Guarda la matriz en un fichero en formato PNG.
	 * @param matriz Cada celda de la matriz representa un pixel de la imagen, codificado en 256 niveles de grises [0-255].
	 * @param fichero Fichero en formato PNG en el que se guardará la matriz.
	 * @throws IOException 
	 */
	public static void guardar(int[][] matriz, String fichero) throws IOException
	{
		BufferedImage imagen = new BufferedImage(matriz[0].length, matriz.length, BufferedImage.TYPE_4BYTE_ABGR);

		for(int i = 0 ; i < matriz.length ; ++i)
		{
			for(int j = 0 ; j < matriz[0].length ; ++j)
			{
				Color c = new Color(matriz[j][i], matriz[j][i], matriz[j][i]);
				imagen.setRGB(i, j, c.getRGB());
			}
		}
        
		ImageIO.write(imagen, "png", new File(fichero));
	}

	/**
	 * Guarda la matriz en un fichero en formato PNG a escala de grises.
	 * @param ficheroOriginal Fichero en formato PNG de entrada que generara la matriz.
	 * @param ficheroResultado Fichero en formato PNG en el que se guardará la matriz.
	 * @throws IOException 
	 */
	public static void ConvertirAGris(String ficheroOriginal, String ficheroResultado) throws IOException
	{
		BufferedImage imagen = ImageIO.read(new File(ficheroOriginal));
        
		for(int i = 0 ; i < imagen.getHeight() ; ++i)
		{
			for(int j = 0 ; j < imagen.getWidth() ; ++j)
			{
				Color c = new Color(imagen.getRGB(i, j));
				int gris = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
				imagen.setRGB(i, j, (new Color(gris, gris, gris)).getRGB());
			}
		}
        
		ImageIO.write(imagen, "png", new File(ficheroResultado));
	}
    
	public static void main(String[] args) throws IOException
	{
		System.out.println("Convirtiendo a escala de grises");        
		ConvertirAGris("uca.png", "uca_gris.png");
        
		System.out.println("Cargando fichero en matriz");
		int[][] matriz = cargar("uca_gris.png");

		System.out.println("Guardando matriz en fichero");
		guardar(matriz, "uca_gris_procesada.png");
	}
}