
/**
  * Ejemplo de cliente RMI. Simplemente obtiene un objeto remoto y llama
  * a sus metodos
  */
public class ClienteActivador
{
	public static void main(String[] args)
	{
    	if (System.getSecurityManager() == null)
       		System.setSecurityManager(new java.rmi.RMISecurityManager());
		try
		{
			InterfazRemoto mir = (InterfazRemoto)java.rmi.Naming.lookup("//localhost/PruebaRMI");
			mir.m1();
			int i = mir.m2();
			System.out.println ("Valor del metodo 2: " + i);
			MiParametro mp = mir.getParametro();
			System.out.println ("MiParametro: " + mp.getS());
		} catch (Exception e) { System.out.println ("Error, no encuentro: " + e.getMessage()); }
	}
}
