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

/**Fichero monitorCadena.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
import java.util.*;
import java.lang.*;
import java.text.*;

public class monitorCadena
{
     private int numSlots = 0;
     private int tamano = 0;
     private int [] buffer = null;
     private int putIn = 0, takeOut = 0;
     private int cont = 0;
     private monitorCadena buffer1 = new monitorCadena(100,tamano);
     private monitorCadena buffer2 = new monitorCadena(50,tamano);
     
     public monitorCadena(int nslots, int tam)
     {
	tamano = tam;
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
	putIn = (putIn +1) % numSlots;
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

     public void procesoA()
     {
	int matriz [][] = new int[tamano][tamano];

	for(int x = 0; x < tamano; x++)
	     for(int y = 0; y < tamano; y++)
	     {
		matriz[x][y] = (int)Math.floor(Math.random()*100);
		buffer1.insertar(matriz[x][y]);
	     }
     }

     public void procesoB()
     {
	int matriz[][] = new int[tamano][tamano];
	
	for(int x = 0; x < tamano; x++)
	     for(int y = 0; y < tamano; y++)
	     {
		matriz[y][x] = buffer1.extraer();
		buffer2.insertar(matriz[x][y]);
	     }
     }

     public void procesoC()
     {
	int diag = 0;
	int matriz[][] = new int[tamano][tamano];

	for(int x = 0; x < tamano; x++)
	     for(int y = 0; y < tamano; y++)
		matriz[x][y] = buffer1.extraer();

    	for(int x = 0; x < tamano; x++)
	     diag = diag * matriz[x][x];

	System.out.println("El producto de la diagonal es: " + diag);
    }
}