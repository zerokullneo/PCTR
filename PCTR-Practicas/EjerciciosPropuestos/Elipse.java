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

/**Fichero Elipse.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

package practica2;

import java.lang.*;

public class Elipse
{
     /**
      * @param xa primera coordenada de x
      * @param xc segunda coordenada de x
      * @param yb primera coordenada de y
      * @param yd segunda coordenada de y
      */
     private double xa, xc, yb, yd;

     /**
      * Constructor de la clase Elipse
      * @param ea primera coordenada de x
      * @param eb primera coordenada de y
      * @param ec segunda coordenada de x
      * @param ed segunda coordenada de y
      */
     public Elipse(double ea, double eb, double ec, double ed)
     {
	xa = ea;
	yb = eb;
	xc = ec;
	yd = ed;
     }
	
     //observadores
     /**
      * Observador de la primera coordenada de x
      * @return Retorna el valor de x1
      */
     public double ElipseA(){return xa;}

     /**
      * Observador de la primera coordenada de y
      * @return Retorna el valor de y1
      */
     public double ElipseB(){return yb;}

     /**
      * Observador de la segunda coordenada de x
      * @return Retorna el valor de x2
      */
     public double ElipseC(){return xc;}

     /**
      * Observador de la segunda coordenada de y
      * @return Retorna el valor de y2
      */
     public double ElipseD(){return yd;}

     /**
      * Funcion que calcula si un punto esta dentro de la elipse
      * construida por el objeto.
      * @param punto variable a verificar si pertenece o no a la elipse.
      * @return retorna verdadero si el punto dado pertenece
      * a la elipse
      */
     public boolean Pertenece(double punto)
     {
	if(punto >= (yb - xa) && punto <= (xc -yd))
	     return true;
	else
	     return false;
     }
}