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

import java.util.*;

/**Fichero datosComunes.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class datosComunes
{
     public static int x = 0;
     public int y;
     public ArrayList<String> l;
     public static Integer xx = new Integer (0);
     
     public datosComunes(int y, ArrayList<String> l)
     {
	this.y = y;
	this.l = l;
     }

     public void set_x(int v){x=v;}

     public int get_x(){return x;}

     public void inc_xx(){xx++;}

     public String get_xx(){return xx.toString();}

     public void add_l(String i){l.add(i);}
}
