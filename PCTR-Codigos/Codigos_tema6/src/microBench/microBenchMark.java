/*
 *@author A.T.
 *@date 21-03-2013
*/

import java.util.concurrent.locks.*;

abstract class Incrementadora {
protected long cont = 0;
public abstract void inc();
}

class pruebaSincronizado extends Incrementadora {
public synchronized void inc() { ++cont; }
}

class pruebaCerrojoReentrante extends Incrementadora {
private Lock l = new ReentrantLock();

 public void inc() 
 {
  l.lock();
  try {
    ++cont;
  } finally {l.unlock();
 }
}
}

public class microBenchMark 
{
  static long test(Incrementadora r) 
  {
   long inic = System.nanoTime();
   for(long i = 0; i < 100000L; i++)
   r.inc();
   return (System.nanoTime() - inic);
 }
 
public static void main(String[] args) 
{
  long tiempoSincronizado      = test(new pruebaSincronizado());
  long tiempoCerrojoReentrante = test(new pruebaCerrojoReentrante());
  System.out.println("Tiempo con synchronized: "+tiempoSincronizado);
  System.out.println("Tiempo con ReentrantLock:"+ tiempoCerrojoReentrante);
  System.out.println("Relacion Lock/synchronized = "+(double)tiempoSincronizado/(double)tiempoCerrojoReentrante);
 }
} 
