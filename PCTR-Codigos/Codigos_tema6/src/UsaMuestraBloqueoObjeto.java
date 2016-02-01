/**
 * @(#)UsaMuestraBloqueoObjeto.java
 * @author AT
 * @version 1.00 2011/11/3
 */

public class UsaMuestraBloqueoObjeto
  implements Runnable
{
	private MuestraBloqueoObjeto p;
	private int caso;
    public UsaMuestraBloqueoObjeto(MuestraBloqueoObjeto o, int val)
    {p=o; caso=val;}

    public void run()
    {
    	switch(caso){
    	  case 0: p.metodoA();
    	  case 1: p.metodoB();
    	}
    }

    public static void main(String[] args)
    {
      MuestraBloqueoObjeto monitor = new MuestraBloqueoObjeto();
      Thread h1 = new Thread(new UsaMuestraBloqueoObjeto(monitor,0));
      Thread h2 = new Thread(new UsaMuestraBloqueoObjeto(monitor,1));
      h1.start();
      h2.start();
    }
}
