/**
 * @(#)Prioridades.java
 * @author AT
 * @version 1.00 2011/11/2
 */

public class Prioridades 
  extends Thread
{
	private long dato;
	private static int aux = 5;
    private long fac(long n)
    {
    	if (n == 0) return 0;
    	else if (n == 1) return 1;
    	  else return(fac(n-1)*n);
    }
    
    public Prioridades(long n)
    {dato=n;}
       
    public void run()
    { 
      //this.setPriority(aux++);
      System.out.println("El factorial de "+dato+" es "+fac(dato));
    }
   
    public static void main(String[] args) 
    {
        new Prioridades(10).start();
        new Prioridades(20).start();
        new Prioridades(30).start();
        new Prioridades(40).start();
        new Prioridades(50).start();
        new Prioridades(60).start();
    }
}
