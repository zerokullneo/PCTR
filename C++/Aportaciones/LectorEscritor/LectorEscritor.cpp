//
// Created by zerokullneo on 18/10/21.
//

#include "LectorEscritor.hpp"
/* compile with gcc -pthread *.c -o ./prod_consumer
 */

//Reader thread
void LectorEscritor::Lector()
{
    while(true)
    {
        rwlock.lock();
        while(string_read)
            wcond.wait(rwlock, []{return true;});

        std::cout << "\n[TH1] Enter a string (100 characters): " << std::endl;
        std::cin >> shared_array; //unsafe with more than 204 characters
        string_read = true;
        rwlock.unlock();
        rcond.notify_all();
    }
}

//Writer thread
void LectorEscritor::Escritor()
{
    while(true)
    {
        rwlock.lock();
        while(!string_read)
            rcond.wait(rwlock, []{return true;});

        std::cout << "\n[TH2]The string entered is: " << shared_array << std::endl;
        string_read = false;
        rwlock.unlock();
        wcond.notify_all();
    }
}