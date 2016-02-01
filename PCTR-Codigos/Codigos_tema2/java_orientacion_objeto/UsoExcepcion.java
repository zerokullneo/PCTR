/**
 * @(#)UsoExcepcion.java
  * @author Antonio Tomeu
 * @version 1.00 2011/10/5
 */

import java.io.*;

public class UsoExcepcion {         
    public static void main(String[] args) {
	  int num = -1;
	  int intentos = 0;
	  String linea;
	  
	  BufferedReader teclado = new BufferedReader (
	  					new InputStreamReader(System.in));
      
      do{
      	try{
      		System.out.println("Entrar numero en rango 0-100");
      		linea = teclado.readLine();
      		num= Integer.parseInt(linea);
      	}
      	catch (IOException e){System.out.println("Error de lectura de teclado");}
      	catch (NumberFormatException e) {System.out.println("El numero debe estar entre cero y 100");}
      	finally {intentos++;}
      }while (num < 0 || num  > 100);	  				
      System.out.println("El numero valido introducido fue: "+num);		
      System.out.println("Numero de intentos fue: "+intentos);	
    } 
}
