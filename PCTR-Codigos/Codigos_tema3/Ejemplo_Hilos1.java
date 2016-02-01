class Ejemplo_Hilos1 extends Thread

{
 public Ejemplo_Hilos1 (int Tope) //constructor
 {T = Tope;}
 
  public void run ()
  {
    for (int i = 1; i <= T; i++)
      System.out.println (i);
  }
  private int T ;
}