/**
 * @author David Moreno Del Valle
 */


import java.util.*;
import java.net.*;
import java.rmi.*;

public class cBonoloto {

    public static void main(String[]args){
    	try{
	    	iBonoloto ORemoto = (iBonoloto)Naming.lookup("//localhost/Servidor");

	    	ORemoto.resetServidor();

	    	int [] a = new int[6];

	    	Scanner p = new Scanner(System.in);

	    	System.out.println("Introduce apuesta:");

	    	for(int i=0;i<6;i++){
	    		a[i] = p.nextInt();
	    	}
	    	boolean acierto = ORemoto.compApuesta(a);

	    	if(acierto){
	    		System.out.println("Apuesta premiada");
	    	}
	    	else{
	    		System.out.println("Apuesta no premiada");
	    	}
    	}catch(Exception e){System.out.println("Problema en cliente.");}
    	System.out.println("Cliente Terminado.");
    }


}
