/**
 * @(#)UsoArchivosRAF.java
 * @author AT
 * @version 1.00 2011/10/20
 */

import java.io.*;
public class UsoArchivosRAF {
        
    public static void main(String[] args) {
        char    c;
        boolean Eof = false;
        RandomAccessFile Fichero = null;
        
        try{
        	Fichero = new RandomAccessFile("proof.txt", "rw");
        	System.out.println("Archivo creado...");
        	do{
        	   try{
        	        c = (char)Fichero.readByte();
        	        if(c=='b'){
        		         Fichero.seek(Fichero.getFilePointer()-1);
        		         Fichero.writeByte(Character.toUpperCase(c));}
        	       } catch (EOFException e){
        				   Eof = true;
        				   Fichero.close();
        				   System.out.println("Convertidas b a 						             mayusculas");
        				  }
        	  } while (!Eof);
        	} catch (FileNotFoundException e){System.out.println("Fichero no encontrado...");}
            catch (IOException e){System.out.println("Error de lectura-escritura...");}
     
    }
}

