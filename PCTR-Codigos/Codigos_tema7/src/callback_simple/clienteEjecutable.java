/**
 * @(#)clienteEjecutable.java
 * @author A.T:
 * @version 1.00 2012/1/11
 */

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.*;

public class clienteEjecutable 
{
    
    public static void main(String[] args) 
      throws Exception
    {
        cliente CRem = new cliente();
        Naming.bind("//localhost/Cliente_Remoto",CRem);
        interfazServidor SRem = (interfazServidor) Naming.lookup("//localhost/Servidor_Incremento");
        SRem.registrarCallBack(CRem);
        for(int i=1;i<=20;i++)
        {
        	SRem.datoInc();
        }
        System.exit(0);
    }
}
