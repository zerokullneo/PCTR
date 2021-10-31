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

package practica3;

/**Fichero Cuadrado.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class Cuadrado extends Poligono
{
     private double altura;

     /**
      * Constructor especificando los parametros de Cuadrado.
      * @param pxy Vector de coordenadas del Cuadrado, las 4 primeras
      * posiciones son las coordenadas "x" de cada punto, y las 4 ultimas
      * son las coordenadas "y" de cada punto.
      * @param a Altura del Cuadrado.
      */
     public Cuadrado(double []pxy, double a)
     {
	super(pxy,4);
	altura = a;
     }

     /**
      * Metodo para visualizar los datos del Cuadrado.
      * @return Devuelve el String con los atributos del Cuadrado.
      */
     public String toString()
     {
	return "Punto inicial: [" + p[lados-1].mostrarX() + "," + p[lados-1].mostrarY() + "]";
     }

     /**
      * Metodo para calcular el area del Cuadrado
      * @return Devuelve el calculo del area del Cuadrado.
      */
     public double AreaPoligono()
     {
	double area = (p[lados-1].mostrarX() - p[0].mostrarY()) * altura;
     	return area;
     }

     /**
      * Metodo para calcular el perimetro del Cuadrado.
      * @return Devuelve el calculo del perimetro del Cuadrado.
      */
     public double PerimetroPoligono()
     {
	double perimetro = (p[lados-1].mostrarX() - p[0].mostrarX()) * lados;
	return perimetro;
     }
}
