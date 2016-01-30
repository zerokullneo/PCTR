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

package hoja1;

import java.util.*;

/* Fichero mediCalc.java 
  *@author Jose Manuel Barba Gonzalez
  *@version 1.0
  *Programacion Concurrente y de Tiempo Real
  *Area de CC. de la Computacion e I.A.
*/

/**Descripcion
 * 
 */
public class mediCalc
{
     public double peso, creatinina, altura;
     public int edad;
     public char sexo;

     /**
      * Constructor vacío de mediCalc.
      */
     public mediCalc(){}

     /**
      * Constructor especificando los parametros de mediCalc.
      * @param p Peso del paciente.
      * @param c Creatinina pre-indicada del paciente.
      * @param a altura del paciente.
      * @param e edad  del paciente.
      * @param s Sexo del paciente.
      */
     public mediCalc(double p, double c, int a, int e, char s)
     {
	peso = p; 
	creatinina = c;
	edad = e;
	altura = (a/100.0);
	sexo = s;
     }

     /**
      * Metodo para calcular el aclaramiento de una persona en funcion del sexo.
      * @param sexo Recibe "m" para mujer o "h" para hombre para diferenciar el 
      * tipo de calculo.
      * @return Devuelve el calculo generado en el parametro "aclara".
      */
     public double cockGault(char sexo)
     {
	double aclara;
	aclara = ((140-edad)*peso)/(72*creatinina);

	switch(sexo)
	{
	     case 'm':
		aclara = aclara * 0.85;
		return aclara;
	     case 'h':
		return aclara;
	     default:
		return 0;
	}
     }

     /**
      * Metodo para calcular el indice de masa corporal de una persona en
      * funcion del sexo.
      * @param sexo Recibe "m" para mujer o "h" para hombre para diferenciar el 
      * tipo de calculo.
      * @return Devuelve el calculo generado en el parametro "imc".
      */
     public double imc(char sexo)
     {
	double imc_ = peso/(altura*altura);
	switch(sexo)
	{
	     case 'm':
		imc_ += 0.181;
		return imc_;
	     case 'h':
		imc_ += 0.503;
		return imc_;
	     default:
		return 0;
	}
     }
	
     /**
      * Metodo que muestra la informacion obtenida por los metodos de imc() o
      * cockGault() dependiendo del valor de "op".
      * @param valor Valor referenciado por uno de los metodos cockGault() o imc().
      * @param op La "op"=1 muestra el aclaramiento del paciente y "op"=2 muestra
      * el indice de masa corporal.
      */
     public void MostrarInfo(double valor, int op)
     {
	switch(op)
	{
	     case 1:
		System.out.print("Aclaramiento. ");
		if(valor >= 90)
		     System.out.println("-Funcion normal.-");
		if(valor >= 60 && valor < 89)
		     System.out.println("-Daño renal leve.-");
		if(valor >= 30 && valor < 59)
		     System.out.println("-Daño renal moderado.-");
		if(valor >= 15 && valor < 29)
		     System.out.println("-Daño renal grave.-");
		if(valor < 15)
		     System.out.println("-Fallo renal.-");
		break;
	     case 2:
		System.out.print("Indice de Masa Corporal. ");
		if(valor < 16)
		     System.out.println("-Delgadez severa.-");
		if(valor >= 16 && valor<17)
		     System.out.println("-Delgadez moderada.-");
		if(valor >= 17 && valor < 18.50)
		     System.out.println("-Delgadez aceptable.-");
		if(valor >= 18.50 && valor < 25)
		     System.out.println("-Peso normal.-");
		if(valor >= 25 && valor < 30)
		     System.out.println("-Sobrepeso.-");
		if(valor >= 30 && valor < 35)
		     System.out.println("-Obesidad de Tipo I.-");
		if(valor >= 35 && valor < 40)
		     System.out.println("-Obesidad de Tipo II.-");
		if(valor >= 40)
		     System.out.println("-Obesidad de Tipo III.-");
		break;
	}
     }

     /**
      * Funcion que muestra el menu de opciones.
      */
     public void menu()
     {
	System.out.println("================Menu================");
	System.out.println("1.- Calcular Aclaramiento.");
	System.out.println("2.- Calcular Indice de Masa Corporal.");
	System.out.println("3.- Volver a introducir Datos.");
	System.out.println("0.- Salir.");
	System.out.println("Introduzca operacion a realizar");
     }

     /**
      * Metodo que vuelve a solicitar datos de un nuevo paciente o del mismo
      * paciente para realizar nuevos calculos
      * @param MC Recibe el objeto "mediCalc" a modificar por la entrada de teclado.
      * @return Devuelve el objeto "MC" modificado.
      */
     public static mediCalc datos(mediCalc MC)
     {
	double p, c; int a, e; char s;
	Scanner CG = new Scanner(System.in);
	do
	{
	     System.out.println("Introducir valor Sexo, m(mujer) h(hombre):");
	     s = CG.next().charAt(0);
	}while((s != 'm') && (s != 'h'));

	do
	{
	     System.out.println("Introducir valor Edad:");
	     e = CG.nextInt();
	}while(e < 18);

	System.out.println("Introducir valor Altura en cm:");
	a = CG.nextInt();		
	System.out.println("Introducir valor Peso:");
	p = CG.nextDouble();
	System.out.println("Introducir valor Creatinina:");
	c = CG.nextDouble();
	MC = new mediCalc(p,c,a,e,s);
	return MC;
     }

     public static void main (String []args)
     {
     	mediCalc MC = new mediCalc();
	int option;
	double resA, resI;
	Scanner CG = new Scanner(System.in);

	MC=datos(MC);

	do
	{
	     MC.menu();
	     option = CG.nextInt();

	     switch(option)
	     {
		case 1:
		     resA = MC.cockGault(MC.sexo);
		     System.out.println("La aclaracion es: " + resA);
		     MC.MostrarInfo(resA, option);
		     break;
		case 2:
		     resI = MC.imc(MC.sexo);
		     System.out.println("El I.M.C. es: " + resI);
		     MC.MostrarInfo(resI, option);
		     break;
		case 3:
		     MC=datos(MC);
		     break;
		case 0:
		     break;
		default:
		     System.out.println("Opcion " + option + " incorrecta.");
		     break;
	     }
	}while(option != 0);
     }
}
