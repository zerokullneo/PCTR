/* 
 *@author A.T.
 *@date 18/03/2012
*/

#include <iostream>
#include <thread>
#include <vector>
using namespace std;


void hola()
{
  cout <<"Hola Mundo..." << this_thread::get_id()<< " ";

}

int main()
{ 
  vector<thread> hilos;
  int nHilos = 100;
  
  for(int i=0; i<nHilos; ++i)
    {hilos.push_back(thread(hola));}

  for(auto& thread : hilos){thread.join();}   

  cout << "Hilo main tambien saluda...";
  return(0);
}
