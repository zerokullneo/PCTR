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

import java.util.*;
import java.io.*;
import java.util.concurrent.*;

/**Fichero Conductores.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class Conductores implements Callable 
{
     static ArrayList<Conductor> conductores = new ArrayList<Conductor>(100);
     static int op;
     
     /**
      * Constructor de Conductores vacio.
      */
     public Conductores()
     {
	conductores = new ArrayList<Conductor>(10);
     }

     /**
      * Constructor de Conductores con parametros.
      * @param c Parametro que contiene un array de Conductores previamente
      * creado.
      * @param tam Parametro con el tamaño del array de Conductores.
      */
     public Conductores(ArrayList<Conductor> c, int tam)
     {
	conductores = new ArrayList<Conductor>(tam);
	for (int i = 0; i < conductores.size(); i++)
	     conductores.add(i,c.get(c.iterator().next().mostrarID()));
     }

     /**
      * Metodo que inserta un nuevo conductor a la lista.
      * @param c Parametro que contiene un Conductor a añadir a la lista.
      */
     public synchronized static void Insertar(Conductor c)
     {
	conductores.add(c);
     }
     
     /**
      * Metodo que elimena un conductor de la lista.
      * @param c Parametro que contiene id de Conductor a eliminar de la lista.
      */
     public synchronized static void Eliminar(int c)
     {
	conductores.remove(c);
     }

     /**
      * Metodo que busca un conductor de la lista.
      * @param ident Parametro que contiene un identificador a buscar,
      * puede ser el id o el dni(digitos).
      * @param op Parametro que indica el tipo de identificador introducido,
      * 1 para el id, 2 para dni(digitos).
      * @return Devuolve el objeto conductor encontrado por la funcion, nullptr
      * si no encuentra.
      */
     public synchronized static Conductor Buscar(int ident, int op)
     {
	Iterator<Conductor> it = conductores.iterator();

	switch(op)
	{
	     case 1:
		try
		{
		     conductores.get(ident).toString();
		     return conductores.get(ident);
		}
		catch(Exception e)
		{
		     System.out.println("Error busqueda ID..." + e);
		     return null;
		}
	     case 2:
		try
		{
		     while(it.hasNext())
		     {
			if(it.next().mostrar_digitosDNI() == ident)// c.getDni().equals(dni)
			     conductores.get(it.next().mostrarID()).toString();
		     }
		     return it.next();
		}
		catch(Exception e)
		{
		     System.out.println("Error busqueda DNI..." + e);
		     return null;
		}
	     default:
		System.out.println("Opcion Incorrecta.");
		return null;
	}
     }

     /**
      * Metodo call() que controla la exclusion mutua del estado del arraylist.
      * @param c Parametro que contiene un Conductor a añadir a la lista.
      * @param operador Parametro que contiene la opcion a realizar.
      * @param tipo Parametro que contiene la subopcion a realizar.
      * @return Devuelve el arraylist modificado.
      */
     public Conductores call(Conductor c,int operador, int tipo)
     {
	op=tipo;
	switch(operador)
	{
	     case 1:
		Insertar(c);
		return this;
	     case 2:
		System.out.println(op);
		Eliminar(op);
		return this;
	     case 3:
		System.out.println(c.mostrarID() + "-" + operador + "-" + op);
		if(op == 1)
		     Buscar(c.mostrarID(), op);
		else
		     Buscar(c.mostrar_digitosDNI(),op);
		return this;
//	     case 4:
//		C.Modificar(c);
//		return true;
	     default:
		return this;
	}
     }

     @Override
     public Object call() throws Exception
     {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }
}
