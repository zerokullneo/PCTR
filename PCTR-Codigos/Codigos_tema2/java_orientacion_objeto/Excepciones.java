/* Fichero Excepciones.java 
  *@author Antonio J. Tomeu
  *@version 1.0 
  *Dpto. Lenguajes y Sistemas Informáticos
  *Área de CC. de la Computación e I.A.
  *Ejemplo de uso de excepciones...
*/

import java.io.*;

public class Excepciones
{
  static void Copia (FileInputStream Entrada, FileOutputStream Salida)
  {
    int i, c;
    try {
      while ((c = Entrada.read ())>=0) {
        c = Character.toLowerCase ((char) c);
        Salida.write (c);
      }//while
      Entrada.close ();
      Salida.close ();
    } //try
      catch (IOException e){
        System.err.println ("Problema de E/S");    
        System.err.println (e.getMessage ());
        System.exit (1);
      }// catch  
  }//Copia
  
  public static void main (String [] Ficheros)
    {
      if(Ficheros.length != 2) {
        System.err.println("Dos nombres de fichero de argumento");
        System.exit (1);
      }//if
      try {
        FileInputStream  Entra = new FileInputStream (Ficheros [0]);  
        FileOutputStream Sale  = new FileOutputStream (Ficheros [1]);  
        Copia (Entra, Sale);
      }//try
     catch (FileNotFoundException e){
       System.err.println ("Fichero no encontrado...");    
       System.err.println (e.getMessage ());
       System.exit (1);
     }// catch	
     catch (IOException e){
       System.err.println ("Problema de E/S");    
       System.err.println (e.getMessage ());
       System.exit (1);
     }// catch	     
  }//main
}//Excepciones  	
  	
