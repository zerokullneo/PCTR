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

/**Fichero Semaforo.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class Semaforo
{
     public enum Color{ROJO,AMBAR,VERDE};
     private Color color;
     private boolean boton;

     /**
      * Constructor especificando los parametros de Semaforo.
      * @param colur
      * @param btn 
      */
     public Semaforo(Color colur, boolean btn)
     {
	color = colur;
	boton = btn;
     }

     /**
      * Metodo observador del atributo color.
      * @return Devuelve el atributo color.
      */
     public Color mostrar_color(){ return color; }

     /**
      * Metodo observador del atributo boton.
      * @return Devuelve el atributo boton.
      */
     public boolean mostrar_boton(){ return boton; }

     /**
      * Metodo modificador del atributo color.
      * @param colur Recibe el nuevo estado del Semaforo.
      */
     public void modificar_color(Color colur)
     {
	switch(colur)
	{
	     case ROJO:
		color = colur;
		break;
	     case AMBAR:
		color = colur;
		break;
	     case VERDE:
		color = colur;
		break;
	}
     }

     /**
      * Modifica el estado del boton, si se pulsa cambia el estado.
      */
     public void modificar_boton()
     {
	if(boton == false)
	     boton = true;
	else
	     boton = false;
     }
}
