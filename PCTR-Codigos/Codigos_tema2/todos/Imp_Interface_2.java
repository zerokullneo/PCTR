public class Imp_Interface_2
  implements Ejemplo_interface
{
	public int operacion_binaria (int a, int b)
	{
		return a*b;
	}	
	
	public int operacion_monaria (int a)
	{
		if(a!=0) return 1/a;
		  else return 0;
	}	
}
