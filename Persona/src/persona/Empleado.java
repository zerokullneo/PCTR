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

/**Fichero Empleado.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class Empleado extends Persona
{
     private String Universidad;
     private String Facultad;
     private double salario;
     private int horas_contratado;

     /**
      * Constructor vacio de Empleado.
      */
     public Empleado()
     {
	super();
	Universidad = " ";
	Facultad = " ";
	salario = 0;
	horas_contratado = 0;
     }

     /**
      * Constructor especificando los parametros de Empleado.
      * @param n es la cadena correspondiente al nombre de la Persona.
      * @param e correspondiente a la edad de la Persona.
      * @param d correspondiente al número DNI de la Persona.
      * @param l correspondiente a la letra del DNI de la Persona.
      * @param s correspondiente al sexo de la Persona.
      * @param u correspondiente a la Universidad del Empleado.
      * @param f correspondiente a la Facultad del Empleado.
      * @param r correspondiente a la remuneracion/salario del Empleado.
      * @param hc correspondiente a las horas de contrato del Empleado.
      */
     public Empleado(String n, int e, int d, String l, sexo s, String u, String f, double r, int hc)
     {
	super(n,e,d,l,s);
	Universidad = u;
	Facultad = f;
	salario = r;
	horas_contratado = hc;
     }

     /**
      * Metodo observador del atributo Universidad.
      * @return Devuelve el atributo Universidad.
      */
     public String mostrar_universidad(){ return Universidad;}

     /**
      * Metodo observador del atributo Facultad.
      * @return Devuelve el atributo Facultad.
      */
     public String mostrar_facultad(){ return Facultad;}

     /**
      * Metodo observador del atributo Salario.
      * @return Devuelve el atributo salario.
      */
     public double mostrar_salario(){ return salario;}

     /**
      * Metodo observador del atributo horas de contrato.
      * @return Devuelve el atributo horas_contratado.
      */
     public int mostrar_hcontratado(){ return horas_contratado;}

     /**
      * Metodo para visualizar los datos especificos de Empleado.
      * @return Devuelve El String con los atributos del Empleado.
      */
     public String mostrar_empleado()
     {
	return(toString() + "\t" + Universidad + ", " + Facultad + ", Salario: " + salario + "€, Horas Semanales: " + horas_contratado);
     }

}
