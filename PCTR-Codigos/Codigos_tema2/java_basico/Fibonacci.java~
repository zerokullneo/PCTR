//Antonio J. Tomeu
//Dpto. Lenguajes y Sistemas Informáticos
//Área de CC. de la Computación e I.A.
//Fichero Fibonacci.java
//Ilustra el uso de la estructura for...

class Fibonacci
{
  public static int Fibonacci (int n)
  { int s1, s2, s3;
    int i;
    if (n==0) return 0;
    if (n==1) return 1;
    s1=0;
    s2=1;
    s3=0;
    for(i=1; i<=n; i++)
    {
      s3 = s1 + s2;
      s1 = s2;
      s2 = s3;
    }//for
    return s3;
  }
  public static void main (String [] args)
  { int n = 0;
    while (n<25)
    {
      System.out.println ("El termino "+n+" es "+Fibonacci(n));
      n++;
    }
  }
}