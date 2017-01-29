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

/**Fichero piParalelo.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class piParalelo implements Runnable
{
     private static int puntos = 0;
     private static int intentos = 0;
     private static double cx, cy;

     public piParalelo(int nintentos)
     {
	intentos = nintentos;
     }

     public void run()
     {
	synchronized(this)
	{//area del circulo = pi * r^2
	     //area = (total/puntos) / r^2
	     for(int i = 0; i < intentos; i++)
	     {//distancia euclidea
		cx = Math.random();
		cy = Math.random();
		double sum = Math.sin(cx*cx) + Math.sin(cy*cy);
		if(sum <= (Math.PI/4))
		     puntos++;
	     }
	     //System.out.println("valor de la integal:" + (double)puntos/intentos);
	}
     }

     public static void main(String[] args) throws InterruptedException
     {
	int nNuc = Runtime.getRuntime().availableProcessors();
	float Cb = (float) 0.1;
	double pii;
	int tampool = (int)(nNuc/(1-Cb));
	int nintentos = 1000000;
	Thread hPiParalelo[] = new Thread[tampool];

        double inicTiempo = System.nanoTime();
	for(int i = 0; i < tampool; i++)
	{
	     hPiParalelo[i] = new Thread(new piParalelo(nintentos));
	     hPiParalelo[i].start();
	}

	for(int i = 0; i < tampool; i++)
	{
	     hPiParalelo[i].join();
	}

        double tiempoTotal = (System.nanoTime()-inicTiempo)/(double)1.0e9;
        System.out.println("en "+tiempoTotal+" segundos...");

	System.out.println( "valor de puntos:" + puntos);

	pii = ((double)nintentos*tampool)/(double)puntos;
	System.out.println( "valor de PI:" + pii);
     }
}
