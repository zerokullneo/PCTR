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

package hoja5;

import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**Fichero S1.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * monitor para S2
 */
public class S1 implements Runnable
{
     public static int turno;
     private boolean libre;

     public S1(int t)
     {
	turno = t;
	libre = true;
     }

     //establece los turnos
     public synchronized void metodoA()
     {
	while(turno <= 2)
	{
	     try
	     {
		S2.esperar();//wait();
		libre = false;
	     }
	     catch(InterruptedException ex)
	     {
		Logger.getLogger(S1.class.getName()).log(Level.SEVERE, null, ex);
	     }
	     turno ++;
	     System.out.println("turno: " + turno);
	}
	S2.senalar();//notifyAll();
     }
     
     //comprueba si el cerrojo tiene hueco
     public synchronized boolean metodoB()
     {
	if(libre == false)
	     return false;
	return true;
     }
     
     public synchronized void run()
     {
	if(metodoB() == true)
	{
	     metodoA();
	}
     }
}
