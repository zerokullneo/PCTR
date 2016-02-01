public class Clase_B
	extends Clase_A
{
	Clase_B (int x, int y)
	{
		super (x);
		valor2 = y;
	}
	
	//calcula una funcion de dos variables
	int Resultado ()
	{
		return valor*valor2-(valor2*6)+3;
	}
	
	protected int valor2;
}	
	