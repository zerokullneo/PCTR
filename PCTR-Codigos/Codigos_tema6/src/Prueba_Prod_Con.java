	  class Productor implements Runnable {
	  	
      private Buffer bb = null;
      
      public Productor (Buffer bb) {
        this.bb = bb;
      }
      
      public void run() {
        double item = 0.0;
        while (true) {
          bb.insertar (++item);
          System.out.println("Produciendo " + item);
        }
      }
    }//Productor
    
    class Consumidor implements Runnable {
    	
      private Buffer bb = null;
      public Consumidor (Buffer bb) {
        this.bb = bb;
      }
      
      public void run() {
        double item;
        while (true) {
          item = bb.extraer ();
          System.out.println("Consumiendo " + item);
        }
      }
      
    }//Consumidor
    
    public class Prueba_Prod_Con
    {
    	public static void main (String [] args)
    	{
    		int ranuras = 10;
    		Buffer monitor = new Buffer (ranuras);
    		
    		new Thread(new Productor(monitor)).start();
    		new Thread(new Consumidor(monitor)).start();
    		
    	}//main	
    }//Prueba_Prod_Con	