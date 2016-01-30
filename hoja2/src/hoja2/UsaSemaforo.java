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

package hoja2;

/**Fichero UsaSemaforo.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class UsaSemaforo
{
     public static void main(String []args)throws InterruptedException
     {
	Semaforo S1;
	S1 = new Semaforo(Semaforo.Color.VERDE, false);

	System.out.println(S1.mostrar_color());
	Thread.sleep(4000);
	S1.modificar_color(Semaforo.Color.AMBAR);
	System.out.println(S1.mostrar_color());
	Thread.sleep(3000);
	S1.modificar_color(Semaforo.Color.ROJO);
	System.out.println(S1.mostrar_color());
	Thread.sleep(9000);
	S1.modificar_color(Semaforo.Color.VERDE);
	System.out.println(S1.mostrar_color());
	}
}
