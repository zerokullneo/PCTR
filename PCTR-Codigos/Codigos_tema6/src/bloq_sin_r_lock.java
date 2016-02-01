/**
 * @(#)bloq_sin_r_lock.java
 *
 *
 * @author Antonio Tomeu
 * @version 1.00 2011/5/2
 */


import java.util.concurrent.locks.*;

public class bloq_sin_r_lock {

	private int Valor_1;
	private int Valor_2;
	private final  ReentrantLock Cerrojo_1 = new ReentrantLock ();
	private final  ReentrantLock Cerrojo_2 = new ReentrantLock ();


    public int Observa_1 () {
    	Cerrojo_1.lock();
    	try {return (Valor_1);}
    	  finally {Cerrojo_1.unlock();}
    }
    public void Modifica_1 (int dato) {
    	Cerrojo_1.lock();
    	try{Valor_1 = dato;}
    	  finally {Cerrojo_1.unlock();}
    }
    public int Observa_2 () {
    	Cerrojo_2.lock();
    	try {return (Valor_2);}
    	  finally {Cerrojo_2.unlock();}
    }
    public void Modifica_2 (int dato) {
    	Cerrojo_2.lock();
    	try{Valor_2 = dato;}
    	  finally {Cerrojo_2.unlock();}
    }


    public bloq_sin_r_lock() {
    	Cerrojo_1.lock();
    	  Cerrojo_2.unlock();
    		try{Valor_1 = Valor_2 = 1;}
    		finally {Cerrojo_2.unlock();
    		         Cerrojo_1.unlock();}
    }

}

