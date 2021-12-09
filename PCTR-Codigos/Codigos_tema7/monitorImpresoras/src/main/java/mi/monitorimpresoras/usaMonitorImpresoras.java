/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mi.monitorimpresoras;

/**
 *
 * @author zerokullneo
 */
public class usaMonitorImpresoras
{
	
	public static void main(String[] args)
	{
		int numprinters = 5;
		
		monitorImpresoras monitor1 = new monitorImpresoras(numprinters);
		monitorImpresoras monitor2 = new monitorImpresoras(numprinters);
		monitor1.start();
		monitor2.start();
	}
}
