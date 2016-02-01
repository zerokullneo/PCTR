class Cuenta_Corriente
  extends Cuenta_Banca2
{
  public Cuenta_Corriente () {} //constructor nulo
  public Cuenta_Corriente (int n, double b, String prop)
  {
    super (n, b, prop);
    gratuita = (b >= Saldo_Minimo);
  }

  public static void Cambiar_Saldo_Minimo (float m)
  {Saldo_Minimo = m;}

  public static void Cambiar_Comision (float f)
  {Comision = f;}

  public boolean Reintegro (double Cantidad)
  {
    boolean Resultado = super.Reintegro (Cantidad); //procesamiento 							   //general
    if (Resultado && (Saldo ()<Saldo_Minimo))       //procesamiento 							   //especifico
      gratuita = false;
    return (Resultado);
  }

  public boolean Cobro_Comision ()    //cargo mensual, si procede
  {
    boolean Resultado;
    if (!gratuita)
      { if (Resultado = Reintegro (Comision))
          gratuita = (Saldo ()>=Saldo_Minimo);
        return (Resultado);
      }
    return (true);
  }

  private static float Saldo_Minimo = 2500;//por encima, operativa 						 //gratis
  private static float Comision     = 18;  //comision para saldos 						 //inferiores
  private boolean gratuita			= false;
}

