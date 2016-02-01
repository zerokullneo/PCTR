/* Fichero Sobrecarga.java 
  *@author Antonio J. Tomeu
  *@version 1.0 
  *Dpto. Lenguajes y Sistemas Informáticos
  *Área de CC. de la Computación e I.A.
  *Ejemplo de sobrecarga de metodos...
*/

public class Sobrecarga 
{
  public static int Suma (int x, int y)
  {return x+y;}

  public static float Suma (float x, float y)
  {return x+y;}

  public static double Suma (double x, double y)
  {return x+y;}
  
  public static String Suma ()
  {return "En un lugar de la Mancha...";}

  public static void main (String[] args)
  {
    System.out.println(Suma(2,3));
    System.out.println(Suma(2.0,3.0));
    System.out.println(Suma(2.0,3.0));
    System.out.println(Suma());
    
  }

}
