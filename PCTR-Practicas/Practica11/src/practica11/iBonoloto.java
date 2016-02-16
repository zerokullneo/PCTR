/**
 * @author David Moreno Del Valle
 */


import java.rmi.*;
public interface iBonoloto extends Remote
{
  public void resetServidor() throws RemoteException;
  public boolean compApuesta(int[] apuesta)  throws RemoteException;

}
