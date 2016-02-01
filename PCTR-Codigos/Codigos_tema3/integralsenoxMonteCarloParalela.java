import java.lang.Math;
public class integralsenoxMonteCarloParalela
  extends Thread
{
  int nPuntos;	
  static int totalBajoCurva = 0;
  public integralsenoxMonteCarloParalela(int nPuntos){
    this.nPuntos =  nPuntos;	  
  } 	
	
  public void run(){
    for(int i=0; i<nPuntos; i++){
        double cx = Math.random();
        double cy = Math.random();
        if(cy<=Math.sin(cx))totalBajoCurva++;
      }	  
  }
   public static void main(String[] args) throws Exception
   {
      int numHilos = Integer.valueOf(args[0]).intValue(); 	   
      int intentos = Integer.valueOf(args[1]).intValue();
      integralsenoxMonteCarloParalela [] h = new integralsenoxMonteCarloParalela[numHilos];
      for(int i=0; i<h.length; i++)h[i] = new integralsenoxMonteCarloParalela(intentos);
      for(int i=0; i<h.length; i++)h[i].start();
      for(int i=0; i<h.length; i++)h[i].join();
      double valor=(double)(totalBajoCurva)/(intentos*numHilos);
      System.out.println(valor);
      
    }
}
