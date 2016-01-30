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

package cuenta_banca;

/**Fichero Usa_Cuenta_2.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class Usa_Cuenta_2
{
     private static int Num_Clientes = 3;

     static void Muestra_Cuentas (Cuenta_Banca [] Cuentas)
     {
	int i;
	System.out.println("Numero de Cuenta" + " " + "Disponible");

	for(i = 0; i < Cuentas.length; i++)
	     System.out.println(Cuentas [i].Codigo() + " " + Cuentas[i].Saldo());
     }

     public static void main (String [] args)
     {
	//Se crea un array con la lista de clientes;
	//Cada celda del array es un objeto de la clase Cuenta_Banca;
	Cuenta_Banca [] Clientes = new Cuenta_Banca [Num_Clientes];
	//Se inicializan algunos objetos del array;

	Clientes [0] = new Cuenta_Banca (45072253, 10000);
	Clientes [1] = new Cuenta_Banca (32074263, 1000);
	Clientes [2] = new Cuenta_Banca (75395412, 25394);

	//Se muestra el estado de las cuentas;
	Muestra_Cuentas(Clientes);
     }
}
