/**
 * @(#)UsaGradosProteccion.java
 * @author AT
 * @version 1.00 2011/10/20
 */

public class UsaGradosProteccion 
{
   
    public static void main(String[] args) 
    { 
      GradosProteccion obj = new GradosProteccion();
      System.out.println ("Accediendo a un miembro público: "+obj.todoquisque);
      obj.todoquisque++;
      System.out.println ("Miembro público modificado: "+obj.todoquisque);
      System.out.println ("Accediendo a un miembro protegido: "+obj.losamigos);
      obj.losamigos--;
      System.out.println ("Miembro protegido modificado: "+obj.losamigos);
      //pero esto no funcionara
      obj.sololaclase++;
      //pero esto si
      obj.CambiarPrivado(obj.losamigos);
      System.out.println("Miembro privado modificado y observado vía metodos de interfaz: "+obj.ObservarPrivado());
      //y esto tampoco funcionara
      obj.CambiarAmigos(23);
    }
}
