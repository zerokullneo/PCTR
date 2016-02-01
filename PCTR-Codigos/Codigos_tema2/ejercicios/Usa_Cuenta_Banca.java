/* Fichero Usa_Cuenta.java 
  *@author Jose Manuel Barba Gonzalez
  *@version 1.1
  *Programacion Concurrente y de Tiempo Real
  *Area de CC. de la Computacion e I.A.
*/

//import Cuenta_Banca.java.*;

public class Usa_Cuenta_Banca
{
	public static void main (String [] args)
	{
		Cuenta_Banca Antonio;
		Cuenta_Banca Juan = new Cuenta_Banca (32756821, 100000);
		Cuenta_Banca Jose, Manuel;

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

		//Creacion de las dos nuevas instancias
		Jose = new Cuenta_Banca(10100194,0);
		Manuel = new Cuenta_Banca(90440106,1000);

		//Visualizacion de la instancia Jose
		System.out.println ("Saldo actual de Jose: "+Jose.Saldo()+" en el numero de cuenta: "+Jose.Codigo());

		//Visualizacion de la instancia Manuel
		System.out.println ("Saldo actual de Manuel: "+Manuel.Saldo()+" en el numero de cuenta: "+Manuel.Codigo());

		//Operaciones de Ingreso en la primera cuenta y reintegro en la segunda cuenta
		Jose.Deposito(1500);
		Manuel.Reintegro(250);

		//Visualizacion de cambios
		System.out.println ("Saldo actual de Jose: "+Jose.Saldo()+" en el numero de cuenta: "+Jose.Codigo());
		System.out.println ("Saldo actual de Manuel: "+Manuel.Saldo()+" en el numero de cuenta: "+Manuel.Codigo());
	}
}
