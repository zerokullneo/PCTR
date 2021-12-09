import java.rmi.*;
import java.rmi.activation.*;
import java.util.Properties;

/**
  * Servidor RMI que hereda de Activatable, para crear el objeto
  * remoto bajo demanda. Implementa la interfaz de la clase remota,
  * definiendo el codigo para sus metodos. En el metodo main() se
  * registra el objeto para que pueda ser accedido desde los clientes
  */



public class ServidorActivable
  extends java.rmi.activation.Activatable
    implements InterfazRemoto
{


	public ServidorActivable(ActivationID a, MarshalledObject m)
		throws java.rmi.RemoteException
	{
		super(a, 0);
	}

	public void m1()
		throws java.rmi.RemoteException
	{
		System.out.println ("Has llamado al metodo 1 del objeto activado remotamente");
	}

	public int m2()
		throws java.rmi.RemoteException
	{
		return 23;
	}

	public MiParametro getParametro()
		throws java.rmi.RemoteException
	{
		return new MiParametro();
	}


    public static void main(String[] args) throws Exception
    {
		System.setSecurityManager(new RMISecurityManager());

		// Fichero de politica de seguridad
		Properties p = new Properties();
        p.put("java.security.policy", "java.policy");

        // Descriptor del grupo de activacion
        ActivationGroupDesc.CommandEnvironment ace = null;
		ActivationGroupDesc ejemplo = new ActivationGroupDesc(p, ace);

		// Registrar el ActivationGroupDesc para obtener su ID
		// Definimos asi los parametros para el constructor
        ActivationGroupID agi = ActivationGroup.getSystem().registerGroup(ejemplo);
		MarshalledObject m = null;

		ActivationDesc desc = new ActivationDesc (agi, "ServidorActivable", "file://C:/rmi/", m);

		// Registrar con rmid
		InterfazRemoto mir = (InterfazRemoto)Activatable.register(desc);

		// Enlazar con un nombre en rmiregistry running on 1099
		Naming.rebind("//localhost/PruebaRMI", mir);

		System.exit(0);
    }
}
