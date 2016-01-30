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

/**Fichero Prueba_Prod_Con.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

class Productor implements Runnable
{
     private Buffer bb = null;

     public Productor(Buffer bb)
     {
	this.bb = bb;
     }

     public void run()
     {
	double item = 0.0;
	
	while(true)
	{
	     bb.insertar (++item);
	     System.out.println("Produciendo " + item);
	}
     }
}//Productor

class Consumidor implements Runnable
{
     private Buffer bb = null;

     public Consumidor(Buffer bb)
     {
	this.bb = bb;
     }

     public void run()
     {
	double item;

	while (true)
	{
	     item = bb.extraer ();
	     System.out.println("Consumiendo " + item);
	}
     }
}//Consumidor

/**Descripcion
 * 
 */
public class Prueba_Prod_Con
{
     public static void main (String [] args)
     {
	int ranuras = 10;
	Buffer monitor = new Buffer (ranuras);

	new Thread(new Productor(monitor)).start();
	new Thread(new Consumidor(monitor)).start();
     }
}
