//clase que implementa el M.C.D. por el algoritmo de Euclides
public class hiloRunn implements Runnable
{
	private int var_a, var_b;
	
	public hiloRunn(int a, int b)
	{
		if(a < b)
		{
			var_a = b;
			var_b = a;
		}
		else
		{
			var_a = a;
			var_b = b;
		}
	}

	public void run()
	{
		int aux=1;
		while(aux > 0)
		{
			//Lo interesante esta aqui, ir imprimiendo cada paso de Euclides.
			System.out.println("Euclides: " + var_b);
			aux = var_b;
			var_b = var_a / var_b;
			var_a = aux;
			aux = var_a % var_b;
		}
		System.out.println("Euclides Fin: " + var_b);
	}
}
