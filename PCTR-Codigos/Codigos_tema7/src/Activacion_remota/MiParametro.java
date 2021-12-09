import java.io.Serializable;

/**
  * Clase serializable que intercambiarse entre cliente y servidor
  * RMI
  */
public class MiParametro implements Serializable
{
	int n;
	String s = "Hola";
	
	public int getN()
	{
		return n;
	}

	public String getS()
	{
		return s;
	}
}
