public class Cuenta_Conjunta 
  extends Cuenta_Banca2  //Herencia de la clase Cuenta_Banca2
{
  public Cuenta_Conjunta () {} //constructor nulo
  public Cuenta_Conjunta (int n,double b,String prop1,String prop2)
  {
    super (n, b, prop1);   //llama al constructor de la superclase 
    Titular2 = prop2;
  }
  private String Titular2;  //Otro titular de una cuenta conjunta
}
