//Fichero Cuenta_Banca2.java
public class Cuenta_Banca2 //Nombre de la clase
{
    public Cuenta_Banca2 () {} //constructor nulo
    public Cuenta_Banca2 (int id, double disponible, String propietario)
  	{ Codigo_Cuenta=id;
      Saldo_Cuenta=disponible;
      Titular=propietario;
    }
    
    public double  Saldo()
    {return (Saldo_Cuenta);}

    public void Deposito (double Cantidad)
    {if (Saldo_Cuenta>0) Saldo_Cuenta=Saldo_Cuenta+Cantidad;}

    public boolean Reintegro (double Cantidad)
      {if ((Cantidad <=0)||(Cantidad>Saldo_Cuenta)) return (false);
       else {Saldo_Cuenta=Saldo_Cuenta-Cantidad;
              return (true);          
            }
      }      
    
    
    public int Codigo ()
    {return (Codigo_Cuenta);}
    
    
  protected int Codigo_Cuenta;   //Codigo Cuenta Cliente
  protected String Titular;      //Titular de la Cuenta
  private double Saldo_Cuenta;   //Saldo Actual

} 	