public class Envoltura
{
	public static void main (String[] args)
	{
		int     i = 3;
		double  d = 123.354d;
		char    c = 'k';
		boolean b = false;
		float   f =345.4f;
		
		Integer I = new Integer(i);
		Double  D = new Double(d);
		Boolean B = new Boolean(b);
		Float   F = new Float(f);
		
		System.out.println("El valor de i como tipo primitivo es: "+i);
		System.out.println("y el de I como objeto es: "+I.toString());
		//Observe ahora un curioso efecto...
		i++;
		System.out.println("El valor de i como tipo primitivo es: "+i);
		System.out.println("y el de I como objeto es: "+I.toString());
		
	}//main
}//Envoltura