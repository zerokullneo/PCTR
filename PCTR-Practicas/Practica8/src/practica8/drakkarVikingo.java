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

package practica8;

/**Fichero drakkarVikingo.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
class drkVikingo extends Thread
{
     private static int operando;
     private static int marmita;
     private static int anguilas; // num anguilas

     /**
      * Constructor de drkVikingo con parametros.
      * @param o Parametro para diferenciar entre la operacion comer o cocinar.
      * @param m Parametro para indicar el estado de la marmita vacia/llena.
      * @param a Parametro para indicar el numero inicial de anguilas.
      */
     public drkVikingo(int o, int m, int a)
     {
	operando = o;
	marmita = m;
	anguilas = a;
     }

     /**
      * Metodo run() que controla la exclusion mutua del estado de la marmita.
      */
     @Override
     public void run()
     {
	synchronized(this)
	{
	     switch(operando)
	     {
		case 0://Comer
		     while(true)
		     {
			System.out.println("comer");
			comer();
		     }
		case 1://Cocinar
		     while (true)
		     {
			System.out.println("cocinar");
			cocinar();
		     }
	     }
	}
     }

     /**
      * Metodo que controla cuando puede comer cualquiera de los vikingos
      * en el momento en el que la marmita contenga anguilas.
      */
     public synchronized void comer()
     {
	while(marmita==0)
	{
	     try
	     {
		System.out.println("marmita vacia");
		wait();
	     }
	     catch(InterruptedException e)
	     {
		System.err.println("ERROR COMIENDO..." + e);
	     }
	}		

	marmita--;

	if (marmita==0)
	     notifyAll();
     }

     /**
      * Metodo que controla cuando el momento en el que hay que cocinar
      * para rellenar la marmita de anguilas.
      */
     public synchronized void cocinar()
     {
	while(marmita!=0)
	{
	     try
	     {
		wait();
	     }
	     catch(InterruptedException e)
	     {
		System.err.println("ERROR COCINA..." + e);
	     }
	}

	marmita = anguilas;

	if(marmita!=0)
	     notifyAll();
     }
}

public class drakkarVikingo
{
     private static final int vikingos = 10; // num vikingos
     private static int marmi = 0;
     private static final int angui = 100; // num anguilas
     
     public static void main(String[] args)
     {
	marmi = angui;
	drkVikingo v[] = new drkVikingo[vikingos]; //creo un vector con los vikingos
	drkVikingo cocinero = new drkVikingo(1, marmi, angui); //creo un cocinero

	for(int i = 0; i < vikingos; i++)
	{
	     v[i] = new drkVikingo(0, marmi, angui);
	}

	for (int i = 0; i < vikingos; i++)
	{
	     v[i].start(); //lanzo los vikingos
	}

	cocinero.start(); //lanzo el cocinero
     }
}
