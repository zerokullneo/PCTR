
class Productor implements Runnable
{
	private Buffer bb = null;
	public Productor(Buffer b) {bb = b;}
	public void run()
	{
		double item = 0.0;
		while(true)
		{
			bb.insertar (++item);
			System.out.println("Produciendo " + item);
		}
	}
}
