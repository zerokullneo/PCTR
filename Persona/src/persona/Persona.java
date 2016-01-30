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

package persona;

/**Fichero Persona.java 
  *@author Jose Manuel Barba Gonzalez
  *@version 1.0
  *Programacion Concurrente y de Tiempo Real
  *Area de CC. de la Computacion e I.A.
*/
public class Persona
{
     private String nombre;
     private int edad;
     private int dni;
     private String letra;
     public enum sexo{Mujer,Hombre,Indefinido}
     private sexo sex;
     
     /** 
     * Constructor vacío de Persona.
     */
     public Persona()
     {
	nombre = " ";
	edad = 18;
	dni = 0;
	letra = " ";
	sex = sexo.Indefinido;
     };
     
     /**
     * Constructor especificando los parametros de Persona.
     * @param n es la cadena correspondiente al nombre de la Persona.
     * @param e correspondiente a la edad de la Persona.
     * @param d correspondiente al número DNI de la Persona.
     * @param l correspondiente a la letra del DNI de la Persona.
     * @param s correspondiente al sexo de la Persona.
     */
     public Persona(String n, int e, int d, String l, sexo s)
     {
	nombre = n;
	edad = e;
	dni = d;
	letra = l;
	sex = s;
     }

     /**
      * Metodo observador del atributo nombre.
      * @return Devuelve el atributo nombre.
      */
     public String mostrar_nombre(){ return nombre;}

     /**
      * Metodo observador del atributo edad.
      * @return Devuelve el atributo edad.
      */
     public int mostrar_edad(){ return edad;}

     /**
      * Metodo observador del atributo dni.
      * @return Devuelve el atributo dni.
      */
     public int mostrar_dni(){ return dni;}

     /**
      * Metodo observador del atributo letra.
      * @return Devuelve el atributo letra.
      */
     public String mostrar_letra(){ return letra;}

     /**
      * Metodo observador del atributo sexo.
      * @return Devuelve el atributo sexo.
      */
     public sexo mostrar_sexo(){ return sex;}

     /**
      * Metodo para visualizar los datos de la Persona.
      * @return Devuelve El String con los atributos de la Persona.
      */
     public String toString()
     {
	return(nombre + ", " + edad + ", " + dni + letra + ", " + sex + ".\n");
     }
}