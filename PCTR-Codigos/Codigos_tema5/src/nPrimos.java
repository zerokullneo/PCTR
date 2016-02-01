/**
 * @(#)nPrimos.java
 * @author A.T.
 * @version 1.00 2012/11/19
 */

import java.util.*;
import java.text.*;
public class nPrimos 
{
   public static int nTotal = 0;
	
   public static boolean esPrimo(int n)
   {
   	if(n<=1)return(false);
   	for(int i=2; i<=Math.sqrt(n);i++)
   	  if(n%i==0)return(false);
   	return(true);
   }	       
    
    public static void main(String[] args) 
    {
      Scanner p = new Scanner(System.in);
      System.out.println("Introducir rango:"); 
      int lInf=p.nextInt();	
      int lSup=p.nextInt();	
      Date d = new Date();
      DateFormat df = new SimpleDateFormat("HH:mm:ss:SSS");
      long inicCronom = System.currentTimeMillis();
      d.setTime(inicCronom);	
      for(int i=lInf;i<=lSup; i++)
      	if(esPrimo(i))nTotal++;	
      long finCronom = System.currentTimeMillis();
      d.setTime(finCronom);		
      System.out.println("En el rango especificado hay "+nTotal+" numeros primos...");	
      System.out.println("Tiempo total de analisis:" + (finCronom - inicCronom) + " milisegundos");	
    }
}
