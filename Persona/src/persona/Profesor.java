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

/**Fichero Profesor.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class Profesor extends Empleado
{
     private int horas_lectivas;
     private int horas_investigacion;

     /**
      * Constructor vacio de Profesor.
      */
     public Profesor()
     {
	super();
	horas_lectivas = 0;
	horas_investigacion = 0;
     }

     /**
      * Constructor especificando los parametros de Profesor.
      * @param n es la cadena correspondiente al nombre de la Persona.
      * @param e correspondiente a la edad de la Persona.
      * @param d correspondiente al número DNI de la Persona.
      * @param l correspondiente a la letra del DNI de la Persona.
      * @param s correspondiente al sexo de la Persona.
      * @param u correspondiente a la Universidad del Empleado.
      * @param f correspondiente a la Facultad del Empleado.
      * @param r correspondiente a la remuneracion/salario del Empleado.
      * @param hc correspondiente a las horas de contrato del Empleado.
      * @param hl correspondiente a las horas lectivas del Profesor.
      * @param hi correspondiente a las horas de investigacion del Profesor.
      */
     public Profesor(String n, int e, int d, String l, sexo s, String u, String f, double r, int hc, int hl, int hi)
     {
	super(n,e,d,l,s,u,f,r,hc);
	horas_lectivas = hl;
	horas_investigacion = hi;	
     }

     /**
      * Metodo observador del atributo horas lectivas.
      * @return Devuelve el atributo horas_lectivas.
      */
     public int mostrar_hlectivas(){ return horas_lectivas; }

     /**
      * Metodo observador del atributo horas de investigacion.
      * @return Devuelve el atributo horas_investigacion.
      */
     public int mostrar_hinvestigacion(){ return horas_investigacion; }
     
     /**
      * Metodo para visualizar los datos especificos de Profesor.
      * @return Devuelve El String con los atributos de Profesor.
      */
     public String mostrar_profesor()
     {
	return(mostrar_empleado() + ", Horas Lectivas: " + horas_lectivas + ", Horas Investigacion: " + horas_investigacion + ".\n");
     }

}
