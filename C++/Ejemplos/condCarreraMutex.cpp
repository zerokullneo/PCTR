#include<iostream>
#include <thread>
#include <mutex>

int x = 0; //variable compartida.
int nVueltas;
std::mutex mimutex;

void hola(){
  std::cout <<"Hola Mundo...";
  for(int i=0; i<nVueltas; i++){
  	  mimutex.lock();
  	  x++; //x++ es una seccion critica controlada.
  	  mimutex.unlock();
  }	  
}
int main(){
  std::cout << "Introducir numero de iteracione por hilo: ";
  std::cin >> nVueltas;
  std::thread h(hola);
  std::thread i(hola);
  h.join();
  i.join();
  std::cout << x; //Ahora, x siempre vale lo mismo...
}
