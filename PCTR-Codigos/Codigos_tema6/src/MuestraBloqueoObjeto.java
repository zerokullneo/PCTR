/**
 * @(#)MuestraBloqueoObjeto.java
 * @author AT
 * @version 1.00 2011/11/3
 */

public class MuestraBloqueoObjeto {

   public synchronized void metodoA()
   {
   	for(int i=1;i<100;i++){
      System.out.println("Iteracion "+i+" del metodo A ");
      for(int j=1;j<100;j++);
   	}
   	System.out.println("metodo A liberando cerrojo...");
   }

   public synchronized void metodoB()
   {
   	for(int i=1;i<100;i++){
      System.out.println("Iteracion "+i+" del metodo B ");
      for(int j=1;j<100;j++);
   	}
   	System.out.println("metodo B liberando cerrojo...");
   }

}
