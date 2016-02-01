/**
 * @(#)Ejemplo_Bloques_Sincronizados.java
 *
 *
 * @author Antonio Tomeu
 * @version 1.00 2011/4/27
 */


public class Ejemplo_Bloques_Sincronizados {

	private int Valor_1;
	private int Valor_2;
	protected Object Cerrojo_1 = new Object ();
	protected Object Cerrojo_2 = new Object ();

    public int Observa_1 () {
    	synchronized (Cerrojo_1){
    		return (Valor_1);
    	}
    }

    public void Modifica_1 (int dato) {
    	synchronized (Cerrojo_1){
    		Valor_1 = dato;
    	}
    }

    public void Modifica_2 (int dato) {
    	synchronized (Cerrojo_2){
    		Valor_2 = dato;
    	}
    }

    public int Observa_2 () {
    	synchronized (Cerrojo_2){
    		return (Valor_2);
    	}
    }

    public Ejemplo_Bloques_Sincronizados() {
    	synchronized (Cerrojo_1){
    		synchronized (Cerrojo_2){
    		  Valor_1 = Valor_2 = 1;
    		}
    	}
    }

}