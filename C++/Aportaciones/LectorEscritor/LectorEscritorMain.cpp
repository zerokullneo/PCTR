//
// Created by zerokullneo on 18/10/21.
//

//#include "LectorEscritor.hpp"
#include <vector>
#include <iostream>
#include <string>
#include <thread>
#include <mutex>
#include <condition_variable>

std::string shared_array;
std::mutex lock;
std::condition_variable rcond, wcond;
bool string_read = false;

//Lector thread
void Lector()
{
    std::unique_lock<std::mutex> rwlock(lock);
    std::cerr << "Esperando Lector...." << std::endl;
    rcond.wait(rwlock, []{return string_read == true;});

    std::cout << "\n[Hilo - Lector]Introduzca una cadena (100 caracteres): " << std::endl;
    std::cin >> shared_array;
}

//Escritor thread
void Escritor()
{
    std::lock_guard <std::mutex> rwlock(lock);
    std::cerr << "Esperando Escritor..." << std::endl;
    //wcond.wait(rwlock, []{return string_read == false;});
    std::cout << "\n[Hilo - Escritor]La cadena introducida es: " << shared_array << std::endl;
    string_read = true;
    rcond.notify_all();
}

int main()
{
    unsigned int resources = 10, i;
    //LectorEscritor LS;

    std::vector<std::thread> tr[resources];
    std::vector<std::thread> tw[resources];

    for(i = 0; i < resources; ++i)
    {
        if(i & 1)
        {
            tr[i].push_back(std::move(std::thread(Lector)));
            tw[i].push_back(std::move(std::thread(Escritor)));
        }
        else
        {
            tw[i].push_back(std::move(std::thread(Escritor)));
            tr[i].push_back(std::move(std::thread(Lector)));
        }
    }

    for(i = 0; i < resources; ++i)
    {
        tr[i].data()->join();
        tw[i].data()->join();
    }
}