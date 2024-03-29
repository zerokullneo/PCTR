public class UsaMuestraBloqueoObjeto
implements Runnable
{
	private MuestraBloqueoObjeto p; //referencia objeto compartido
	private int caso;
	public UsaMuestraBloqueoObjeto(MuestraBloqueoObjeto o, int val)
	{
		p=o;
		caso=val;
	}

	public void run()
	{
		switch(caso)
		{
			case 0: p.metodoA(); break;
			case 1: p.metodoB(); break;
		}
	}

	public static void main(String[] args)
	{
		MuestraBloqueoObjeto monitor = new MuestraBloqueoObjeto();
		Thread h1 = new Thread(new UsaMuestraBloqueoObjeto(monitor,0));
		Thread h2 = new Thread(new UsaMuestraBloqueoObjeto(monitor,1));
		h1.start();
		h2.start();
	}
}
