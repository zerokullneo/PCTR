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
    private int putIn = 1, takeOut = 1;
    private int matriz [][];
    private int cont = 0;
    private final int[] buffer1 = new int[100];
    private int[] buffer2 = new int[50];
    

     public monitorCadena(int nslots, int tam)
     {
	tamano = tam;
	numSlots = nslots;
        matriz = new int[tamano][tamano];
     }

     public synchronized int insertar(int buffaux[])
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

	valor = buffaux[putIn];
	cont++;
	notifyAll();
        return valor;
     }

     public synchronized int[] extraer(int valor)
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

	valor = buffer1[takeOut];
	cont--;
	notifyAll();
        return buffer1;
     }

     public synchronized void procesoA()
     {
	for(int x = 0; x < tamano; x++)
	    for(int y = 0; y < tamano; y++)
	    {
                matriz[x][y] = (int)Math.floor(Math.random()*100);
		numSlots=insertar(buffer1);
            }
     }

     public synchronized void procesoB()
     {
	int matrizI[][] = new int[tamano][tamano];
	
	for(int x = 0; x < tamano; x++)
	     for(int y = 0; y < tamano; y++)
	     {
		buffer2 = extraer(matrizI[y][x]);
		numSlots=insertar(buffer2);
	     }
     }

     public synchronized void procesoC()
     {
	int diag = 0;
	int matrizD[][] = new int[tamano][tamano];

	for(int x = 0; x < tamano; x++)
	     for(int y = 0; y < tamano; y++)
		extraer(matrizD[x][y]);

    	for(int x = 0; x < tamano; x++)
	     diag = diag * matriz[x][x];

	System.out.println("El producto de la diagonal es: " + diag);
    }
}
