public class UsoSwitch
{
	public static void main(String [] args)
	{
		int j=4;
		switch(j)
		{
			case 1:  case 3: System.out.println("A: Caso 1 o 3");
			case 5:  System.out.println("B: Caso 5");
			default: System.out.println("C: es default...");
			case 2:  System.out.println("D: Caso 2");
		}//switch
		
		j=2;
		
		switch(j)
		{
			case 5:  System.out.println("E: Caso 5");
			default: System.out.println("F: es default...");
			case 2:  System.out.println("G: Caso 2");
		}//switch
	}//main
}