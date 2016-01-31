/**
 * @author David Moreno Del Valle
 */


import java.util.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.rmi.*;
import java.net.*;

public class sPrimos extends UnicastRemoteObject implements iPrimos {

   public static int nTotal = 0;
   public int li;//Limite inferior
   public int ls;//Limite superior

   public sPrimos() throws RemoteException {
    	super();
    }

   public boolean esPrimo(int n) throws RemoteException
   {
   	if(n<=1)return(false);
   	for(int i=2; i<=Math.sqrt(n);i++)
   	  if(n%i==0)return(false);
   	return(true);
   }

   public int NumPrimos(int li, int ls) throws RemoteException{
   	nTotal = 0;
   	 for(int i=li;i<=ls;i++){
    		if(esPrimo(i)){
    			nTotal++;
    		}
      	}
    	return nTotal;

   }

   public static void main(String[]args){

    	try{
    		iPrimos OR1 = new sPrimos();
    		iPrimos OR2 = new sPrimos();
    		iPrimos OR3 = new sPrimos();
    		iPrimos OR4 = new sPrimos();
    		Naming.bind("Servidor-1", OR1);
    		System.out.println("Servidor 1 preparado");
    		Naming.bind("Servidor-2", OR2);
    		System.out.println("Servidor 2 preparado");
    		Naming.bind("Servidor-3", OR3);
    		System.out.println("Servidor 3 preparado");
    		Naming.bind("Servidor-4", OR4);
			System.out.println("Servidor 4 preparado");
    	}catch (Exception e){
    		System.out.println("Problemas en el servidor.");
    	}
    }
}
