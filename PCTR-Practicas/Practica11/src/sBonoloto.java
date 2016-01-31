/**
 * @author David Moreno Del Valle
 */


import java.util.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.rmi.*;
import java.net.*;

public class sBonoloto extends UnicastRemoteObject implements iBonoloto {

	public int [] Apuesta = new int[6];
	private final int nNumeros = 49;

    public sBonoloto() throws RemoteException {
    	super();
    }

    public void resetServidor() throws RemoteException{

    	 Random p = new Random();

    	 for(int i=0;i<Apuesta.length;i++){
    	 	int n = p.nextInt(nNumeros);
    	 	Apuesta[i] = n+1;
    	 	System.out.println(Apuesta[i]);
    	 }
    }

    public boolean compApuesta(int[] apuesta)  throws RemoteException{
    	Arrays.sort(Apuesta);
    	Arrays.sort(apuesta);

    	for(int i=0;i<Apuesta.length;i++){
    		if(Apuesta[i]!=apuesta[i]){
    			return false;
    			}
    	}
    		return true;
    	}

    public static void main(String[]args){

    	try{
    		iBonoloto ORemoto = new sBonoloto();

    		Naming.bind("Servidor", ORemoto);

    		System.out.println("Servidor preparado");
    	}catch (Exception e){
    		System.out.println("Problemas en el servidor.");
    	}
    }

}
