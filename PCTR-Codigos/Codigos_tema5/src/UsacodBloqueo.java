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

/**Fichero UsacodBloqueo.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class UsacodBloqueo extends Thread
{
	codBloqueo cerrojo; //referencia a objeto compartido

	public UsacodBloqueo(codBloqueo l) {cerrojo = l;}

	public void run()
	{
		cerrojo.metodo(); //llamada a metodo que tiene codigo sincronizado
	}

	public static void main(String[] args)
	{
		codBloqueo aux = new codBloqueo(200);
		UsacodBloqueo h1 = new UsacodBloqueo(aux);
		UsacodBloqueo h2 = new UsacodBloqueo(aux);
		h2.start();
		h1.start();
	}

}
