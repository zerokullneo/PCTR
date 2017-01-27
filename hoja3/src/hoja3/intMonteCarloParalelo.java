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

package hoja3;

/**Fichero intMonteCarloParalelo.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class intMonteCarloParalelo extends Thread
{
     private int puntos=0;
     private static int intentos=0;
     private static double cx,cy;
     public static int seleccion;

     public intMonteCarloParalelo(double cx,double cy, int sel)
     {
	this.cx = cx;
	this.cy = cy;
	seleccion = sel;
     }
     
     public void run()
     {
	switch(seleccion)
	{
	     case 1:
		synchronized(this)
		{
		     for(int i=0; i<intentos; i++)
		     {
			cx = Math.random();
			cy = Math.random();
			double sum = Math.sin(cx*cx) + Math.sin(cy*cy);
			if(cy <= sum) puntos++;
			//System.out.println( "valor de cont:" + puntos);
		     }
		     System.out.println("valor de la integal:" + (double)puntos/intentos);
		}
		break;
	     case 2:
		synchronized(this)
		{
		     for(int i=0; i<intentos; i++)
		     {
			cx = Math.random();
			cy = Math.random();
			double sum = Math.sin(cx*cx) + Math.sin(cy*cy);
			if(cy <= sum) puntos++;
			//System.out.println( "valor de puntos:" + puntos);
		     }
		     System.out.println("valor de la integal:" + (double)puntos/intentos);
		}
		break;
	}
     }

     public static void main(String[] args)
     {
     	intMonteCarloParalelo hilo1 = new intMonteCarloParalelo(0,50,1);
	intMonteCarloParalelo hilo2 = new intMonteCarloParalelo(1,50,1);
	intMonteCarloParalelo hilo3 = new intMonteCarloParalelo(0,100,2);
	intMonteCarloParalelo hilo4 = new intMonteCarloParalelo(1,100,2);
		
	hilo1.start();
	hilo2.start();
	hilo3.start();
	hilo4.start();
     }
}
