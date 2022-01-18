#include<iostream>
#include <thread>
#include <atomic>

std::atomic_int x(0);  
int nVueltas;

void hola(){
  std::cout <<"Hola Mundo...";
  for(int i=0; i<nVueltas; i++)x++;
}

int main(){
  std::cout << "Introducir numero de iteracione por hilo: ";
  std::cin >> nVueltas;
  std::thread h(hola);
  std::thread i(hola);
  h.join();
  i.join();
  std::cout << x;
}
