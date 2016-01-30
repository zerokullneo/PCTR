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

package hoja2;

/**Fichero cPlanetario.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class cPlanetario
{
     private String nombre;
     private float masa;
     private float diametro;
     private float dsol;
     private float periodo;
     private float albedo;
     private boolean atmosfera;
     private static final double gGravitacional = 6.6;

     /**
      * Constructor especificando los parametros de Punto.
      * @param n Es la cadena correspondiente al nombre del cuerpo planetario.
      * @param m correspondiente a la masa del cuerpo planetario.
      * @param d correspondiente al diametro del cuerpo planetario.
      * @param ds correspondiente a la distancia al sol del cuerpo planetario.
      * @param p correspondiente al periodo del cuerpo planetario.
      * @param alb correspondiente al albedo del cuerpo planetario.
      * @param atm correspondiente a si el cuerpo planetario tiene o no atmosfera.
      */
     public cPlanetario(String n, float m, float d, float ds, float p, float alb, boolean atm)
     {
	nombre = n;
	masa = m;
	diametro = d;
	dsol = ds;
	periodo = p;
	albedo = alb;
	atmosfera = atm;
     }
     
     /**
      * Metodo Observador de Nombre.
      *@return Devuelve el valor del atributo nombre.
      **/
     public String mostrar_nombre(){return nombre;}

     /**
      * Metodo Observador de la Masa.
      * @return Devuelve el valor del atributo masa.
      */
     public float mostrar_masa(){return masa;}

     /**
      * Metodo Observador del Diametro.
      * @return Devuelve el valor del atributo diametro.
      */
     public float mostrar_diametro(){return diametro;}

     /**
      * Metodo Observador de la distancia al sol.
      * @return Devuelve el valor del atributo dsol.
      */
     public float mostrar_dsol(){return dsol;}

     /**
      * Metodo Observador del Periodo.
      * @return Devuelve el valor del atributo periodo.
      */
     public float mostrar_periodo(){return periodo;}

     /**
      * Metodo Observador del Albedo.
      * @return Devuelve el valor del atributo albedo.
      */
     public float mostrar_albedo(){return albedo;}

     /**
      * Metodo Observador de Atmosfera.
      * @return Devuelve el valor del atributo atmosfera.
      */
     public boolean mostrar_atmosfera(){return atmosfera;}

     /**
      * Metodo Modificador del atributo nombre.
      *@param n Modifica el valor del atributo nombre.
      **/
     public void modificar_nombre(String n){nombre = n;}

     /**
      * Metodo Modificador del atributo masa.
      * @param m Modifica el valor del atributo masa.
      */
     public void modificar_masa(float m){masa = m;}

     /**
      * Metodo Modificador del atributo diametro.
      * @param d Modifica el valor del atributo diametro.
      */
     public void modificar_diametro(float d){diametro = d;}

     /**
      * Metodo Modificador del atributo distancia al sol.
      * @param ds Modifica el valor del atributo dsol.
      */
     public void modificar_dsol(float ds){dsol = ds;}

     /**
      * Metodo Modificador del atributo periodo.
      * @param p Modifica el valor del atributo periodo.
      */
     public void modificar_periodo(float p){periodo = p;}

     /**
      * Metodo Modificador del atributo albedo.
      * @param alb Modifica el valor del atributo albedo.
      */
     public void modificar_albedo(float alb){albedo = alb;}

     /**
      * Metodo Modificador del atributo atmosfera.
      * @param atm Modifica el valor del atributo atmosfera.
      */
     public void modificar_atmosfera(boolean atm){atmosfera = atm;}

     /**
      * Método Gravedad, calcula la constante gravitacional de dos cuerpos planetarios.
      * @param m1 recibe dos cuerpos planetarios
      * @param m2 recibe dos cuerpos planetarios
      * @return Devuelve la constante de atracción entre m1 y m2
      **/
     public double gravedad(cPlanetario m1, cPlanetario m2)
     {
	double ret = ((m1.mostrar_masa() * m2.mostrar_masa())/Math.abs(Math.pow((m1.mostrar_dsol() - m2.mostrar_dsol()), 2)))*gGravitacional;
	return ret;
     }
}
