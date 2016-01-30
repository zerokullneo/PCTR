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

/**Fichero incConcurrente.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class incConcurrente extends Thread
{
     private static int n = 0;
     private int nIter;

     public incConcurrente(int v) {nIter=v;}
     public void run()
     {
	for(int i=1;i<=nIter;i++) n++;
     }

     public static void main(String[] args) throws InterruptedException
     {
	int p = 100;
	incConcurrente[] h = new incConcurrente[p];
	for(int i=0;i<h.length;i++)h[i] = new incConcurrente(1000);
	for(int i=0;i<h.length;i++)h[i].start();
	for(int i=0;i<h.length;i++)h[i].join();
	System.out.println(n);
     }
}
