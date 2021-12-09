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
import java.util.concurrent.*;

/**Fichero usaConductores.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class usaConductores extends Conductores
{
     private static int ident;
     public static Conductor cond;

     /**
      * Funcion que muestra el menu principal y guarda la opcion elegida.
      * @return Devuelve la opcion elegida.
      */
     public static int Menu()
     {
	Scanner sc = new Scanner(System.in);
	System.out.println("Menu");
	System.out.println("1.- Nuevo Conductor");
	System.out.println("2.- Borrar Conductor");
	System.out.println("3.- Consultar Conductor");
	System.out.println("0.- Salir");
	return sc.nextInt();
     }
     
     /**
      * Funcion que muestra el menu para crear un nuevo conductor.
      * @return Devuelve el objeto Conductor creado por el constructor.
      */
     public static Conductor MenuNuevoC()
     {
	Scanner datos = new Scanner(System.in);
	
	System.out.print("Identificador: ");
	int i = datos.nextInt();
	System.out.print("Digitos DNI: ");
	int d = datos.nextInt();
	System.out.print("Letra DNI: ");
	String l = datos.next();
	System.out.print("Nombre: ");
	String n = datos.next();
	System.out.print("Apellidos: ");
	String a = datos.next();
	System.out.print("Matricula: ");
	String m = datos.next();
	
	return new Conductor(i,n,a,m,d,l);
     }

     /**
      * Funcion que muestra el menu para eliminar un Conductor.
      * @return Devuelve el objeto Conductor referenciado por Buscar().
      */
     public static int MenuEliminaC()
     {
	Scanner datos = new Scanner(System.in);
	System.out.print("Identificador: ");
	int i = datos.nextInt();

	return i;
     }
     
     /**
      * Funcion que muestra el menu de Consulta de un Conductor.
      * @return Devuelve el objeto Conductor referenciado por Buscar().
      */
     public static int MenuConsultaC()
     {
	Scanner datos = new Scanner(System.in);
	System.out.print("Buscar por Identificador, pulse 1 \nBuscar por DNI, pulse 2: ");
	int opt = datos.nextInt();

	if(opt == 1)
	{
	     System.out.print("Introducir el Identificador: ");
	     ident = datos.nextInt();
	     cond = new Conductor(ident, "", "", "", ident,"");
	     return opt;
	}
	else
	{
	     System.out.print("Introducir digitos del DNI: ");
	     ident = datos.nextInt();
	     cond = new Conductor(ident, "", "", "", ident,"");
	     return opt;
	}
     }
     
     public static void main(String[] args) throws InterruptedException
     {
	int nNuc = Runtime.getRuntime().availableProcessors();
	ExecutorService ept = Executors.newFixedThreadPool(nNuc);
	Set<Future<Conductores>> set = new HashSet<Future<Conductores>>();
	int opcion;
	Conductores ListaConductores = new Conductores();

	do
	{
	     opcion = Menu();
	     switch(opcion)
	     {
		case 1:
		     Conductor cn = MenuNuevoC();
		     Callable<Conductores> inserta = ListaConductores.call(cn, opcion,0); //Conductores(cn,opcion);
		     Future<Conductores> finserta = ept.submit(inserta);
		     set.add(finserta);
		     break;
		case 2:
		     int ce = MenuEliminaC();
		     Callable<Conductores> elimina = ListaConductores.call(cond, opcion, ce);
		     Future<Conductores> felimina = ept.submit(elimina);
		     set.add(felimina);
		     break;
		case 3:
		     int cv = MenuConsultaC();
		     Callable<Conductores> consulta = ListaConductores.call(cond, opcion, cv);
		     Future<Conductores> fconsulta = ept.submit(consulta);
		     set.add(fconsulta);
		     break;
		case 0:
		     break;
	     }
	}while(opcion != 0);

	ept.shutdown();
	ept.shutdownNow();
	ept.awaitTermination(nNuc, TimeUnit.SECONDS);
     }
}
