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

/**Fichero Buffer.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class Buffer
{
     private int numSlots = 0;
     private double[] buffer = null;
     private int putIn = 0, takeOut = 0;
     private int cont = 0;

     public Buffer(int numSlots)
     {
	this.numSlots = numSlots;
	buffer = new double[numSlots];
     }

     public synchronized void insertar(double valor)
     {
	if(cont == numSlots)
	     try
	     {
		wait();
	     }
	     catch(InterruptedException e)
	     {
		System.err.println("wait interrumpido..." + e);
	     }

	buffer[putIn] = valor;
	putIn = (putIn + 1) % numSlots;
	cont++;

	if(cont == 1)
	     notifyAll();
     }

     public synchronized double extraer()
     {
	double valor;

	if(cont == 0)
	     try
	     {
		wait();
	     }
	     catch(InterruptedException e)
	     {
		System.err.println("wait interrumpido..." + e);
	     }

	valor = buffer[takeOut];
	takeOut = (takeOut + 1) % numSlots;
	cont--;

	if(cont == numSlots-1)
	     notifyAll();

	return valor;
     }
}//Buffer