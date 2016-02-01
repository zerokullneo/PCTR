
public class FactorialWhile
{
	public static void main (String[] args)
	{
		int cont = 1;
		int factor = 5;
		int acum=1;
		while(cont<=factor)
		{
			acum=acum*cont;
			cont++;
		}
		System.out.println("El factorial de "+factor+" es "+acum);
	}//main
}//FactorialWhile