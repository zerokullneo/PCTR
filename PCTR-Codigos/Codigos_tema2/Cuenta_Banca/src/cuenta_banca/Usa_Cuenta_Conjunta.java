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

/**Fichero Usa_Cuenta_Conjunta.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class Usa_Cuenta_Conjunta
{
     public static void main (String [] args)
     {
	Cuenta_Conjunta AntonioyJuan;

          AntonioyJuan = new Cuenta_Conjunta (1234, 25000, "Antonio Lopez", "Juan Perez");
	AntonioyJuan.Deposito (25000);
	System.out.println (AntonioyJuan.Saldo () );     
     }
}
