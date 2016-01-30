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

/**Fichero Monitor.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class Monitor
{
     private static int Dato; //recurso protegido

     public Monitor(int VInic){Dato=VInic;}

     public synchronized void INC()
     {
	while(!(Dato<=0))
	try{System.out.println("Hilo Sumador bloqueado");
	     wait();
	} catch (InterruptedException e){}
	Dato++;
	notifyAll();
     }

     public synchronized void DEC()
     {
	while(!(Dato>0))
	try{System.out.println("Hilo Restador bloqueado");
	wait();
	} catch (InterruptedException e){}
	Dato--;
	notifyAll();
     }

     public synchronized String toString()
     {
	return(new Integer(Dato).toString());
     }
}
