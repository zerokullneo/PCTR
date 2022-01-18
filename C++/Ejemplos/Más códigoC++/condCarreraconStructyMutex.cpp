/* 
 *@author A.T.
 *@date 18/03/2012
*/

#include <iostream>
#include <thread>
#include <vector>
#include <mutex>
using namespace std;


struct Cuenta{
  int val=0;
  mutex cerrojo;
  void inc()
  {
    cerrojo.lock();
    val++;
    cerrojo.unlock();
  }
};


int main()
{ 
  vector<thread> hilos;
  int nHilos = 100;
  Cuenta contador;
  
  for(int i=0; i<nHilos; ++i)
    {hilos.push_back(thread([&contador](){for(int i=0;i<1000;i++){contador.inc();}}));}

  for(auto& thread : hilos){thread.join();}   

  cout << contador.val;
  return(0);
}
