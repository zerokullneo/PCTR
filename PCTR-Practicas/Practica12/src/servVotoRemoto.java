/**
 * @author David Moreno Del Valle
 */


import java.util.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.rmi.*;
import java.net.*;

public class servVotoRemoto extends UnicastRemoteObject implements intVotoRemoto {

	int Votos = 0;
	int VotosSi = 0;
	int VotosNo = 0;
	int VotosNs = 0;

    public servVotoRemoto()throws RemoteException {}

    public void Votar(String v)throws RemoteException{
    	Votos++;
    	if(v.equals("si")){
    		VotosSi++;
    	}
    	else{
	    	if(v.equals("no")){
	    		VotosNo++;
	    	}
	    	else{
	    		VotosNs++;
	    	}
    	}

    }

    public int Votos() throws RemoteException{
    	return Votos;
    }
    public int VotosSi() throws RemoteException{
    	return VotosSi;
    }
    public int VotosNo() throws RemoteException{
    	return VotosNo;
    }
    public int VotosNs() throws RemoteException{
    	return VotosNs;
    }

     public static void main(String[]args){

    	try{
    		intVotoRemoto ORemoto = new servVotoRemoto();

    		Naming.bind("Servidor", ORemoto);
			System.out.println("Servidor preparado");

    	}catch (Exception e){
    		System.out.println("Problemas en el servidor.");
    	}
    }



}
