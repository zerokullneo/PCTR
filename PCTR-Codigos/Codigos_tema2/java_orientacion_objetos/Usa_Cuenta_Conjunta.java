public class Usa_Cuenta_Conjunta //Ejemplo de uso de la clase
{
  public static void main (String [] args)
  {
    Cuenta_Conjunta AntonioyJuan;

    AntonioyJuan = new Cuenta_Conjunta (1234, 25000, "Antonio Lopez", "Juan Perez");
    AntonioyJuan.Deposito (25000);
    System.out.println (AntonioyJuan.Saldo () );
        
  }
}
