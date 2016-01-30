/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
         
/**
 *
 * @author Jose Manuel Barba Gonzalez <zk at wordpress.com>
 */
public class Cuenta_Banca
{
     private int Codigo_Cuenta;      //Codigo Cuenta Cliente
     private double Saldo_Cuenta;   //Saldo Actual

     public Cuenta_Banca(){} //constructor nulo

     public Cuenta_Banca(int id, double disponible) //constructor  
     {
	Codigo_Cuenta = id;
	Saldo_Cuenta = disponible;
     }

     //observador
     public double  Saldo(){return (Saldo_Cuenta);}

     //observador
     public int Codigo(){return (Codigo_Cuenta);}

     public void Deposito (double Cantidad) //modificador
     {
	if(Saldo_Cuenta > 0)
	     Saldo_Cuenta = Saldo_Cuenta + Cantidad;
     }

     public boolean Reintegro (double Cantidad) //modificador
     {
	if((Cantidad <= 0) || ( Cantidad > Saldo_Cuenta))
	     return (false);
	else
	{
	     Saldo_Cuenta = Saldo_Cuenta - Cantidad;
	     return (true);          
	}
     }

     /**
      * @param args the command line arguments
      *
     public static void main(String[] args)
     {
	// TODO code application logic here
     }*/     
}
