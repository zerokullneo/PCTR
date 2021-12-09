
/**
  * Interfaz remoto, a implementar por las clases remotas que se
  * quieran usar
  */
public interface InterfazRemoto extends java.rmi.Remote
{
	public void m1() throws java.rmi.RemoteException;
	public int m2() throws java.rmi.RemoteException;
	public MiParametro getParametro() throws java.rmi.RemoteException;
}
