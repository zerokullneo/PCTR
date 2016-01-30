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

/**Fichero Usa_Cuenta.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class Usa_Cuenta
{
     public static void main (String [] args)
     {
	Cuenta_Banca Antonio;
	Cuenta_Banca Juan = new Cuenta_Banca(32756821, 100000);

	Juan.Deposito (25000);
	//Se muestra el nuevo saldo de la cuenta de Juan;
	System.out.println ("El saldo de Juan es:"+Juan.Saldo());

	//Se crea la cuenta de Antonio;
	Antonio = new Cuenta_Banca(45073256, 25000);

	//Se muestra el codigo de la cuenta de Antonio;
	System.out.println("El codigo de Antonio es:"+Antonio.Codigo());

	//Antonio hace un reintegro por valor de 2000 y se muestra el saldo;
	Antonio.Reintegro(2000);
	System.out.println("Nuevo saldo de Antonio: "+Antonio.Saldo());
     }
}
