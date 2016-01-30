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

/**Fichero Cuenta_Conjunta.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class Cuenta_Conjunta extends Cuenta_Banca2
{
     public Cuenta_Conjunta () {} //constructor nulo
     public Cuenta_Conjunta (int n,double b,String prop1,String prop2)
     {
	super (n, b, prop1);   //llama al constructor de la superclase 
	Titular2 = prop2;
     }
     private String Titular2;  //Otro titular de una cuenta conjunta
     
     /**
      * @return cadena modificada
      **/
     public String toString()
     {
	return("El Titular Principal es: " + Titular + ", el Titular secundario es: "
	        + Titular2 + "\nSaldo de la cuenta: " + Saldo());
     }
}
