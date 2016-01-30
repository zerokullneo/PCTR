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

package hoja9;

import java.util.ArrayList;

/**Fichero datosComunesEM1.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class datosComunesEM1
{
     private static int x = 0;
     private int y;
     private ArrayList<String> l;
     private static Integer xx = new Integer (0);
     
     public datosComunesEM1(int y, ArrayList<String> l)
     {
	this.y = y;
	this.l = l;
     }

     public void set_x(int v)
     {
	synchronized(this)
	{
	     x=v;
	}
     }

     public int get_x()
     {
	synchronized(this)
	{
	     return x;
	}
     }

     public void inc_xx()
     {
	synchronized(this)
	{
	     xx++;
	}
     }

     public String get_xx()
     {
	synchronized(this)
	{
	     return xx.toString();
	}
     }

     public void add_l(String i)//??
     {
	synchronized(this)
	{
	     l.add(i);
	}
     }
}
