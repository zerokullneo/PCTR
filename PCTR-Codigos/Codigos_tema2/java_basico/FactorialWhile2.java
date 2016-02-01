//FactorialWhile2.java
public class FactorialWhile2//Enumera el factorial de n para n=0,1,...,12
{
	public static int factorial (int n) // metodo factorial factorial
	{ 
		int acum=1 ;
		while(n>1)
		{ 
			acum=acum*n;
			n=n-1; 
		}

		return acum;
	}//factorial
	
public static void main (String [] args) //metodo main 
{ 
	int n=1;
	while(n<13)
	{
		System.out.println(n+"!="+factorial(n));
		n++;
	}
}//main
}//FactorialWhile2