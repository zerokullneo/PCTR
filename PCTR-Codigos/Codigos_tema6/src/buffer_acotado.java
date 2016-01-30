/**
 * @(#)buffer_acotado.java
 *
 *
 * @author
 * @version 1.00 2011/5/3
 */

import java.util.concurrent.locks.*;

class buffer_acotado {
   final Lock cerrojo = new ReentrantLock();
   final Condition noLlena  = cerrojo.newCondition();
   final Condition noVacia  = cerrojo.newCondition();

   final Object[] items = new Object[100];
   int putptr, takeptr, cont;

   public void put(Object x) throws InterruptedException {
     cerrojo.lock();
     try {
       while (cont == items.length)
         noLlena.await();
       items[putptr] = x;
       if (++putptr == items.length) putptr = 0;
       ++cont;
       noVacia.signal();
     } finally {
       cerrojo.unlock();
     }
   }

   public Object take() throws InterruptedException {
     cerrojo.lock();
     try {
       while (cont == 0)
         noVacia.await();
       Object x = items[takeptr];
       if (++takeptr == items.length) takeptr = 0;
       --cont;
       noLlena.signal();
       return x;
     } finally {
       cerrojo.unlock();
     }
   }
 }