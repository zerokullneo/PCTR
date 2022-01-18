#include<iostream>
#include <thread>
#include <semaphore>

int x = 0; 
int nVueltas = 100000;
std::binary_semaphore misemaforo(1);

void f(){
  for(int i=0; i<nVueltas; i++){
    misemaforo.acquire();
    x++;
    misemaforo.release();
  } 
}

int main(){
  std::thread h(f);
  std::thread i(f);
  std::thread j(f);
  std::thread k(f);
  h.join();
  i.join();
  j.join();
  k.join();
  std::cout << x; 
}
