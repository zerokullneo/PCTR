/**
 * @author David Moreno Del Valle
 */


import java.util.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.rmi.*;
import java.net.*;

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
