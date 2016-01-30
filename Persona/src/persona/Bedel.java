/**
 * Copyright (C) 2016 Jose Manuel Barba Gonzalez <zk at wordpress.com>
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

package persona;

/**Fichero Bedel.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class Bedel extends Empleado
{
     public enum llaves{Apertura,Cierre,Libre}
     private llaves amo;
     public enum turno{Mañana,Tarde}
     private turno tur;

     /**
      * Constructor vacio de Bedel.
      */
     public Bedel()
     {
	super();
	tur = turno.Tarde;
	amo = llaves.Libre;
     }

     /**
      * Constructor especificando los parametros de Bedel.
      * @param n es la cadena correspondiente al nombre de la Persona.
      * @param e correspondiente a la edad de la Persona.
      * @param d correspondiente al número DNI de la Persona.
      * @param l correspondiente a la letra del DNI de la Persona.
      * @param s correspondiente al sexo de la Persona.
      * @param u correspondiente a la Universidad del Empleado.
      * @param f correspondiente a la Facultad del Empleado.
      * @param r correspondiente a la remuneracion/salario del Empleado.
      * @param hc correspondiente a las horas de contrato del Empleado.
      * @param t correspondiente al turno del Bedel.
      * @param ll correspondiente a que Bedel le corresponde las llaves de apertura/cierre.
      */
     public Bedel(String n, int e, int d, String l, sexo s, String u, String f, double r, int hc, turno t, llaves ll)
     {
	super(n,e,d,l,s,u,f,r,hc);
	tur = t;
	amo = ll;
     }

     /**
      * Metodo observador del atributo Turno.
      * @return Devuelve el atributo tur.
      */
     public turno mostrar_turno(){ return tur; }

     /**
      * Metodo observador del atributo llaves.
      * @return Devuelve el atributo amo.
      */
     public llaves mostrar_llaves(){ return amo;}

     /**
      * Metodo para visualizar los datos especificos de Bedel.
      * @return Devuelve El String con los atributos de Bedel.
      */
     public String mostrar_bedel()
     {
	return(mostrar_empleado() + ", Turno: " + tur + ", Encargado de: " + amo + ".\n");
     }

}
