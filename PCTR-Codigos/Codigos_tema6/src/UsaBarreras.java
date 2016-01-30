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

/**Fichero UsaBarreras.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */
import java.util.concurrent.*;
/**Descripcion
 * 
 */

class HiloBarrera extends Thread
{
     CyclicBarrier barrera = null;

     public HiloBarrera(CyclicBarrier bar)
     {
	barrera = bar;
     }
     
     public void run()
     {
	try
	{
	     int i = barrera.await();
	}
	catch(BrokenBarrierException e)
	{
	     System.out.println("ERROR BARRERA ROTA..." + e);
	}
	catch(InterruptedException e)
	{
	     System.out.println("ERROR..." + e);
	}
	System.out.println("El hilo "+this.toString()+" paso la barrera...");
     }
}

public class UsaBarreras
{
     public static void main(String[] args)
     {
	int numHilos = 3;
	CyclicBarrier PasoANivel = new CyclicBarrier(numHilos);
	new HiloBarrera(PasoANivel).start();
	new HiloBarrera(PasoANivel).start();
	new HiloBarrera(PasoANivel).start();
     }
}
