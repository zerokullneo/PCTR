/**
 * @(#)usaAyB.java
 *
 *
 * @author AT
 * @version 1.00 2011/10/12
 */

import mipaquete.clasePaquete;
public class usaPaqueteyPaquete2 {


    public static void main(String[] args) {
       //para usar las clase de mi paquete modemos importarlas y usarlas...
       clasePaquete  A = new clasePaquete();
       //o bien utilizar su nombre completo incluyendo el prefijo mipaquete...
       mipaquete.clasePaquete_2 B = new mipaquete.clasePaquete_2();
       System.out.println(A.toString());
       System.out.println(B.toString());

    }
}
