/**
 * Copyright (C) 2016 Jose Manuel Barba Gonzalez <zk at wordpress.com>
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

package practica9;

/**Fichero monitorImpresion.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class monitorImpresion
{
     private int numSlots = 0;
     private int tamano = 1;
     private int [] buffer = null;
     private int putIn = 0, takeOut = 0;
     private int cont = 0;
     private monitorImpresion buffer1 = new monitorImpresion(3);
     private monitorImpresion buffer2 = new monitorImpresion(3);
     private monitorImpresion buffer3 = new monitorImpresion(3);
     
     public monitorImpresion(int nslots)
     {
	numSlots = nslots;
	buffer = new int[numSlots];
     }

     public synchronized void insertar(int valor)
     {
	while(cont == numSlots)
	try
	{
	     wait();
	}
	catch(InterruptedException e)
	{
	     System.out.println("ERROR Insertar..." + e);
	}

	buffer[putIn] = valor;
	putIn = (putIn + 1) % numSlots;
	cont++;
	notifyAll();
     }

     public synchronized int extraer()
     {
	int valor;
	while (cont == 0)
	     try
	     {
		wait();
	     }
	     catch(InterruptedException e)
	     {
		System.out.println("ERROR Extraer..." + e);
	     }

	valor = buffer[takeOut];
	takeOut = (takeOut + 1) % numSlots;
	cont--;
	notifyAll();

	return valor;
     }

     public void ImpresoraA()
     {
	for(int x = 0; x < tamano; x++)
	     buffer1.insertar(numSlots);
	
	numSlots = buffer1.extraer();
     }

     public void ImpresoraB()
     {
	for(int x = 0; x < tamano; x++)
	     buffer2.insertar(numSlots);
	
	numSlots = buffer2.extraer();
     }

     public void ImpresoraC()
     {
	for(int x = 0; x < tamano; x++)
	     buffer3.insertar(numSlots);
	     
	numSlots = buffer3.extraer();
    }
}
