/**
 * @(#)ObjectoSerializados.java
 * @author Antonio Tomeu
 * @version 1.00 2011/10/5
 */

import java.io.*;
import java.util.*;

public class ObjectoSerializados {

    public static void main(String[] args) {
       try{
       	  FileOutputStream fich  = new FileOutputStream ("proof.dat");
       	  ObjectOutputStream sal = new ObjectOutputStream (fich);
       	  sal.writeObject("Hola, hoy es:");
       	  sal.writeObject(new Date());
       	  sal.close();
        } catch (IOException e) {System.out.println("Error de E/S...");}
       
       try{
       	  FileInputStream fich2  = new FileInputStream ("proof.dat");
       	  ObjectInputStream ent   = new ObjectInputStream (fich2);
       	  String cadena = (String)ent.readObject();
       	  Date   fecha  = (Date)ent.readObject();
       	  ent.close();
       	  System.out.println(cadena+fecha);
       } catch (FileNotFoundException e) {System.out.println("Fichero no encontrado...");}
         catch (IOException e) {System.out.println("Error de E/S...");}
         catch (Exception e) {System.out.println("Error de lectura de objeto...");}
    }
}
