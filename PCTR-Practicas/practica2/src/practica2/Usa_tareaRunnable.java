/**
 * Copyright (C) 2021 Jose Manuel Barba Gonzalez <zk at wordpress.com>
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

package practica2;

/**Fichero Cuenta_Banca.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * Clase que simula las acciones recogidas por parámetro.
 */
public class Usa_tareaRunnable
{
     public static void main(String[] args) throws Exception
     {
	  tareaRunnable tareaUno = new tareaRunnable("inc");
	  tareaRunnable tareaDos = new tareaRunnable("dec");
	  Thread h1 = new Thread(tareaUno);
	  Thread h2 = new Thread(tareaDos);
	  
	  h1.start(); h2.start();
	  h1.join(); h2.join();
	  System.out.println("Valor de n es " + tareaUno.getDato() + " con Runnable");
     }
}
