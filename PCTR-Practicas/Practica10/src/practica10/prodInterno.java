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
 *	COMPILACION: javac -cp .:$MPJ_HOME/lib/mpj.jar prodInterno.java
 *	EJECUCION: mpjrun.sh -np 2 prodInterno
 */

//package practica10;

import mpi.*;
import java.util.Arrays;

/**
 * Fichero prodInterno.java
 * @author Jose Manuel Barba Gonzalez <administrador at elyinyang.com>
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */
 /**
 * Descripcion
 * Clase que realiza el producto escalar de dos vectores con la interfaz MPI, recibiendo los
 * parametros en el constructor para crear objetos, y realizando la comunicacion con los metodos
 * Send y Recv.
 */
public class prodInterno
{
	/**
	 * Atributos de inicializacion de MPI.
	 */
	private int emisor, receptor, tag, unitSize;
	/**
	 * Atributo inicial del factor por el que se multiplicara cada elemento del vector. 
	 */
	private int factorMultiplicativo;
	/**
	 * Atributos vectores que guardan el vector inicial y el vector resultado.
	 */
	private int vectorProducto[], vectorResultado[];

	/**
	 * Constructor base de la clase con atributos especificos
	 * @param em Parametro indicador del emisor.
	 * @param rp Parametro indicador del receptor.
	 * @param tg Parametro indicador del mensaje tag.
	 * @param us Parametro indicador de las unidades del vector, dimension del vector.
	 * @param fm Parametro indicador del factor multiplicativo.
	 */
	public prodInterno(int em, int rp, int tg, int us, int fm)
	{
		emisor = em;
		receptor = rp;
		tag = tg;
		unitSize = us;
		factorMultiplicativo = fm;
		vectorProducto = new int[unitSize];
		vectorResultado = new int[unitSize];
		
		for(int i = 0; i < vectorProducto.length; i++)vectorProducto[i] = i + 1;
	}

	/**
	 * Metodo observador del parametro emisor.
	 * @return Devuelve el atributo indicador del emisor.
	 */
	public int getEmisor(){ return emisor; }

	/**
	 * Metodo observador del parametro receptor.
	 * @return Devuelve el atributo indicador del receptor.
	 */
	public int getReceptor(){ return receptor; }

	/**
	 * Metodo observador del parametro mensaje tag.
	 * @return Devuelve el atributo indicador del mensaje tag.
	 */
	public int getTag(){ return tag;}

	/**
	 * Metodo observador del parametro dimension de los vector.
	 * @return Devuelve el atributo indicador de la dimension del vector.
	 */
	public int getUnitSize(){ return unitSize; }

	/**
	 * Metodo observador del parametro VectorProducto o vector inicial.
	 * @return Devuelve el objeto vector inicial.
	 */
	public int []getVectorProducto(){ return vectorProducto; }

	/**
	 * Metodo observador como String del parametro vector inicial.
	 * @return Devuelve la conversion del objeto vector a String.
	 */
	public String tostrVectorProducto(){ return Arrays.toString(vectorProducto); }

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
	 */
	public void setVectorResultado()
	{
		for(int i = 0; i < vectorResultado.length; i++)
			vectorResultado[i] = vectorResultado[i] * factorMultiplicativo;
	}
	
	public static void main(String[] args) throws Exception
	{
		MPI.Init(args);
		int rank = MPI.COMM_WORLD.Rank();
		int size = MPI.COMM_WORLD.Size();
		/**
		 * Objetos de la clase prodInterno que contienen la informacion para el objeto "buf"
		 * de los metodos Send y Recv.
		 */
		prodInterno piI = new prodInterno(0, 1, 10, 4, 4), piII = new prodInterno(0, 1, 10, 4, 8);

		/**
		 * Codigo del Emisor
		 */
		if(rank == piI.getEmisor() && rank == piII.getEmisor())
		{
			MPI.COMM_WORLD.Send(piI.getVectorProducto(), 0, piI.getUnitSize(), MPI.INT, piI.getReceptor(), piI.getTag());
			MPI.COMM_WORLD.Recv(piI.getVectorProducto(), 0, piI.getUnitSize(), MPI.INT, piI.getReceptor(), piI.getTag());
			System.out.println("El Emisor ha recibido: " + piI.tostrVectorProducto());
			
			MPI.COMM_WORLD.Send(piII.getVectorProducto(), 0, piII.getUnitSize(), MPI.INT, piII.getReceptor(), piII.getTag());
			MPI.COMM_WORLD.Recv(piII.getVectorProducto(), 0, piII.getUnitSize(), MPI.INT, piII.getReceptor(), piII.getTag());
			System.out.println("El Emisor ha recibido: " + piII.tostrVectorProducto());
		}
		/**
		 * Codigo del Receptor
		 */
		else
		{
			MPI.COMM_WORLD.Recv(piI.getVectorResultado(), 0, piI.getUnitSize(), MPI.INT, piI.getEmisor(), piI.getTag());
			System.out.println("El Receptor ha recibido: " + piI.tostrVectorResultado());
			piI.setVectorResultado();
			MPI.COMM_WORLD.Send(piI.getVectorResultado(), 0, piI.getUnitSize(), MPI.INT, piI.getEmisor(), piI.getTag());
			
			MPI.COMM_WORLD.Recv(piII.getVectorResultado(), 0, piII.getUnitSize(), MPI.INT, piII.getEmisor(), piII.getTag());
			System.out.println("El Receptor ha recibido: " + piII.tostrVectorResultado());
			piII.setVectorResultado();
			MPI.COMM_WORLD.Send(piII.getVectorResultado(), 0, piII.getUnitSize(), MPI.INT, piII.getEmisor(), piII.getTag());
		}
		
		MPI.Finalize();
	}
}
