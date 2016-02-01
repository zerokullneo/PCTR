class Prueba_Hilo1 //Hace uso de la clase anterior
{
  public static void main (String [] args)
    throws InterruptedException
  {
    Ejemplo_Hilos1 Hilo1 = new Ejemplo_Hilos1 (5);
    Ejemplo_Hilos1 Hilo2 = new Ejemplo_Hilos1 (15);
    Hilo1.start ();  //Ahora se lanzan ambos hilos...
    Hilo2.start ();
    Hilo1.join ();
    Hilo2.join ();
    System.out.println ("Hilos terminados");
  }
}
