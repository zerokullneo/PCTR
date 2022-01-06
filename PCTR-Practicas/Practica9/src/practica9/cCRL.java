/*
 * Copyright (C) 2021 Jose Manuel Barba Gonzalez <administrador at elyinyang.com>
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

package practica9;

import java.util.concurrent.locks.*;

/**
 * Fichero cCRL.java
 * @author Jose Manuel Barba Gonzalez <administrador at elyinyang.com>
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 *
 *
 * Descripcion
 * 
 */
public class cCRL
{
	/**Descripcion
	 * Clase general para tratar los movimientos básicos de una cuenta corriente.
	 * Dispone de los métodos para construir una cuenta corriente, ver datos del 
	 * cliente y realizar depósitos o reintegros.
	 */
	public static class cuentaCorriente
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
	
	/**Descripcion
	 * Clase donde se realizan las operaciones especificadas en cuentaCorriente
	 * en un cajero seleccionado por su código.
	 */
	public static class Cajero extends cuentaCorriente implements Runnable
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
		 * Se añade la variable ReentrantLock a esta clase Cajero para el control
		 * de la exclusion mutua con Cerrojos.
		 */
		private final ReentrantLock LockGuard;

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
			LockGuard = new ReentrantLock();
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
							LockGuard.lock();
							try
							{
								CuentaCliente.Deposito(cantidad);
							}
							finally
							{
								LockGuard.unlock();
							}
							break;
						case 20:
							System.out.println("Reintegro: " + cantidad);
							LockGuard.lock();
							try
							{
								CuentaCliente.Reintegro(cantidad);
							}
							finally
							{
								LockGuard.unlock();
							}
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
							LockGuard.lock();
							try
							{
								CuentaCliente.Deposito(cantidad);
							}
							finally
							{
								LockGuard.unlock();
							}
							break;
						case 20:
							System.out.println("Reintegro: " + cantidad);
							LockGuard.lock();
							try
							{
								CuentaCliente.Reintegro(cantidad);
							}
							finally
							{
								LockGuard.unlock();
							}
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

	public static void main(String args[]) throws InterruptedException
	{
		cuentaCorriente CB1 = new cuentaCorriente(1001, 200.50, "Juan García");
		cuentaCorriente CB2 = new cuentaCorriente(1002, 400.50, "Anna López");
	
		System.out.println(CB1.toString());
		System.out.println(CB2.toString());

		Cajero c1 = new Cajero(CB1, 1, 10, 100.0);
		Cajero c2 = new Cajero(CB2, 2, 10, 200.0);
		Cajero c3 = new Cajero(CB2, 2, 20, 80.0);
		Cajero c4 = new Cajero(CB1, 1, 20, 50.0);
	
		Thread C1 = new Thread(c1);
		Thread C2 = new Thread(c2);
		Thread C3 = new Thread(c3);
		Thread C4 = new Thread(c4);
		C1.start();
		C2.start();
		C3.start();
		C4.start();
		C1.join();
		C2.join();
		C3.join();
		C4.join();

		System.out.println(CB1.toString());
		System.out.println(CB2.toString());
	}
}
