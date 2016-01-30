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

/**Fichero Prueba_Hilo1.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class Prueba_Hilo1
{
     public static void main (String [] args) throws InterruptedException
     {
	/*Ejemplo_Hilos1 Hilo1 = new Ejemplo_Hilos1 (12215);
	Ejemplo_Hilos1 Hilo2 = new Ejemplo_Hilos1 (34315);
		
	Hilo1.start ();  //Ahora se lanzan ambos hilos...
	Hilo2.start ();
	Hilo1.join ();
	Hilo2.join ();
	*/
	
	Ejemplo_Hilos1 []Hilo = new Ejemplo_Hilos1 [35];
	
	for(int i=0; i< Hilo.length; i++)
	     Hilo[i] = new Ejemplo_Hilos1(100);
	for(int i = 0; i < Hilo.length; i++)
	     Hilo[i].start();
	for(int i = 0; i < Hilo.length; i++)
	     Hilo[i].join();

	System.out.println ("Hilos terminados");
	}
}
