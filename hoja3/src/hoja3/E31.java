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

/**Fichero E31.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class E31 extends Thread
{
     private static Integer i = new Integer(1);
     private static Integer j = new Integer(1);
     private static int k = 0;
     private E31 mi_thread;

     public E31()
     {
	k++;
     }

     public void run()
     {
	if(k<500)
	{
	     mi_thread=new E31();
	     i--;
	     mi_thread.start();
	     try{mi_thread.join();}catch (InterruptedException e){}
	}
     }

     public static void main(String[] args) throws Exception
     {
	E31 otro_thread = new E31();
	otro_thread.start();
          otro_thread.join();
	System.out.println(i.toString());
     }
}
