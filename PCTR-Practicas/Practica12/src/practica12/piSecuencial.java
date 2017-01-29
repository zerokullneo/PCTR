/**
 * Copyright (C) 2017 Jose Manuel Barba Gonzalez <zk at wordpress.com>
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

package practica12;

/**Fichero piSecuencial.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class piSecuencial
{
     private static int puntos = 0;
     private static int intentos = 0;
     private static double cx, cy;

     public piSecuencial(int nintentos)
     {
	intentos = nintentos;
     }

     public static void ejecutar()
     {
          for(int i = 0; i < intentos; i++)
	{//area del circulo = pi * r^2
	     //area = (total/puntos) / r^2
	     cx = Math.random();//lanzamos coordenadas
	     cy = Math.random();//aleatorias (x,y)
	     //al realizar el seno de los puntos simulamos el area de un circulo de r=1
	     double sum = Math.sin(cx*cx) + Math.sin(cy*cy);
	     //si el calculo de sum esta dentro de un cuadrante del circulo
	     if(sum <= (Math.PI/4))
		puntos++;
	}
	//System.out.println("valor de la integal:" + (double)puntos/intentos);
     }

     public static void main(String[] args)
     {
	int nintentos = 10000;
	double pii;
	new piSecuencial(nintentos);

        double inicTiempo = System.nanoTime();
        ejecutar();
        double tiempoTotal = (System.nanoTime()-inicTiempo)/(double)1.0e9;
        System.out.println("en "+tiempoTotal+" segundos...");

	System.out.println( "valor de puntos:" + puntos);
	
	pii = (double)nintentos/(double)puntos;
	System.out.println( "valor de PI:" + pii);
     }
}