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

package hoja3;

/**Fichero aCelularParalelo.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class aCelularParalelo extends Thread
{
     static int[][] A;
     static int generaciones;
     int inicio, fin;
    
     public aCelularParalelo(int in, int fi)
     {
	inicio = in; fin = fi;
	
     }
    
     static void inicializar(int gen, int tam, int n)
     {
	generaciones = gen;
	A = new int[generaciones][tam];
	for(int k = 0; k < generaciones; k++)
	    for(int i = 0; i < tam; i++)
	    {
		A[0][i] = (int)(Math.random()*n);
	    }
     }

    void Celular()
    {
        for(int i = 0; i < A.length; i++)
        {
            for(int j = 0; j < A[i].length; j++)
                if(j == 0 && i > 1)
                    A[i][j] = (A[i-1][A[i].length-1] + A[i-1][j] + A[i-1][j+1]) % 3;
                else if(j == A[i].length)
                    A[i][j] = (A[i-1][j-1] + A[i-1][j] + A[i-1][0]) % 3;
	      else if(i > 1 && (j > 1 && j < A.length))
                    A[i][j] = (A[i-1][j-1] + A[i-1][j] + A[i-1][j+1]) % 3;
        }
    }
    
     public void run()
     {
	for(int i = 0; i < generaciones; i++)
	     Celular();
     }

    void visualizar()
    {
        for(int i = 0; i < A.length; i++)
        {
            for(int j = 0; j < A[i].length; j++)
                System.out.print(A[i][j] + " ");
            System.out.println("");
        }
    }

    public static void main(String[] args)
    {
        aCelularParalelo autcelA= new aCelularParalelo(0,5);
        aCelularParalelo autcelB= new aCelularParalelo(5,10);
        autcelA.inicializar(5,10,3);
        autcelA.Celular();
        autcelA.visualizar();
    }
}
