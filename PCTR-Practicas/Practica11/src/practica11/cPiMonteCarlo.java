/**
 * @author David Moreno Del Valle
 */

import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;

public class cPiMonteCarlo {

    public static void main(String[] args)
    	throws Exception
    {
    	int puntos = 0;
    	int op;
    	boolean exit = true;
    	Scanner r = new Scanner(System.in);
    	iPiMonteCarlo RefObRemoto = (iPiMonteCarlo)Naming.lookup("//localhost/Servidor");

    	while(exit==true)
    	{
    	System.out.print("Bienvenido al cliente de MonteCarlo.\nIndique que desea hacer:\n1. Añadir mas puntos a la aproximacion\n2. Resetear la aproximacion\n3. Salir\nOPCION: ");
    	op = r.nextInt();

    	switch(op)
    	{
    		case 1:{
    			System.out.print("Indique cuantos puntos desea añadir: ");
    			puntos = r.nextInt();
    			RefObRemoto.masPuntos(puntos);
    			break;
    		}

    		case 2:{
    		RefObRemoto.reset();
    		break;
    		}

    		case 3: exit = false;
    	}
    	}
    }


}
