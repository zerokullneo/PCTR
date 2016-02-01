//Antonio J. Tomeu
//Dpto. Lenguajes y Sistemas Informaticos
//Area de CC. de la Computacion e I.A.
//Fichero Minuscula.java
//Ilustra el uso de los flujos de E/S basicos... y de algunos metodos de la clase System

import java.io.*;
class Minuscula
{
  public static void main (String [] args)
    throws IOException
  {

    int i;
    int dato;

    //esto fuerza la recoleccion de basura
     System.gc();
     //muestra el tiempo actual en milisegundos
     System.out.println(System.currentTimeMillis());
     //muestra propiedades del sistema
     System.out.println(System.getProperties());
     System.out.println("Introduzca un caracter...");
    do
    {
      i=System.in.read();
      dato = Character.toLowerCase((char) i);
      System.out.write (dato);

    } while (true); //cuando quiera salir haga CTRL-B, en el entorno de JCreator o CTRL-C desde un shell


  }

}