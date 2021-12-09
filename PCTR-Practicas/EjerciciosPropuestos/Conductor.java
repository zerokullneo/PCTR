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

package practica8;

/**Fichero Conductor.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class Conductor
{
     int id = 0;
     String nombre;
     String apellidos;
     String matricula;
     int dni;
     String letra;

     /**
      * Constructor de Conductor con parametros.
      * @param d Identificador de Conductor.
      * @param n Nombre del Conductor.
      * @param a Apellidos del Conductor.
      * @param mt Matricula del vehiculo del Conductor.
      * @param dn Digitos del DNI del Conductor.
      * @param l Letra del DNI del Conductor.
      */
     public Conductor(int d, String n, String a, String mt, int dn, String l)
     {
	id = id + d;
	nombre = n;
	apellidos = a;
	matricula = mt;
	dni = dn;
	letra = l;
     }

     /**
      * Metodo que devuelve el identificador del Conductor.
      * @return Devuelve el atributo id de Conductor.
      */
     public synchronized int mostrarID(){return id;}

     /**
      * Metodo que devuelve el Nombre del Conductor.
      * @return Devuelve el atributo nombre de Conductor.
      */
     public synchronized String mostrarNombre(){return nombre;}

     /**
      * Metodo que devuelve el Apellido del Conductor.
      * @return Devuelve el atributo apellidos de Conductor.
      */
     public synchronized String mostrarApellidos(){return apellidos;}

     /**
      * Metodo que devuelve la Matricula del Conductor.
      * @return Devuelve el atributo matricula de Conductor.
      */
     public synchronized String mostrarMatricula(){return matricula;}

     /**
      * Metodo que devuelve el DNI del Conductor, solo los 8 digitos.
      * @return Devuelve el atributo dni de Conductor.
      */
     public synchronized int mostrar_digitosDNI(){return dni;}
     
     /**
      * Metodo que devuelve el DNI+LETRA del Conductor.
      * @return Devuelve una cadena con la composicion de los atributos
      * "dni+letra" de Conductor.
      */
     public synchronized String mostrarDNI(){return dni+letra;}

     /**
      * Metodo que devuelve una cadena con los datos del Conductor.
      * @return Devuelve una cadena con la composicion de todos los
      * atributos de Conductor.
      */
     public synchronized String toString()
     {
	return ("ID" + mostrarID() + ": " + mostrarNombre() + " " + mostrarApellidos() + ", " + mostrarDNI() + "\n\tCoche con Matricula: " + mostrarMatricula());
     }
}
