/**
 * @(#)UsoArchivoRAF0.java
 * @author Antonio Tomeu
 * @version 1.00 2011/10/5
 */

    import java.io.*;
    public class UsoArchivoRAF0
    {
       public static void main(String[] args)
          throws Exception
       {
          System.out.println("Ahora experimentamos con un fichero RandomAccessFile");
          File ruta = new File("C:/antonio2.dat");
          try {
                  RandomAccessFile myfich = new RandomAccessFile(ruta, "rw");
                  for(int i=0;i<5;i++) myfich.writeInt(2*i);
                  myfich.close();
                  System.out.println("Fichero creado...");
               } catch (IOException e) {}
       try {
               RandomAccessFile myfich = new RandomAccessFile(ruta, "r");
               while(myfich.getFilePointer() <= myfich.length())
               System.out.println(myfich.readInt());
               myfich.close();
             } catch (EOFException e) {}   
       //pero el mismo archivo puede ser leido e interpretado como 
       //formado por objetos float   
       System.out.println("El fichero, leido como float...");
       try {
               RandomAccessFile myfich = new RandomAccessFile(ruta, "r");
               while(myfich.getFilePointer() <= myfich.length())
               System.out.println(myfich.readFloat());
               myfich.close();
             } catch (EOFException e) {}
       // tambien como caracteres
       System.out.println("El fichero, leido como char...");
       try {
               RandomAccessFile myfich = new RandomAccessFile(ruta, "r");
               while(myfich.getFilePointer() <= myfich.length())
               System.out.println(myfich.readChar());
               myfich.close();
             } catch (EOFException e) {}      
       //Ahora abrimos el RandomAccessFile como un fichero binario normal
       System.out.println("El fichero, leido mediante DataInput...");
       File myF = new File("C:/antonio2.dat");
       try{
             DataInputStream extern = new DataInputStream
             (new FileInputStream (myF));   
             for(;;)System.out.println(extern.readInt()); 
                    } catch (EOFException e) {}
            catch (FileNotFoundException e){}
       }//main
    }//class ClasesES3
