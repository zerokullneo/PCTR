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

/**Fichero ParImpar.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class ParImpar extends Thread
{
     private int sw;
     private int n;
	
     public ParImpar(int tip, int num)
     {
	sw = tip;
	n = num;
     }
	
     public int leeSW(){return sw;}
     public int leeN(){return n;}

     public void run()
     {
	for(int i = 0; i < n; i++)
	     switch(sw)
	     {
		case 0:
		     if(i % 2 == 0)
		     System.out.println(getName() + " - Par... " + i);
		     break;
		case 1:
		     if(i % 2 != 0)
		     System.out.println(getName() + " - Impar... " + i);
		     break;
	     }
     }
}
