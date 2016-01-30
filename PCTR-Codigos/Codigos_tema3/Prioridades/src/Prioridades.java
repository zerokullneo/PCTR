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

/**Fichero Prioridades.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class Prioridades extends Thread
{
     private long dato;
     private static int aux = 4;

     public Prioridades(long n)
     {dato=n;}

     private long fac(long n)
     {
	if (n == 0) return 0;
	else if (n == 1) return 1;
	else return(fac(n-1)*n);
     }
           
     public void run()
     { 
	this.setPriority(aux++);
	System.out.println("El factorial de "+dato+" es "+fac(dato));
     }

     public static void main(String[] args) 
     {
	new Prioridades(10).start();
	new Prioridades(20).start();
	new Prioridades(30).start();
	new Prioridades(40).start();
	new Prioridades(50).start();
	new Prioridades(60).start();
     }
}
