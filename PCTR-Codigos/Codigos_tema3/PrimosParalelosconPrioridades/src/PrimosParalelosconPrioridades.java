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

/**Fichero PrimosParalelosconPrioridades.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */
import java.util.concurrent.*;
import java.util.*;

/**Descripcion
 * 
 */
public class PrimosParalelosconPrioridades implements Runnable
{
     private final long linf;
     private final long lsup;
     private static long total = new Long(0);
   	
     public PrimosParalelosconPrioridades(long linf, long lsup)
     {
	this.linf = linf;
	this.lsup = lsup;
     }
  
     public static boolean esPrimo(long n)
     {
	if(n<=1) return(false);

	for(long i=2; i<=Math.sqrt(n); i++)
	     if(n%i == 0) return(false);

	return(true);
     }	

     public static long getTotal(){return total;}

     public void run()
     {
	for(long i=linf; i<=lsup;i++)
	if(esPrimo(i)) total++;
     }

     public static void main(String[] args) throws Exception
     {
	long nPuntos = 10000000;
	int nTareas = 10; //Runtime.getRuntime().availableProcessors();
	long tVentana = nPuntos/nTareas;
	long primosTotal[] = new long[nTareas];
	long linf = 0;
	long lsup = tVentana;
    
	long inicTiempo = System.nanoTime();  
	ThreadPoolExecutor ept = new ThreadPoolExecutor(nTareas,nTareas,0L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
	PrimosParalelosconPrioridades[] primoprioridad = new PrimosParalelosconPrioridades[nTareas];

	for(int i=0; i<nTareas; i++)
	{
	     primoprioridad[i] = new PrimosParalelosconPrioridades(linf, lsup);
	     ept.execute(primoprioridad[i]);
	     primosTotal[i] = primoprioridad[i].getTotal();
	}

	long tiempoTotal = (System.nanoTime()-inicTiempo)/(long)1.0e9;   
	ept.shutdown();
	for(int i=0; i<nTareas; i++)
	     System.out.println("Primos hallados hilo " + i + ": " + primosTotal[i]);
	System.out.println("Calculo finalizado en " + tiempoTotal + " segundos");
     }
}