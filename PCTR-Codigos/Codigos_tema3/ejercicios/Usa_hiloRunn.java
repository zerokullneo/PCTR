public class Usa_hiloRunn
{
	public static void main(String[] args)
	throws InterruptedException
	{
		Runnable mcd1 = new hiloRunn(253,3);
		Runnable mcd2 = new hiloRunn(3,9);
		new Thread(mcd1).start();
		new Thread(mcd2).start();
	}
}
