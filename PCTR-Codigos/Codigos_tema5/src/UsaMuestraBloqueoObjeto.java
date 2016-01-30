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

/**Fichero UsaMuestraBloqueoObjeto.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class UsaMuestraBloqueoObjeto implements Runnable
{
     private MuestraBloqueoObjeto p;
     private int caso;

     public UsaMuestraBloqueoObjeto(MuestraBloqueoObjeto o, int val)
     {
	p=o;
	caso=val;
     }

     public void run()
     {
	switch(caso)
	{
	     case 0: p.metodoA(); break;
	     case 1: p.metodoB(); break;
	}
     }

     public static void main(String[] args)
     {
	MuestraBloqueoObjeto monitor = new MuestraBloqueoObjeto();
	Thread h1 = new Thread(new UsaMuestraBloqueoObjeto(monitor,0));
	Thread h2 = new Thread(new UsaMuestraBloqueoObjeto(monitor,1));
	h1.start();
	h2.start();
     }
}