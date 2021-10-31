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

package practica3;

/**Fichero Cajero.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class Cajero extends Cuenta_Banca implements Runnable
{
     Cuenta_Banca CuentaCliente;
     private int codcajero, operacion;
     private double cantidad;

     /**
      * Constructor especificando los parametros de Cajero.
      * @param CB Cuenta del cliente a la que se le va a realizar la operacion.
      * @param cod Codigo del cajero que se va a utilizar en la operacion.
      * @param op Codigo de operacion que se va a realizar en el cajero especificado.
      * @param can Cantidad monetaria que se Depositara/Reintegrara en la cuenta.
      */
     public Cajero(Cuenta_Banca CB, int cod, int op, double can)
     {
	CuentaCliente = CB;
	codcajero = cod;
	operacion = op;
	cantidad = can;
     }

     public void run()
     {
	switch(codcajero)
	{
	     case 1:
	     {
		System.out.println("Cajero 1:");
		switch(operacion)
		{
		     case 10:
			System.out.println("Deposito:");
			CuentaCliente.Deposito(cantidad);
			break;
		     case 20:
			System.out.println("Reintegro:");
			CuentaCliente.Reintegro(cantidad);
			break;
		     default:
			break;
		}
		break;
	     }
	     case 2:
	     {
		System.out.println("Cajero 2:");
		switch(operacion)
		{
		     case 10:
			System.out.println("Deposito:");
			CuentaCliente.Deposito(cantidad);
			break;
		     case 20:
			System.out.println("Reintegro:");
			CuentaCliente.Reintegro(cantidad);
			break;
		     default:
			break;
		}
		break;
	     }
	     default:
		break;
	}
     }
}
