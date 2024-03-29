  /**
 * @(#)EjecutorHiloSimple.java
 * @author AT
 * @version 1.00 2011/11/10
 */
 
  import java.util.concurrent.*;

  class Tarea implements Runnable{
    public static int cont = 0;
    
    public Tarea(){}
    public void run(){
      for(int i=0; i<1000000; i++) cont++;
    }  
  }

  public class EjecutorHiloSimple{
    public static void main(String[] args) throws Exception{
      ExecutorService ejecutor =	 		   Executors.newSingleThreadExecutor();
      for(int i=0; i<1000; i++)
	ejecutor.execute(new Tarea());
      ejecutor.shutdown(); 
      while(!ejecutor.isTerminated()){}
      System.out.println(Tarea.cont);
    }
  }
