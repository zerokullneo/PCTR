/**Ejemplo de autocontrol interno de un hilo
 * Muestra la creacion y ejecución concurrente de varios hilos
 * @author Antonio Tomeu
 */
 
 import java.io.*;
 public class AutoControl extends Thread
 {
 	private int Vueltas;
 	
 	public AutoControl(int Dato)
 	{Vueltas=Dato;}
 	
 	public void run()
 	{ //el uso de sleep exige capturar la posible excepcion. 
 	  try{                   
 		for(int i=1; i<=Vueltas; i++){
 		  System.out.println(i);	
 		  if(i==100){
 		  	System.out.println("Suspension durante un segundo");
 		  	int timeout = 1000;
 		    sleep(timeout);
 		    System.out.println("Continuando");
 		  }//if  
 		}//for  
 	  }catch (InterruptedException e) {return;}
 	}
 
    public static void main(String[] args)
    {
    	new AutoControl(50).start();
    	new AutoControl(150).start();
    }		
 }		    	
 