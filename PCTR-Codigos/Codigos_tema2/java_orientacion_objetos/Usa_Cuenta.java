/* Fichero Usa_Cuenta.java 
  *@author Antonio J. Tomeu
  *@version 1.0 
  *Dpto. Lenguajes y Sistemas Informáticos
  *Área de CC. de la Computación e I.A.
  *Ejemplo de uso de una clase predefinida...
*/


public class Usa_Cuenta
{
 public static void main (String [] args)
 {Cuenta_Banca Antonio;
  Cuenta_Banca Juan = new Cuenta_Banca (32756821, 100000);

  Juan.Deposito (25000);
  //Se muestra el nuevo saldo de la cuenta de Juan;
  System.out.println ("El saldo de Juan es:"+Juan.Saldo());

  //Se crea la cuenta de Antonio;
  Antonio = new Cuenta_Banca (45073256, 25000);

  //Se muestra el codigo de la cuenta de Antonio;
  System.out.println ("El codigo de Antonio es:"+Antonio.Codigo());

  //Antonio hace un reintegro por valor de 2000 y se muestra el saldo;
  Antonio.Reintegro(2000);
  System.out.println ("Nuevo saldo de Antonio: "+Antonio.Saldo());
 }
}
