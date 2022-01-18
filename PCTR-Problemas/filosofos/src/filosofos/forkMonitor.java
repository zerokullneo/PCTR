/*
 * Copyright (C) 2021 Jose Manuel Barba Gonzalez <zk at wordpress.com>
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

package filosofos;

import static java.lang.Thread.*;
import java.util.logging.*;

/**
 * Fichero forkMonitor.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 *
 *
 * Descripcion
 *
 */
public class forkMonitor
{
    private static int []fork;
    private static int N;

    public forkMonitor(int n)
    {
        fork = new int[n];
        N = n;
    }

    public synchronized void takeForks(int i)
    {
        try
        {
            System.out.println("Filosofo " + i + ", adquiere tenedores..." + Thread.currentThread().getName());
            sleep(1000);
            fork[i] = 2;
            while(fork[i] != 2)
                wait();
            int masuno = ((i + 1) % N);
            int menuno = ((i - 1) % N);
            if(menuno == -1)
                menuno = menuno + N;
            System.out.println("indices: " + masuno + ", " + menuno);
            fork[masuno] = fork[masuno] - 1;
            fork[menuno] = fork[menuno] - 1;
        }
        catch (InterruptedException ex)
        {
            Logger.getLogger(forkMonitor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized void releaseForks(int i)
    {
        try
        {
            System.out.println("Filosofo " + i + ", libera tenedores..." + Thread.currentThread().getName());
            sleep(1000);
            fork[i] = 0;
            int masuno = ((i + 1) % N);
            int menuno = ((i - 1) % N);
            if(menuno == -1)
                menuno = menuno + N;
            fork[masuno] = fork[masuno] + 1;
            fork[menuno] = fork[menuno] + 1;


                /*while(fork[masuno] == 2)
                    notifyAll();
                while(fork[menuno] == 2)*/
            notifyAll();
        }
        catch (InterruptedException ex)
        {
            Logger.getLogger(forkMonitor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}