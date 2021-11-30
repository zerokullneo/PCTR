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

package practica7;

import java.util.Scanner;

/**Fichero piMonteCarloUni.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class piMonteCarloUni implements Runnable
{
     private static int puntos=0;
     private static int intentos=0;
     private static double cx,cy;
     public static int seleccion;

     public piMonteCarloUni(int tampool,double cx,double cy)
     {
	this.cx=cx;
	this.cy=cy;
     }

     public static int menu()
     {
	int op;
	Scanner Sc = new Scanner(System.in);
	System.out.println( "   Menu:   ");
	System.out.println("1.- f(x) = sin(x)" );
	System.out.println("2.- f(x) = x");

	do
	{
	     System.out.print("Introduzca una opcion: ");
	     op = Sc.nextInt();
	}while(op < 1 || op > 2);
	System.out.println("intoduce nº intentos");
	intentos=Sc.nextInt();
	return op;
     }

     @Override
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
	seleccion = menu();
	int nNuc = Runtime.getRuntime().availableProcessors();
	float Cb = 0;
	int tampool = (int)(nNuc/(1-Cb));

	for(int i=0; i<tampool; i++)
	     new Thread(new piMonteCarloUni(tampool,(int)cx,(int)cy)).start();
     }
}