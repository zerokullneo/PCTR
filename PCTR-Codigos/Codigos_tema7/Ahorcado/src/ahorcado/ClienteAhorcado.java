/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado;

import java.rmi.Naming;
import java.util.*;

/**
 *
 * @author zerokullneo
 */
public class ClienteAhorcado {
	public static void main(String[] args) {
		IAhorcado servidor = (IAhorcado)Naming.lookup("//localhost/juegoahorcado");

		while(!servidor.estadoActual().contains(servidor))
	}
}