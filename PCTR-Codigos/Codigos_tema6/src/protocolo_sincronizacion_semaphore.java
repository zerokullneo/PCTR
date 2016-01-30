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

/**Fichero protocolo_sincronizacion_semaphore.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */
import java.util.concurrent.*;
/**Descripcion
 * 
 */
class HiloReceptor extends Thread
{
	Semaphore sem;
	public HiloReceptor(Semaphore s){sem = s;}
	public void run()
	{
		System.out.println("Hilo Receptor esta esperando la senal");
		try{sem.acquire();} catch (InterruptedException e) {}
		System.out.println("Hilo Receptor ha recibido la senal");
	}
}


class HiloSenalador extends Thread
{
	Semaphore sem;
	public HiloSenalador(Semaphore s){sem = s;}
	public void run()
	{
		sem.release();
		System.out.println("Hilo Senalador enviando senal...");
	}
}

public class protocolo_sincronizacion_semaphore {

    public static void main(String[] args)
    {
      int v_inic_sem = 0;
      Semaphore s = new Semaphore(v_inic_sem);

      new HiloSenalador (s).start();
new HiloReceptor(s).start();
    }
}