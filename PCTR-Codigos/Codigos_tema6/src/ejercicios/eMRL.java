import java.util.concurrent.*;

class eMRL extends Thread
{
	private final ReentrantLock Rlock = new ReentrantLock();
	int cont = 10;
	public void run()
	{
		Rlock.lock();
		try
		{
			cont--;
		}
		finally{Rlock.lock();}
	}
}

class Usa_eMRL
{
	public static void main(String[] args)
	{
		ReentrantLock RL = new ReentrantLock();
		new eMRL(RL).start();
		new eMRL(RL).start();
		new eMRL(RL).start();
	}
}
