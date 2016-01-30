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

package hoja7;

/**Fichero retardoMutex.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */
/* MEDIDA DEL TIEMPO QUE TOMAN LOS BLOQUEOS SINCRONIZADOS
*@author A.T.
*@date 11/11/2014
*/
import java.util.Scanner;
/**Descripcion
 * 
 */
public class retardoMutex extends Thread
{
     public static int vShared = 0;
     public int tipoHilo;
     public static int nIter;

     public retardoMutex(int tipoHilo)
     {
	this.tipoHilo = tipoHilo;
     }

     public void run()
     {
	switch(tipoHilo)
	{
	     case 0:
	     {
		int cont = 0;
		long inicTime = System.nanoTime();
		for(int i=0; i<nIter; i++)
		     cont++;
		System.out.println("Tiempo sin Bloqueos: " + (System.nanoTime()-inicTime) + " nanosegundos");
	     };
	     break;
	     case 1:
	     {
		int otrocont = 0;
		long inicTime = System.nanoTime();
		for(int i=0; i<nIter; i++)
		     synchronized(this){otrocont++;}
		System.out.println("Tiempo con Bloqueos: " + (System.nanoTime()-inicTime) + " nanosegundos");
	     };
	     break;
	}//switch
     }

     public static void main(String[]args)
     {
	//Scanner s = new Scanner(System.in);
	nIter = Integer.parseInt(args[0]);//s.nextInt();
	new retardoMutex(0).start();
	new retardoMutex(1).start();
     }
}
