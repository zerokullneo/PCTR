
class Consumidor implements Runnable
{
	private Buffer bb = null;
	public Consumidor (Buffer b) {this.bb = b;}

	public void run()
	{
		double item;
		while (true)
		{
			item = bb.extraer ();
			System.out.println("Consumiendo " + item);
		}
	}
}
