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

/**Fichero Punto.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class Punto
{
     private double x,y;

     /**
      * Constructor vacio de Punto.
      */
     public Punto()
     {
	x = 0.0;
	y = 0.0;
     }

     /**
      * Constructor especificando los parametros de Punto.
      * @param xx Correspondiente a la coordenada x.
      * @param yy Correspondiente a la coordenada y.
      */
     public Punto(double xx, double yy)
     {
	x = xx;
	y = yy;
     }

     /**
      * Metodo observador del atributo x.
      * @return Devuelve el atributo x.
      */
     public double mostrarX(){ return x; }

     /**
      * Metodo observador del atributo y.
      * @return Devuelve el atributo y.
      */
     public double mostrarY(){ return y; }

     /**
      * Metodo para mover un punto dado por las coordenadas (dx,dy).
      * @param dx Nueva coordenada x.
      * @param dy Nueva coordenada y.
      */
     public void moverEn(double dx, double dy)
     {
	x += dx;
	y += dy;
     }

     /**
      * Metodo para visualizar los datos del Punto.
      * @return Devuelve el String con los atributos del Punto.
      */
     public String toString()
     {
	return "("+ x +","+ y +")";
     }
}
