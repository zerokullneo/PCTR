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

package hoja9;

/**Fichero Buffer.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * Ejemplo de Monitor sencillo para productor-consumidor. 
 *Encapsula un buffer protegida por la abtraccion
 *y posee una interfaz de dos metodos para insertar y extraer, y se provee
 *la sincronización necesaria. Observe que la condicion de guarda es de la 
 *forma if(...)try{wait()}... en lugar de while(!condicion)try{wait()}... De 
 *igual forma se senializa con notify(), en lugar de con notifyAll(). 
 *¿Funcionaria esto  con varios productores y consumidores?
 *@author Antonio Tomeu
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
	while(cont == numSlots)
	     try
	     {
		wait();
	     }
	     catch(InterruptedException e)
	     {
		System.err.println("wait interrumpido" + e);
	     }
	
	buffer[putIn] = valor;
	putIn = (putIn + 1) % numSlots;
	cont++;
	notifyAll();
     }

     public synchronized double extraer()
     {
	double valor;
	while(cont == 0)
	     try
	     {
		wait();
	     }
	     catch(InterruptedException e)
	     {
		System.err.println("wait interrumpido" + e);
	     }

	valor = buffer[takeOut];
	takeOut = (takeOut + 1) % numSlots;
	cont--;
	notifyAll();
	return valor;
     }
}
