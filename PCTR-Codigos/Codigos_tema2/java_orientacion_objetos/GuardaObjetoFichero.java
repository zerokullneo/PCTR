/**
 * @(#)GuardaObjetoFichero.java
 *
 *
 * @author Tomado de Allende et al.
 * @version 1.00 2011/10/14
 */

import java.io.*;
public class GuardaObjetoFichero{

public static void main(String[] args) 
   {
   	 Cuenta_Banca mi_cuenta = new Cuenta_Banca(72520, 23.14);
   	 Cuenta_Banca tu_cuenta = new Cuenta_Banca(002520, 2632.56);
     //esto guarda el objeto en un fichero...
     try{
     	 FileOutputStream fichero = new FileOutputStream("datos.dat");
     	 ObjectOutputStream sal   = new ObjectOutputStream(fichero);
     	 sal.writeObject (mi_cuenta);
     	 sal.writeObject (tu_cuenta);
     	 sal.close();
        } catch (FileNotFoundException e) {System.out.println("Error de creacion de fichero...");}
          catch (IOException e) {System.out.println("Error de E/S...");}
        
     //y esto lo recupera...   
      try{
     	 FileInputStream fichero  = new FileInputStream("datos.dat");
     	 ObjectInputStream ent    = new ObjectInputStream(fichero);
     	 Cuenta_Banca otra_cuenta = (Cuenta_Banca)ent.readObject();
     	 System.out.println(otra_cuenta.Saldo());
     	 ent.close();
        } catch (FileNotFoundException e) {System.out.println("Error de apertura de fichero...");}
          catch (IOException e) {System.out.println("Error de lectura...");}
          catch (ClassNotFoundException e) {System.out.println("Otros errores de E/S...");}
   }
}
