/* Copyright (C) 2006 M. Ben-Ari. See copyright.txt */

package practica7;

public class PCMonitor
{
	public final int N; //modificacion N = 100;
	public int Oldest = 0, Newest = 0;
	public volatile int Count = 0;
	public int Buffer[]; //modificacion  = new int[N];

	PCMonitor(int dimensionBuff)
	{
		N = dimensionBuff;
		Buffer = new int[N];
	}

	public synchronized void Append(int V)
	{
		while (Count == N)
		try
		{
			wait();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		Buffer[Newest] = V;
		Newest = (Newest + 1) % N;
		Count = Count + 1;
		notifyAll();
	}

	public synchronized int Take()
	{
		int temp;
		while (Count == 0)
		try
		{
			wait();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		temp = Buffer[Oldest];
		Oldest = (Oldest + 1) % N;
		Count = Count - 1;
		notifyAll();

		return temp;
	}
}