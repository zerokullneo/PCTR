/*
 * Copyright (C) 2021 Jose Manuel Barba Gonzalez <administrador at elyinyang.com>
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

/*
 *	COMPILACION: javac -cp .:$MPJ_HOME/lib/mpj.jar escalMultiple.java
 *	EJECUCION: mpjrun.sh -np 5 escalMultiple
 */

//package practica10;

import mpi.*;
import java.util.Arrays;

/**
 * Fichero escalMultiple.java
 * @author Jose Manuel Barba Gonzalez <administrador at elyinyang.com>
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */
 /**
 * Descripcion
 * Clase que realiza el producto escalar de un vector con la interfaz MPI, recibiendo los
 * parametros en el constructor para crear objetos y realizando el escalado segun el identificador
 * (rank) de cada proceso, realizando la comunicacion con el metodo Bcast.
 */
public class escalMultiple
{
	/**
	 * Atributos de inicializacion de MPI.
	 */
	private int emisor, root, unitSize;
	/**
	 * Atributos vectores que guardan el vector inicial y el vector resultado.
	 */
	private int vectorInicial[], vectorResultado[];

	/**
	 * Constructor base de la clase con atributos especificos
	 * @param em Parametro indicador del emisor.
	 * @param rt Parametro indicador del proceso root.
	 * @param us Parametro indicador de las unidades del vector, dimension del vector.
	 */
	public escalMultiple(int em, int rt, int us)
	{
		emisor = em;
		root = rt;
		unitSize = us;
		vectorInicial = new int[unitSize];
		vectorResultado = new int[unitSize];
		
		for(int i = 0; i < vectorInicial.length; i++)
			vectorInicial[i] = i + 1;
	}

	/**
	 * Metodo observador del parametro emisor.
	 * @return Devuelve el atributo indicador del emisor.
	 */
	public int getEmisor(){ return emisor; }

	/**
	 * Metodo observador del parametro root.
	 * @return Devuelve el atributo indicador del proceso root.
	 */
	public int getRoot(){ return root;}

	/**
	 * Metodo observador del parametro dimension de los vector.
	 * @return Devuelve el atributo indicador de la dimension del vector.
	 */
	public int getUnitSize(){ return unitSize; }

	/**
	 * Metodo observador del parametro vector inicial.
	 * @return Devuelve el objeto vector inicial.
	 */
	public int []getVectorInicial(){ return vectorInicial; }

	/**
	 * Metodo observador como String del parametro vector inicial.
	 * @return Devuelve la conversion del objeto vector a String.
	 */
	public String tostrVectorInicial(){ return Arrays.toString(vectorInicial); }

	/**
	 * Metodo observador del parametro VectorResultado.
	 * @return Devuelve el objeto vector resultado.
	 */
	public int []getVectorResultado(){ return vectorResultado; }

	/**
	 * Metodo observador del parametro VectorResultado.
	 * @return Devuelve la conversion del objeto vector a String.
	 */
	public String tostrVectorResultado(){ return Arrays.toString(vectorResultado); }

	/**
	 * Metodo modificador del VectorResultado, realiza la multiplicacion de cada elemento
	 * del vector por el factor multiplicativo.
	 * @param factorMultiplicativo Parametro factor por el que se multiplicara cada elemento del vector.
	 */
	public void setVectorResultado(int factorMultiplicativo)
	{
		for(int i = 0; i < vectorResultado.length; i++)
			vectorResultado[i] = vectorInicial[i] * factorMultiplicativo;
	}

	public static void main(String args[]) throws Exception
	{
		MPI.Init(args);
		int rank = MPI.COMM_WORLD.Rank();
		int size = MPI.COMM_WORLD.Size();
 
		/**
		 * Objeto de la clase escalMultiple que contiene la informacion para el objeto "buf"
		 * del metodo Bcast.
		 */
		escalMultiple peI = new escalMultiple(0, 0, 10);

		if(rank==0)
		{
			System.out.println("Vector Inicial: " + peI.tostrVectorInicial());
		}

		MPI.COMM_WORLD.Bcast(peI.getVectorInicial(), 0, peI.getUnitSize(), MPI.INT, peI.getRoot());

		switch(rank)
		{
			case 1:
				peI.setVectorResultado(rank);
				System.out.println("Proceso slave " + rank + ": " + peI.tostrVectorResultado());
				break;
			case 2:
				peI.setVectorResultado(rank);
				System.out.println("Proceso slave " + rank + ": " + peI.tostrVectorResultado());
				break;
			case 3:
				peI.setVectorResultado(rank);
				System.out.println("Proceso slave " + rank + ": " + peI.tostrVectorResultado());
				break;
			case 4:
				peI.setVectorResultado(rank);
				System.out.println("Proceso slave " + rank + ": " + peI.tostrVectorResultado());
				break;
		}

		MPI.Finalize();
	}
}
