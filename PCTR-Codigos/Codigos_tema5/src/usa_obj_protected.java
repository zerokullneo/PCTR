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

/**Fichero usa_obj_protected.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
class Hilo implements Runnable
{
     obj_protected var;

     public Hilo (obj_protected recurso)
     {
	var = recurso;
     }
     public void run()
     {
	var.m2();
	var.m3();
     }
}

public class usa_obj_protected
{
     public static void main(String[] args)
     {
	obj_protected a = new obj_protected();
	Runnable Tarea = new Hilo (a);
	new Thread(Tarea).start();
     }
}
