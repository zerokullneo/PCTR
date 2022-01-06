/**
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

package practica2;

/**Fichero Cajero.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * Clase donde se realizan las operaciones especificadas en cuentaCorriente
 * en un cajero seleccionado por su código.
 */
public class Cajero extends cuentaCorriente implements Runnable
{
	/**
	 * Cuenta Corriente con la que se va a tratar para realizar operaciones.
	 */
	cuentaCorriente CuentaCliente;
	/**
	 * Codigo del cajero donde el cliente va a realizar la operación.
	 */
	private final int codcajero;
	/**
	 * Operación que va a realizar el cliente en el cajero seleccionado.
	 */
	private final int operacion;
	/**
	 * Cantidad monetaria que el cliente solicita, reintegrar o depositar.
	 */
	private final double cantidad;

	/**
	 * Constructor especificando los parametros de Cajero.
	 * @param CB Cuenta del cliente a la que se le va a realizar la operacion.
	 * @param cod Codigo del cajero que se va a utilizar en la operacion.
	 * @param op Codigo de operacion que se va a realizar en el cajero especificado.
	 * @param can Cantidad monetaria que se Depositara/Reintegrara en la cuenta.
	 */
	public Cajero(cuentaCorriente CB, int cod, int op, double can)
	{
		CuentaCliente = CB;
		codcajero = cod;
		operacion = op;
		cantidad = can;
	}

	/**
	 * Método run sobreescrito para la selección de un cajero y la operación.
	 */
	@Override
	public void run()
	{
		switch(codcajero)
		{
			case 1:
			{
				System.out.println("Cajero " + codcajero);
				switch(operacion)
				{
					case 10:
						System.out.println("Deposito: " + cantidad);
						CuentaCliente.Deposito(cantidad);
						break;
					case 20:
						System.out.println("Reintegro: " + cantidad);
						CuentaCliente.Reintegro(cantidad);
						break;
					default:
						break;
				}
				break;
			}
			case 2:
			{
				System.out.println("Cajero " + codcajero);
				switch(operacion)
				{
					case 10:
						System.out.println("Deposito: " + cantidad);
						CuentaCliente.Deposito(cantidad);
						break;
					case 20:
						System.out.println("Reintegro: " + cantidad);
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
