/* 
 *@author A.T.
 *@date 18/03/2012
*/

#include<iostream>
#include <thread>

int x = 0; //variable compartida. Puede ser sobreescrita.
int nVueltas;
void hola()
{
  std::cout <<"Hola Mundo...";
  for(int i=0; i<nVueltas; i++)x++; //x++ es una seccion critica. Provoca condicion de carrera.

}

void adios()
{
  std::cout <<"Hola Mundo del tercero...";
  for(int i=0; i<nVueltas; i++)x=2*x; //x++ es una seccion critica. Provoca condicion de carrera.

}

int main()
{
  std::cout << "Introducir numero de iteracione por hilo: ";
  std::cin >> nVueltas;
  std::thread h(hola);
  std::thread i(hola);
  std::thread j(adios);
  h.join();
  i.join();
  j.join();
  std::cout << x; //En general, el valor de x sera distinto al esperado
}
