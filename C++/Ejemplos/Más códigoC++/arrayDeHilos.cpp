/* 
 *@author A.T.
 *@date 18/03/2012
*/

#include<iostream>
#include <thread>
using namespace std;


void hola()
{
  cout <<"Hola Mundo..." << this_thread::get_id()<< " ";

}

int main()
{ 
  int nHilos = 100;
  thread hilos[nHilos];
  for(int i=0; i<nHilos; i++)hilos[i]=thread (hola);
  for(int i=0; i<nHilos; i++)hilos[i].join();   

  cout << "Hilo main tambien saluda...";
  return(0);
}
