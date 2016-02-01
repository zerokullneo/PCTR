/* Fichero Usa_Cuenta_2.java 
  *@author Antonio J. Tomeu
  *@version 1.0 
  *Dpto. Lenguajes y Sistemas Informáticos
  *Área de CC. de la Computación e I.A.
  *Ejemplo de uso de arrays de objetos...
*/

public class Usa_Cuenta_2
{
  private static int Num_Clientes = 3;

  static void Muestra_Cuentas (Cuenta_Banca [] Cuentas)
  {int i;
    System.out.println ("Numero de Cuenta"+"  "+"Disponible");
    for(i=0;i<Cuentas.length;i++){
      System.out.println (Cuentas [i].Codigo()+"            "+Cuentas[i].Saldo());}
  }
  
    public static void main (String [] args)
  {
    //Se crea un array con la lista de clientes;
    //Cada celda del array es un objeto de la clase Cuenta_Banca;
    Cuenta_Banca [] Clientes = new Cuenta_Banca [Num_Clientes];
    //Se inicializan algunos objetos del array;
    Clientes [0] = new Cuenta_Banca (45072253, 10000);
    Clientes [1] = new Cuenta_Banca (32074263, 1000);
    Clientes [2] = new Cuenta_Banca (75395412, 25394);
    //Se muestra el estado de las cuentas;
    Muestra_Cuentas(Clientes);
  }
}
