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

/**Fichero Cuenta_Corriente.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class Cuenta_Corriente extends Cuenta_Banca2
{
     private static float Saldo_Minimo = 2500; //por encima, operativa //gratis
     private static float Comision = 18;  //comision para saldos //inferiores
     private boolean gratuita = false;

     public Cuenta_Corriente () {} //constructor nulo

     public Cuenta_Corriente (int n, double b, String prop)
     {
	super(n, b, prop);
	gratuita = (b >= Saldo_Minimo);
     }

     public static void Cambiar_Saldo_Minimo (float m)
     {
	Saldo_Minimo = m;
     }

     public static void Cambiar_Comision (float f)
     {
	Comision = f;
     }

     public boolean Reintegro (double Cantidad)
     {
	boolean Resultado = super.Reintegro(Cantidad); //procesamiento general
	if(Resultado && (Saldo ()<Saldo_Minimo)) //procesamiento especifico
	     gratuita = false;

	return (Resultado);
     }

     public boolean Cobro_Comision ()    //cargo mensual, si procede
     {
	boolean Resultado;
	if(!gratuita)
	{
	     if(Resultado = Reintegro (Comision))
	     gratuita = (Saldo ()>=Saldo_Minimo);
	     return (Resultado);
	}
	return (true);
     }
}
