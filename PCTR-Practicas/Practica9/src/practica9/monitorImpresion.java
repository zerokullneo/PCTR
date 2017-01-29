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

//package practica9;

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
     private final int tamano = 3;
     private int [] buffer = null;
     private int putIn = 1, takeOut = 1;
     private int cont = 0;
     
    public monitorImpresion(int nslots)
    {
	numSlots = nslots;
	buffer = new int[numSlots];
    }

    public synchronized int insertar()
    {
        int valor;
	while(cont == numSlots)
	try
	{
	     wait();
	}
	catch(InterruptedException e)
	{
	     System.out.println("ERROR Insertar..." + e);
             return -1;
	}

	valor = buffer[putIn];
	cont++;
	notifyAll();
        return valor;
     }

     public synchronized void extraer(int valor)
     {
	while (cont == 0)
	    try
	    {
		wait();
	    }
	    catch(InterruptedException e)
	    {
		System.out.println("ERROR Extraer..." + e);
	    }

	buffer[takeOut] = valor;
	cont--;
	notifyAll();
     }

    public synchronized void ImpresoraA()
    {
        for(int x = 0; x < tamano; x++)
        {
            numSlots = insertar();
            System.out.println("Imprimiendo Impresora A...");
        }
        extraer(numSlots);
    }

    public synchronized void ImpresoraB()
    {
        for(int x = 0; x < tamano; x++)
        {
	    numSlots = insertar();
            System.out.println("Imprimiendo Impresora B...");
        }
	extraer(numSlots);
    }

    public synchronized void ImpresoraC()
    {
        for(int x = 0; x < tamano; x++)
        {
           numSlots = insertar();
           System.out.println("Imprimiendo Impresora C...");
        }
	extraer(numSlots);
    }
}
