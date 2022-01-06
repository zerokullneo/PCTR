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

		int circular = (Newest + 1) % N;
		if(circular == -1)
			circular = circular + N;

		Newest = circular;
		Buffer[Newest] = V;
		Count = Count + 1;
		notifyAll();
	}

	public synchronized void Take()
	{
		while (Count == 0)
		try
		{
			wait();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		int circular = (Newest + 1) % N;
		if(circular == -1)
			circular = circular + N;

		Oldest = circular;
		Count = Buffer[Oldest];
		Count = Count - 1;
		notifyAll();

		//return Count;
	}
}