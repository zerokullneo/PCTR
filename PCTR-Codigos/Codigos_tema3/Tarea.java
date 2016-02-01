public class Tarea implements Runnable
{
  private int nVueltas = 10;
  private static int cHilos   =  0;
  public Tarea(){}
  public void run()
  {
    cHilos++; 	  
    for(int i=0; i<nVueltas;i ++)
      System.out.println("Hilo numero "+cHilos+ " imprimiendo...");
  }
}
