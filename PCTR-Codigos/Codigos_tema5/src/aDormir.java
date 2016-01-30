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

/**Fichero aDormir.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class aDormir extends Thread
{
     public aDormir() {}

     public void run()
     {
	System.out.println("El hilo "+this.getName()+" dijo: mi vida activa fue breve...");
	synchronized(this)
	{
	     try{wait();}catch (InterruptedException e){} //cada hilo dormido sobre su propio cerrojo
	     System.out.println(this.getName()+" dijo: pero he revivido...");
	}
     }


     public void despertar(){synchronized (this){notify();}}

     public static void main(String[] args)
     {
	aDormir [] h = new aDormir[10];

	for(int i=0; i<10;i++)
	{
	     h[i]=new aDormir();
	     h[i].start();
	}
	h[5].despertar();
     }
}
