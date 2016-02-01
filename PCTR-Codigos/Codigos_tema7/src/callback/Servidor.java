/*@author Antonio Tomeu
 *@version 1.0
 *Clase que implementa al servidor
 *Nota: Adaptado de  Liu, M. Computacion Distribuida
 **/
 
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;
import java.io.*;

public class Servidor
{
	public static void main (String[] args)
	{
		try
		{
			ImpInterfazServidor ObjServidor = new ImpInterfazServidor();
			Naming.rebind("rmi://localhost:2001/kk", ObjServidor);
			System.out.println("Servidor Activo...");
		}catch (Exception e) {System.out.println("Problema en servidor...");}
	}
}