import java.lang.*;

public class Usa_ParImpar extends Thread
{
	public void run()
	{
		int i;
		switch(interruptor)
		{
			case 0:
				for(i = 0; i < par.leeN(); i++)
					if((i % 2) == 0)
						System.out.println(i);					
				break;
			case 1:
				for(i = 0; i < impar.leeN(); i++)
					if((i % 2) == 1)
						System.out.println(i);
				break;
		}
	}
	
	public static void main(String[] args)
	{
		int interruptor = Integer.valueOf(args[0]).intValue();
		//int intentos = Integer.valueOf(args[1]).intValue();
		ParImpar par = new ParImpar(interruptor,100);
		ParImpar impar = new ParImpar(interruptor,100);
		
		par.start();
		impar.start();
	}
}
