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

package practica11;

/**Fichero sLibro.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */
import java.util.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.rmi.*;
import java.net.*;
/**Descripcion
 * 
 */
public class sLibro extends UnicastRemoteObject implements iLibro{

	Libro [] BD = new Libro[5];
	private int op;
	private int cont = 0;

    public sLibro() throws RemoteException {
    	super();
    }


    public synchronized void insertar(Libro l) throws RemoteException{
    	if(cont==5){
    			System.out.println("Libreria llena.");
    	}
		else{
	    	System.out.println("Insertando libro....");
	    	BD[cont] = l;
	    	cont++;
	    	System.out.println("Libro insertado.");

		}

    }

	public synchronized void eliminar(Libro l) throws RemoteException{
		if(cont==0){
	    			System.out.println("Libreria vacia.");
	    	}
	    else{
	    	int p = cont;
	    	int enc = cont;
	       	for(int i=0;i<p;i++){
	    		if(l.VerTitulo().equals(BD[i].VerTitulo())){
	    			cont--;
	    			for(int j=i;j<p-1;j++){
	    				BD[j]=BD[j+1];
	    			}
	    		}
			}
			if(enc == cont){
				System.out.println("No existe el libro.");
			}
			else{
				System.out.println("Libro eliminado.");
			}
		}
	}

	public synchronized void consultarBD() throws RemoteException{
		System.out.println("BASE DE DATOS:");
		for(int i=0;i<cont;i++){
			System.out.println("TITULO: "+BD[i].VerTitulo());
			System.out.println("AUTOR: "+BD[i].VerAutor());
		}
	}

    public synchronized Libro consultarA(String A) throws RemoteException{
    	Libro lib = new Libro("Titulo inexistente", "Autor inexistente");
    	for(int i=0;i<cont;i++){
    		if(A.equals(BD[i].VerAutor())){
    			lib = BD[i];
    		}

    	}
		return lib;
    }

   	public synchronized Libro consultarN(String N) throws RemoteException{
   		Libro lib = new Libro("Titulo inexistente", "Autor inexistente");
    	for(int i=0;i<cont;i++){
    		if(N.equals(BD[i].VerTitulo())){
    			lib = BD[i];
    		}

    	}
		return lib;

   	}

	public static void main(String[]args){

    	try{
    		iLibro ORemoto = new sLibro();

    		Naming.bind("Servidor", ORemoto);
			System.out.println("Servidor preparado");

    	}catch (Exception e){
    		System.out.println("Problemas en el servidor.");
    	}
    }
}
