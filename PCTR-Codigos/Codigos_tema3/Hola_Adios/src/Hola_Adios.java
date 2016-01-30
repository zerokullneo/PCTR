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

/**Fichero Hola_Adios.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class Hola_Adios extends Thread
{
     public Hola_Adios (String Palabra)
     {Cadena = Palabra;}
     private void otrometodo()
     {System.out.println("otro metodo");}

     public void run ()
     {
	for (;;)
	{
	     System.out.println (Cadena);
	     this.otrometodo(); // run puede invocar otros metodos de la clase
	     Integer p = new Integer(3); //o crear los objetos que necesita
	}
     }

     public static void main (String [] args)
     {
	new Hola_Adios ("Hola").start ();
	new Hola_Adios ("Hola").start ();
	new Hola_Adios ("Hola").start ();
	new Hola_Adios ("Hola").start ();
	new Hola_Adios ("Adios").start ();
	new Hola_Adios ("Adios").start ();
	new Hola_Adios ("Adios").start ();
	new Hola_Adios ("Adios").start ();
     }
     private String Cadena;
}
