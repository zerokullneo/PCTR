public class Usa_semaf
{
	public static void main (String []args)
	{
		int ranuras = 10;
		Buffer monitor = new Buffer (ranuras);
		new Thread(new Productor(monitor)).start();
		new Thread(new Consumidor(monitor)).start();
	}
}
