/**
 * @(#)nNucleos.java
 * @author A.T.
 * @version 1.00 2012/11/19
 */

import java.util.*;
public class nNucleos {
    
    public static void main(String[] args) 
    {
    	int nNuc = Runtime.getRuntime().availableProcessors();
    	float Cb;
        System.out.println("Hay "+nNuc+" nucleos disponibles...");
        System.out.println("Coeficiente de Bloqueo?");
        Scanner p = new Scanner(System.in);
        Cb = p.nextFloat();
        System.out.println("Con su coeficiente de bloqueo el programa debe tener "+nNuc/(1-Cb)+ " hilos");
    }
}
