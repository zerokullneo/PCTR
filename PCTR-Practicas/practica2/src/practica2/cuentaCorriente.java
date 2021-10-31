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

/**Fichero Cuenta_Banca.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * Clase general para tratar los movimientos básicos de una cuenta corriente.
 * Dispone de los métodos para construir una cuenta corriente, ver datos del 
 * cliente y realizar depósitos o reintegros.
 */
public class cuentaCorriente
{
	/**
	 * IBAN Cuenta Cliente
	 */
	protected int Numero_Cuenta;

	/**
	 *Titular de la Cuenta
	 */
	protected String Titular;

	/**
	 * Saldo Actual de la Cuenta
	 */
	private double Saldo_Cuenta;

	/**
	 * Constructor vacio de Cuenta_Banca.
	 */
	public cuentaCorriente () {} //constructor nulo

	/**
	 * Constructor especificando los parametros de Cuenta_Banca.
	 * @param id Identificador de la cuenta del Cliente.
	 * @param disponible Saldo con el que el Cliente abre la cuenta.
	 * @param propietario Nombre Completo del Titular de la Cuenta.
	 */
	public cuentaCorriente (int id, double disponible, String propietario)
	{
		Numero_Cuenta = id;
		Saldo_Cuenta = disponible;
		Titular = propietario;
	}

	//Metodos Observadores
	/**
	 * Metodo observador del atributo Numero_Cuenta.
	 * @return Devuelve el atributo Numero_Cuenta.
	 */
	public int Codigo(){return Numero_Cuenta;}

	/**
	 * Metodo observador del atributo Titular.
	 * @return Devuelve el atributo Titular.
	 */
	public String Titular(){return Titular;}

	/**
	 * Metodo observador del atributo Saldo_Cuenta.
	 * @return Devuelve el atributo Saldo_Cuenta.
	 */
	public double Saldo(){return Saldo_Cuenta;}

	//Metodos Modificadores
	/**
	 * Metodo Modificador del atributo Saldo_Cuenta en el que se añade al Saldo
	 * la Cantidad especificada del parametro de entada.
	 * @param Cantidad Valor que se añade a la cantidad disponible en Saldo.
	 */
	public void Deposito(double Cantidad)
	{
		if(Saldo_Cuenta > 0)
			Saldo_Cuenta = Saldo_Cuenta+Cantidad;
	}

	/**
	 * Metodo Modificador del atributo Saldo_Cuenta en el que se retira la 
	 * Cantidad especificada del parametro de entada al Saldo_Cuenta.
	 * @param Cantidad Valor que se retira a la cantidad disponible en es Saldo.
	 * @return Devuelve verdadero si hay suficiente disponible en Saldo_Cuenta
	 * y se retira la cantidad especificada, y falso en caso de que no haya hay
	 * suficiente disponible en Saldo_Cuenta.
	 */
	public boolean Reintegro(double Cantidad)
	{
		if((Cantidad  <= 0)||(Cantidad > Saldo_Cuenta))
			return (false);
		else
		{
			Saldo_Cuenta = Saldo_Cuenta-Cantidad;
			return (true);          
		}
	}      

	/**
	 * Metodo para visualizar los datos de la Cuenta Bancaria.
	 * @return Devuelve el String con los atributos de la Cuenta.
	 */
	public String toString()
	{
		return "Cliente: " + Titular() + ", ID Cuenta: " + Codigo() + ", Saldo: " + Saldo();
	}
}
