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

package practica5;

import java.lang.*;
import java.io.*;
import java.util.*;

/**Fichero algEisenbergMcGuire.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class algEisenbergMcGuire implements Runnable
{
     private enum pstate{IDLE, WAITING, ACTIVE};
     private pstate []flags;
     private static int turn, n, index, i;

     public algEisenbergMcGuire(int t, int num)
     {
	turn = t;
	n = num;
	i = t;
	flags = new pstate[n];
	for(int x = 0; x < n; x++)
	     flags[x] = pstate.IDLE;
     }

     public void run()
     {
	do
	{
	     /* announce that we need the resource */
	     flags[i] = pstate.WAITING;
 
	     /* scan processes from the one with the turn up to ourselves. */
	     /* repeat if necessary until the scan finds all processes idle */
	     index = turn;
	     while(index != i)
	     {
		if(flags[index] != pstate.IDLE) index = turn;
		else index = (index+1) % n;
	     }

	     /* now tentatively claim the resource */
	     flags[i] = pstate.ACTIVE;
 
	     /* find the first active process besides ourselves, if any */
	     index = 0;
	     while((index < n) && ((index == i) || (flags[index] != pstate.ACTIVE)))
		index = index+1;

	     /* if there were no other active processes, AND if we have the turn
	     or else whoever has it is idle, then proceed.  Otherwise, repeat
	     the whole sequence. */
	     i++;
	}while(i < n && (index >= n) && ((turn == i) || (flags[turn] == pstate.IDLE)));

	/* Start of CRITICAL SECTION */
	/* claim the turn and proceed */
	turn = i;

	/* Critical Section Code of the Process */
	/* End of CRITICAL SECTION */
	
	/* find a process which is not IDLE */
	/* (if there are no others, we will find ourselves) */
	index = turn+1 % n;
	while(flags[index] == pstate.IDLE)
	     index = (index+1) % n;

	/* give the turn to someone that needs it, or keep it */
	turn = index;

	/* we're finished now */
	flags[i] = pstate.IDLE;
	/* REMAINDER Section */
     }

     public static void main(String[] args) throws InterruptedException 
     {
	algEisenbergMcGuire t1, t2;

	t1 = new algEisenbergMcGuire(1,1000000);
	t2 = new algEisenbergMcGuire(2,1000000);
	
        //con la interfaz Runnable hay que crear primero los Threads
	Thread EM1 = new Thread(t1);
	Thread EM2 = new Thread(t2);

	EM1.start();
	EM2.start();
	EM1.join();
	EM2.join();
	System.out.println("Valor de variable compartida: " + i);
     }
}