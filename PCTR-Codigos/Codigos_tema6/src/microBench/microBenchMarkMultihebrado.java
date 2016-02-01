/*
 *@author A.T.
 *@date 21-03-2013
*/

import java.util.concurrent.atomic.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

class Datos
{
  public static int  TAM   = 0;
  public static AtomicInteger tam = new AtomicInteger(0);
  
  public Datos(){}
  
  public void inc(){TAM++;}
  public int get(){return(TAM);}
  public void setCero(){TAM=0;}
} 
  
public class microBenchMarkMultihebrado
  implements Runnable
{
   private static Object        o = new Object();
   private static ReentrantLock l = new ReentrantLock();
   private int tipoHilo;
   static Datos d = new Datos();
   public microBenchMarkMultihebrado(int tipo){tipoHilo=tipo;}
   public void run()
   {
     switch(tipoHilo){
       case 0:{for(int i=0; i<100000;i++){synchronized(o){int l=d.get();}}break;}
       case 1:{for(int i=0; i<100000;i++){synchronized(o){d.inc();}}break;}
       case 2:{for(int i=0; i<100000;i++){l.lock();int p=d.get();l.unlock();}break;}
       case 3:{for(int i=0; i<100000;i++){l.lock();d.inc();l.unlock();}break;}
       case 4:{for(int i=0; i<100000;i++){int q=d.tam.get();break;}}
       case 5:{for(int i=0; i<100000;i++){int q=d.tam.incrementAndGet();break;}}	       
     }	     
   }	   
   
  public static void main(String[] args)
  {
    
    
    ExecutorService ejecutor = Executors.newFixedThreadPool(5);
    long inic=System.nanoTime();
    ejecutor.execute(new  microBenchMarkMultihebrado(0));
    ejecutor.execute(new  microBenchMarkMultihebrado(0));
    ejecutor.execute(new  microBenchMarkMultihebrado(1));
    ejecutor.execute(new  microBenchMarkMultihebrado(1));
    ejecutor.execute(new  microBenchMarkMultihebrado(1));
    long tiempoSincronizado = System.nanoTime()-inic;
    d.setCero();
    inic = System.nanoTime();
    ejecutor.execute(new  microBenchMarkMultihebrado(2));
    ejecutor.execute(new  microBenchMarkMultihebrado(2));
    ejecutor.execute(new  microBenchMarkMultihebrado(3));
    ejecutor.execute(new  microBenchMarkMultihebrado(3));
    ejecutor.execute(new  microBenchMarkMultihebrado(3));
    long tiempoCerrojoReentrante = System.nanoTime()-inic;
    inic = System.nanoTime();
    ejecutor.execute(new  microBenchMarkMultihebrado(4));
    ejecutor.execute(new  microBenchMarkMultihebrado(4));
    ejecutor.execute(new  microBenchMarkMultihebrado(5));
    ejecutor.execute(new  microBenchMarkMultihebrado(5));
    ejecutor.execute(new  microBenchMarkMultihebrado(5));
    long tiempoConAtomicos = System.nanoTime()-inic;
    ejecutor.shutdown();
    System.out.println("Tiempo con synchronized: "+tiempoSincronizado+" nanoseg.");
    System.out.println("Tiempo con ReentrantLock: "+tiempoCerrojoReentrante+" nanoseg.");
    System.out.println("Tiempo con Atomicos: "+tiempoConAtomicos+" nanoseg.");
    System.out.println("Relacion Lock/synchronized = "+(double)tiempoSincronizado/(double)tiempoCerrojoReentrante);
    System.out.println("Relacion Lock/Atomic = "+(double)tiempoCerrojoReentrante/(double)tiempoConAtomicos);
    System.out.println("Relacion Atomic/synchronized = "+(double)tiempoConAtomicos/(double)tiempoSincronizado);
    
  } 	   
}  

