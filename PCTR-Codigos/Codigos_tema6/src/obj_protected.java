/**
 * @(#)obj_protected.java
 *
 *
 * @author Antonio Tomeu
 * @version 1.00 2011/4/28
 */


public class obj_protected {

	public obj_protected() {}

    public synchronized void m1 ()
    {
    	System.out.println ("Método 1 ejecutando codigo sincronizado");

    }

    public synchronized void m2 ()
    {
    	System.out.println ("Método 2 ejecutando codigo sincronizado");
    	this.m1();
    	System.out.println ("Método 2 terminando ejecución codigo sincronizado");

    }

}