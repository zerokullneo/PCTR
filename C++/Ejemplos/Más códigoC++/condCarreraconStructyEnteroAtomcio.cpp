/* 
 *@author A.T.
 *@date 18/03/2012
*/

#include <iostream>
#include <thread>
#include <vector>
#include <atomic>
using namespace std;


struct CuentaAtomica{
  atomic<int> val;
  void inc()
  {
    ++val; //incremento atomica
  }    
  int verValor(){return(val.load());}
};


int main()
{ 
  vector<thread> hilos;
  int nHilos = 100;
  CuentaAtomica contador;
  
  for(int i=0; i<nHilos; ++i)
    {hilos.push_back(thread([&contador](){for(int i=0;i<1000;i++){contador.inc();}}));}

  for(auto& thread : hilos){thread.join();}   

  cout << contador.verValor();
  return(0);
}
