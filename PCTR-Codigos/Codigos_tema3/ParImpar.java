import java.lang.*;

public class ParImpar extends Thread
{
	private int sw;
	private int n;
	
	public ParImpar(int tip, int num)
	{
		sw = tip;
		n = num;
	}
	
	public int leeSW(){return sw;}
	public int leeN(){return n;}
}
