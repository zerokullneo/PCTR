public interface Ejemplo_interface
{
	int operacion_binaria (int a, int b);
	int operacion_monaria (int a);
}

public class Imp_Interface implements Ejemplo_interface
{
	public int operacion_binaria(int a, int b)
	{
		return a + b;
	}
	
	public int operacion_monaria(int a)
	{
		return -a;
	}
}