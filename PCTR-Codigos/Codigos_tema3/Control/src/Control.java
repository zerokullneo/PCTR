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

/**Fichero Control.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class Control extends Thread
{
     //No declara constructor explicito. Usa el disponible por defecto

     public void run()
     {
	for(;;)
	System.out.println("Trabajando");
     }

     public static void main(String[] args) throws Exception
     {
	//usando el constructor implicito
	Control Hilo = new Control();
	Hilo.start();

	//un poquito de entrelazado
	for(int i=1; i<=100; i++)
	     System.out.println("Hola soy el padre");

	for(int i=1; i<=1000000; i++);
	     //Ahora el hilo padre bloquea al hijo.
	     Hilo.suspend(); //USO DE METODO DEROGADO

	System.out.println("Hijo suspendido");

	//Ahora reactivamos al hijo, que pasa a listo.
	Hilo.resume(); //USO DE METODO DEROGADO

	//Ahora destruimos al hijo. Esto no debe hacerse NUNCA
	do
	{
	     Hilo.stop(); //USO DE METODO DEROGADO
	}while(true);	  	
     }
}
