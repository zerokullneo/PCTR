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

/**Fichero UsaTodo.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class UsaTodo
{
     public static void main(String args[]) throws Exception
     {
          //Variables con las coordenadas de los puntos de cada poligono.
	double Ctr[] = {1.0,3.0,6.0,1.0,6.0,1.0};
	double Ccd[] = {1.0,1.0,6.0,6.0,1.0,6.0,6.0,1.0};
	double Cpn[] = {1.0,0.5,3.0,6.5,6.0,1.0,3.0,6.0,3.0,1.0};
	double Chg[] = {1.0,0.5,1.0,6.0,6.5,6.0,1.0,3.0,6.0,6.0,3.0,1.0};
	//Creacion de los poligonos, Tr -> triangulo, Cd -> Cuadrado
	//Pn -> Pentagono, Hg -> Hexagono
	Poligono Tr = new Triangulo(Ctr,3);
	Cuadrado Cd = new Cuadrado(Ccd,4);
	Pentagono Pn = new Pentagono(Cpn,5);
	Hexagono Hg = new Hexagono(Chg,6);

	System.out.println("Area triangulo:" + Tr.Perimetro());
	System.out.println("Area Cuadrado:" + Cd.AreaPoligono());
	System.out.println("Area Pentagono:" + Pn.AreaPoligono());
	System.out.println("Area Hexagono:" + Hg.AreaPoligono());
     }
}
