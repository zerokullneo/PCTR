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

package hoja7;

/**Fichero Cuenta_BancaSincronizada.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class Cuenta_BancaSincronizada extends Thread
{
     private int Codigo_Cuenta;      //Codigo Cuenta Cliente
     private double Saldo_Cuenta;   //Saldo Actual

     public Cuenta_BancaSincronizada(){} //constructor nulo

     public Cuenta_BancaSincronizada(int id, double disponible) //constructor  
     {
	Codigo_Cuenta = id;
	Saldo_Cuenta = disponible;
     }

     //observador
     public synchronized double Saldo(){return (Saldo_Cuenta);}

     //observador
     public synchronized int Codigo(){return (Codigo_Cuenta);}

     public synchronized void Deposito (double Cantidad) //modificador
     {
	if(Saldo_Cuenta > 0)
	     Saldo_Cuenta = Saldo_Cuenta + Cantidad;
     }

     public synchronized boolean Reintegro (double Cantidad) //modificador
     {
	if((Cantidad <= 0) || ( Cantidad > Saldo_Cuenta))
	     return (false);
	else
	{
	     Saldo_Cuenta = Saldo_Cuenta - Cantidad;
	     return (true);          
	}
     }

     public void run()
     {
	
     }
}
