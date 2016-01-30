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

/**Fichero UsaParImpar.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class UsaParImpar
{
     public static void main(String[] args)
     {
     	ParImpar hilo1 = new ParImpar(0,50);
	ParImpar hilo2 = new ParImpar(1,50);
	ParImpar hilo3 = new ParImpar(0,100);
	ParImpar hilo4 = new ParImpar(1,100);
		
	hilo1.start();
	hilo2.start();
	hilo3.start();
	hilo4.start();
     }
}
