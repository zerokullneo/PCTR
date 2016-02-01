/* 
 *@author A.T.
 *@date 19/03/2012
*/

#include <iostream>
#include <thread>
#include <mutex>
#include <condition_variable>
using namespace std;

struct Buffer
{
  int* buffer;
  int  tam;
  int In_Ptr;
  int Out_Ptr;
  int cont;
  
  mutex em;
  condition_variable not_full;
  condition_variable not_empty;
  
  Buffer(int capacidad)
  {
    tam=capacidad;
    In_Ptr=0; Out_Ptr=0;
    cont=0;
    buffer = new int[tam];    
  } 	  
  
  ~Buffer(){delete[] buffer;}
  
  void insertar(int dato)
  {
    unique_lock<mutex> l(em);
    while(cont==tam){not_full.wait(l);}
    buffer[In_Ptr]=dato;
    In_Ptr=(In_Ptr+1)%tam;
    ++cont;
    not_empty.notify_one();
  }	

  int extraer()
  {
    unique_lock<mutex> l(em);
    while(cont==0){not_empty.wait(l);}
    int result = buffer[Out_Ptr];
    Out_Ptr=(Out_Ptr+1)%tam;
    --cont;
    not_full.notify_one();
    return(result);
  }  
  	  
};

 void productor(int id, Buffer& buffer)
  {
    for(int i=0; i<100; ++i)
    {
      buffer.insertar(i);
      cout<<"Productor "<<id<<" inserto "<<i<<endl;
    }	    
  } 	  
  
  void consumidor(int id, Buffer& buffer)
  {
   for(int i=0; i<50; ++i)
   {  	  
    int valor = buffer.extraer();
    cout<<"Consumidor "<<id<<" extrajo "<<valor<<endl;
   } 
  }

int main()
{
  Buffer buffer(200);
  thread c1(consumidor, 0, ref(buffer));
  thread c2(consumidor, 1, ref(buffer));
  thread p1(productor, 0, ref(buffer));
  c1.join();
  c2.join();
  p1.join();
  return(0);
}	
