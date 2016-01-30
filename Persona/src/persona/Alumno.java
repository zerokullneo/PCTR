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

/**Fichero Alumno.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class Alumno extends Persona
{
     private String Universidad;
     private String Facultad;
     private String Grado;
     private int curso;

     /**
      * Constructor vacio de Alumno.
      */
     public Alumno()
     {
	super();
	Universidad = " ";
	Facultad = " ";
	Grado = " ";
	curso = 1;
     }

     /**
      * Constructor especificando los parametros de Alumno.
      * @param n es la cadena correspondiente al nombre de la Persona.
      * @param e correspondiente a la edad de la Persona.
      * @param d correspondiente al número DNI de la Persona.
      * @param l correspondiente a la letra del DNI de la Persona.
      * @param s correspondiente al sexo de la Persona.
      * @param u correspondiente a la Universidad del Alumno.
      * @param f correspondiente a la Facultad del Alumno.
      * @param g correspondiente a la Titulacion del Alumno.
      * @param c correspondiente al Curso matriculado del Alumno.
      */
     public Alumno(String n, int e, int d, String l, sexo s, String u, String f, String g, int c)
     {
	super(n,e,d,l,s);
	Universidad = u;
	Facultad = f;
	Grado = g;
	curso = c;
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
      * Metodo observador del atributo Grado.
      * @return Devuelve el atributo Grado.
      */
     public String mostrar_grado(){ return Grado;}

     /**
      * Metodo observador del atributo Curso.
      * @return Devuelve el atributo curso.
      */
     public int mostrar_curso(){ return curso;}

     /**
      * Metodo para visualizar los datos especificos de Alumno.
      * @return Devuelve El String con los atributos del Alumno.
      */
     public String mostrar_alumno()
     {
	return(toString() + "\t" + Universidad + ", " + Facultad + ", " + Grado + ", Curso: " + curso + "º.\n");
     }
}
