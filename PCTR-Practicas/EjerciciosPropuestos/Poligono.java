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

package practica3;

/**Fichero Poligono.java
 * @author Jose Manuel Barba Gonzalez
 * @version 1.0
 * Programacion Concurrente y de Tiempo Real
 * Area de CC. de la Computacion e I.A.
 */

/**Descripcion
 * 
 */
public class Poligono extends Punto
{
     //Lista de variables de coordenadas "x" e "y"
     protected Punto []p;
     protected int lados;
	
     /**
      * Constructor especificando los parametros de Poligono.
      * @param pxy Vector de coordenadas del Poligono, las "l/2" primeras
      * posiciones son las coordenadas "x" de cada punto, y las "n" ultimas
      * son las coordenadas "y" de cada punto.
      * @param l Numero de lados que tiene el Poligono.
      */
     public Poligono(double []pxy, int l)
     {
	lados = l;
	p = new Punto[lados];
	for(int i = 0; i < lados; i++)
	     p[i] = new Punto(pxy[i], pxy[i+lados]);
     }

     //Observadoras
     /**
      * Metodo para visualizar el numero de lados del Poligono.
      * @return Devuelve el atributo lados de Poligono.
      */
     public int nLados(){return lados;}

     /**
      * Metodo para visualizar el numero de puntos del Poligono.
      * @return Devuelve el atributo length de Poligono.
      */
     public int nPuntos(){return p.length;}

     /**
      * Metodo para visualizar si los lados del Poligono son iguales.
      * @return Devuelve si todos los lados del Poligono son iguales.
      */
     public boolean LadosIguales()
     {
	for(int i = 0; i < lados; i++)
	     if(((p[i].mostrarX() - p[i+1].mostrarX()) + (p[i].mostrarY() - p[i+1].mostrarY())) != 0)
		return false;
	return true;
     }

     //Modificadoras

     //Calculo de los metodos de la interfaz.
     /**
      * Metodo que calcula la apotema de un Poligono Regular.
      * @param radio Valor del punto central del Poligono a uno de sus lados.
      * @return Devuelve el valor de la Apotema.
      */
     public double Apotema(double radio)
     {
	double ap = Math.sqrt(Math.pow(radio, 2) - Math.pow(radio/2,2));
	return ap;
     }

     /**
      * Metodo para calcular el perimetro del Poligono.
      * @return Devuelve el calculo del perimetro del Poligono.
      */
     public double Perimetro()
     {
	double perimetro = (p[lados-1].mostrarX() - p[0].mostrarY()) * lados;
	return perimetro;
     }

     /**
      * Metodo para escalar el perimetro del Poligono.
      * @param f Valor del factor a escalar.
      */
     public void Escalado(double f)
     {
	for(int i = 0; i < p.length; i++)
	     p[i].moverEn(f, f);
     }

     /**
      * Metodo para un punto concreto del Poligono.
      * @param i Indice del array de puntos a mover.
      * @param pp Nuevas coordenadas del punto que se va a mover.
      */
     public void MoverPunto(int i, Punto pp)
     {
	p[i].moverEn(pp.mostrarX(), pp.mostrarY());
     }

     /**
      * Metodo para visualizar los datos del Poligono.
      * @return Devuelve el String con los atributos del Poligono.
      */
     public String toString()
     {
	return "Punto inicial: [" + this.p[0].mostrarX() + "," + this.p[0].mostrarY() + "]";
     }
}
