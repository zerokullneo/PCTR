public class CompatibilidadTipos //Ejemplo de uso de la clase
{
  public static void main (String [] args)
  {
    Cuenta_Conjunta AntonioyJuan;

    AntonioyJuan = new Cuenta_Conjunta (1234, 25000, "Antonio Lopez", "Juan Perez");
    AntonioyJuan.Deposito (25000);
    System.out.println (AntonioyJuan.Saldo () );
    Cuenta_Banca2 p = AntonioyJuan; //compatbilidad de tipos
    p.Deposito (20000);
    System.out.println (p.Saldo());
    p = new Cuenta_Banca2(224242, 3000, "Damian Ferreiro");
    try {AntonioyJuan = (Cuenta_Conjunta)p;} //compatibilidad de tipos forzada... funcionara
    catch (ClassCastException e){System.out.println("casting ilegal...");}
        
  }
}
