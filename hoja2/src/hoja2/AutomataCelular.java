/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoja2;

import java.math.*;

/**
 *
 * @author zerokullneo
 */
public class AutomataCelular
{
    static int[][] A;
    
    static void inicializar(int generaciones, int tam, int n)
    {
        A = new int[generaciones][tam];
        for(int i = 0; i < tam; i++)
        {
            A[0][i] = (int)(Math.random()*n);
        }
    }

    void Celular()
    {
        for(int i = 1; i < A.length; i++)
        {
            for(int j = 0; j < A[i].length; j++)
                if(j == 0)
                    A[i][j] = (A[i-1][A[i].length-1] + A[i-1][j] + A[i-1][j+1]) % 3;
                else if(j == A[i].length)
                    A[i][j] = (A[i-1][j-1] + A[i-1][j] + A[i-1][0]) % 3;
                else
                    A[i][j] = (A[i-1][j-1] + A[i-1][j] + A[i-1][j+1]) % 3;
        }
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
        AutomataCelular autcel= new AutomataCelular();
        autcel.inicializar(5,10,3);
        autcel.Celular();
        autcel.visualizar();
    }
}
