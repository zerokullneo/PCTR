/**
 * @author David Moreno Del Valle
 */



import java.util.*;
import java.net.*;
import java.rmi.*;
import java.text.*;

public class cPrimos {

   public static void main(String[]args){
    	try{
	    	iPrimos OR1 = (iPrimos)Naming.lookup("//localhost/Servidor-1");
	    	iPrimos OR2 = (iPrimos)Naming.lookup("//localhost/Servidor-2");
	    	iPrimos OR3 = (iPrimos)Naming.lookup("//localhost/Servidor-3");
	    	iPrimos OR4 = (iPrimos)Naming.lookup("//localhost/Servidor-4");

	    int nNuc = Runtime.getRuntime().availableProcessors();
	    Scanner leer = new Scanner(System.in);
      	System.out.println("Introducir rango:");
      	int linf=leer.nextInt();//Limite inferior del rango
      	int lsup=leer.nextInt();//Limite inferior del rango
      	int Total = 0;
      	int tbloque = (int)(lsup-linf)/nNuc;//tBloque sera el rango de cada hilo
    	lsup = linf+tbloque;

    	iPrimos [] v = new iPrimos[nNuc];

    	v[0] = OR1;
    	v[1] = OR2;
    	v[2] = OR3;
    	v[3] = OR4;

    	Date d = new Date();//Objeto de la clase Date
      	DateFormat df = new SimpleDateFormat("HH:mm:ss:SSS");
      	long inicCronom = System.currentTimeMillis();//se prepara el cronometro
      	d.setTime(inicCronom);//activación del cronometro

		for(int i=0;i<v.length;i++){
    		Total += v[i].NumPrimos(linf,lsup);
    		linf=lsup;
    		lsup = lsup+tbloque;
    	}

    	long finCronom = System.currentTimeMillis();//se detiene el cronometro
      d.setTime(finCronom);
      System.out.println("En el rango especificado hay "+Total+" numeros primos...");
      System.out.println("Tiempo total de analisis:" + (finCronom - inicCronom) + " milisegundos");
    }catch(Exception e){}

}
}
