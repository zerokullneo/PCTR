/**
 * Copyright (C) 2015 Jose Manuel Barba Gonzalez <zk at wordpress.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package practica4;
import java.lang.*;
import java.io.*;
import java.util.*;

/**Fichero UsaprodMatConcurrente.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class UsaprodMatConcurrente
{
     public static void main(String []args) throws IOException
     {
	InputStreamReader entrada = new InputStreamReader(System.in);
	BufferedReader lectura = new BufferedReader(entrada);
	prodMat MV;
	int i, j, N, opcion = 0;
	int []v; int [][]m;

	do
	{
	     System.out.println();
	     System.out.println("-- Menu --");
	     System.out.println("1.- Vector y Matriz Manual.");
	     System.out.println("2.- Vector y Matriz Aleatorio.");
	     System.out.println("0.- Salir.");
	     System.out.println("Opcion: ");
	     opcion = Integer.parseInt(lectura.readLine());

	     switch(opcion)
	     {
		case 0:
		     break;
		case 1:
		{
		     System.out.println("Introduzca N: ");
		     N = Integer.parseInt(lectura.readLine());
		     v = new int[N];
		     m = new int[N][N];
		     System.out.println("Introduzca los " + N + " Valores del vector");
		     for(i = 0; i < N; i++)
			v[i] = Integer.parseInt(lectura.readLine());
		     System.out.println("Introduzca los " + (N*N) + " Valores de la Matriz");
		     for(i = 0; i < N; i++)
		     {
			System.out.println("Fila " + i + " de la Matriz");
			for(j = 0; j < N; j++)
			     m[i][j] = Integer.parseInt(lectura.readLine());
		     }
		     MV = new prodMat(N,m,v);
		     MV.VerMatriz();
		     MV.multiplicacion(MV);
		     MV.VerVector();
		     MV.VerMatriz();
		     break;
		}
		case 2:
		{
		     System.out.println("Introduzca N: ");
		     N = Integer.parseInt(lectura.readLine());
		     prodMatConcurrente MVC[] = new prodMatConcurrente[N];
		     //con la interfaz Runnable hay que crear primero los Threads
		     for(i = 0; i < N; i++)
			MVC[i] = new prodMatConcurrente(N,i);
		     //MVC[0].VerMatriz();
		     for(i = 0; i < N; i++)
			new Thread(MVC[i]).start();
		     //MVC[0].VerVector();
		     //for(i = 0; i < N; i++)
			MVC[i].VerMatriz();
		     break;
		}
		default:
		     opcion = 0;
		     break;
	     }
	}while(opcion != 0);
     }
}
