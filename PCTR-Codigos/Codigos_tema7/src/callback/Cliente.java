/*@author Antonio Tomeu
 *@version 1.0
 *Clase que implementa un cliente
 *Nota: Adaptado de  Liu, M. Computacion Distribuida
 **/
 
import java.io.*;
import java.rmi.*;

public class Cliente
{
	public static void main(String[] args)
	{
		//contacto al servidor
		try
		{
			InterfazServidor L = (InterfazServidor)Naming.lookup("rmi://localhost:2001/kk");
			System.out.println("El servidor contesta "+L.Hola());
			InterfazCliente ObjetodeCallBack = new ImpInterfazCliente();
			System.out.println("objeto callback cliente creado...");
			//registro de callback
			L.RegistroCallBack(ObjetodeCallBack);
			System.out.println("CallBack registrado...");
			try{
					Thread.sleep(1000);
				} catch (InterruptedException e){}
				
			L.QuitarCallBack(ObjetodeCallBack);
			System.out.println("CallBack eliminado de registro...");
				
		}catch (Exception e) {System.out.println("problema en cliente...");}	
		System.out.println("Cliente finalizando...");		
	}//main
}