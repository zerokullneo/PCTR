//
// Created by zerokullneo on 18/10/21.
//

#ifndef C_LECTORESCRITOR_H
#define C_LECTORESCRITOR_H

#include <iostream>
#include <thread>
#include <mutex>
#include <condition_variable>

char shared_array[204];
std::mutex lock;
std::unique_lock<std::mutex> rwlock(lock);
std::condition_variable rcond, wcond;

int string_read = false;

class LectorEscritor
{
    public:
        //Reader thread
        void Lector();
        //Writer thread
        void Escritor();
};

#endif //C_LECTORESCRITOR_H
