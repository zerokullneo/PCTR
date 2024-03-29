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

/**Fichero EjemploRMI0.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */
import java.rmi.*;
import java.rmi.server.*;
/**Descripcion
 * el servidor debe siempre extender esta clase
 * el servidor debe simpre implementar la interfaz
 * remota definida con caracter previo
 */
public class EjemploRMI0 extends UnicastRemoteObject implements IEjemploRMI0
{
     public EjemploRMI0() throws RemoteException
     {
	super();
     }
     public String Hola_Mundo ()throws RemoteException
     {
	return "Hola Mundo cruel...";
     }
}
