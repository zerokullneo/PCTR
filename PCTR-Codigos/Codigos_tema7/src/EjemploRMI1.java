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

/**Fichero EjemploRMI1.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;
/**Descripcion
 * el servidor debe siempre extender esta clase
 * el servidor debe simpre implementar la interfaz
 * remota definida con caracter previo
 */
public class EjemploRMI1 extends UnicastRemoteObject implements IEjemploRMI1
{

     /**
      *
      * @param x
      * @param y
      * @return
      * @throws RemoteException
      */
     @Override
     public int Suma(int x, int y) throws RemoteException
     {return x+y;}

     /**
      *
      * @param x
      * @param y
      * @return
      * @throws RemoteException
      */
     @Override
     public int Resta(int x, int y)throws RemoteException
     {return x-y;}
     
     /**
      *
      * @param x
      * @param y
      * @return
      * @throws RemoteException
      */
     @Override
     public int Producto(int x, int y) throws RemoteException
     {return x*y;}
     
     /**
      *
      * @param x
      * @param y
      * @return
      * @throws RemoteException
      */
     @Override
     public float Cociente(int x, int y) throws RemoteException
     {
	if(y == 0)
	     return 1f;
	else
	     return x/y;
     }

     //es necesario que haya un constructor (nulo) como minimo, ya que debe 
     //lanzar RemoteException
     public EjemploRMI1() throws RemoteException
     {//super(); invoca automaticamente al constructor de la superclase
	
     }

     //el metodo main siguiente realiza el registro del servicio
     public static void main(String[] args) throws Exception
     {
	//crea e instala un gestor de seguridad que soporte RMI.
	//el usado es distribuido con JDK. Otros son posibles.
	//En esta ocasion trabajamos sin el.
	System.setSecurityManager(new RMISecurityManager());

	//Se crea el objeto remoto. Podriamos crear mas si interesa.
 	IEjemploRMI1 ORemoto = new EjemploRMI1();
	//Se registra el servicio
	Naming.bind("Servidor", ORemoto);
	System.out.println("Servidor Remoto Preparado");
     }
}
