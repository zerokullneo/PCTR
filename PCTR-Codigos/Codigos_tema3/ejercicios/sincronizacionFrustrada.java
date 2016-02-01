public class sincronizacionFrustrada extends Thread
{
	private static int compartida=0;
	private int limite;
	
	public sincronizacionFrustrada(int z)
	{
		limite = z;
	}
	
	public int ParImpar()
	{
		if(compartida % 2 == 0)
			return 0;
		else
			return 1;

	}
	
	public void run()
	{
		while(compartida<limite)
		{
			this.compartida++;
			if(ParImpar()==0)
				System.out.println(compartida + " Es Par");
			else
				System.out.println(compartida + " Es Impar");
		}
	}

    public static void main(String[] args)
    throws Exception
    {
		sincronizacionFrustrada a = new sincronizacionFrustrada(50);
		sincronizacionFrustrada b = new sincronizacionFrustrada(60);
		a.setName("Baja...");
		b.setName("Alta...");
		a.setPriority(Thread.MIN_PRIORITY);
		b.setPriority(Thread.MAX_PRIORITY);
		a.start();
		b.start();
    }
}
