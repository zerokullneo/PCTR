/**
 * Copyright (C) 2017 Jose Manuel Barba Gonzalez <zk at wordpress.com>
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

package practica12;

import static java.lang.Thread.sleep;
import java.util.concurrent.*;
/**Fichero pcHebras.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class pcHebras
{
    public static void main(String[] args) throws InterruptedException
    {
        double inicTiempo = System.nanoTime();

        pcMonitor p1 = new pcMonitor(0);
        p1.start();

        pcMonitor p2 = new pcMonitor(0);
        p2.start();

        pcMonitor p3 = new pcMonitor(0);
        p3.start();

        pcMonitor p4 = new pcMonitor(0);
        p4.start();

        pcMonitor p5 = new pcMonitor(0);
        p5.start();
        
        pcMonitor c1 = new pcMonitor(1);
        c1.start();
        
        pcMonitor c2 = new pcMonitor(1);
        c2.start();
        
        pcMonitor c3 = new pcMonitor(1);
        c3.start();
        
        pcMonitor c4 = new pcMonitor(1);
        c4.start();
        
        pcMonitor c5 = new pcMonitor(1);
        c5.start();
        sleep(1000);
        c5.join();
        c4.join();        
        c3.join();
        c2.join();
        c1.join();
        sleep(2000);
        p1.join();
        p2.join();
        p3.join();
        p4.join();
        p5.join();

        double tiempoTotal = (System.nanoTime()-inicTiempo)/(double)1.0e9;
        System.out.println("en "+tiempoTotal+" segundos...");
    }
}
