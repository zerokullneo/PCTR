/**
 * Autor del código: Miguel Ángel Gavilán Merino - Miangame

 * Cena de los filósofos con semáforos.
 * Durante el tiempo que un filósofo está comiendo o pensando permanecerá
 * bloqueado un número aleatorio de segundos entre 0 y 10.
 */
/**
 * Modificado por José Manuel Barba González - zerokullneo
 * Se modifica el código para que funcione de la misma forma en C++
 * con las las librerías de concurrencia incluidas en la STD c++20
 */

#ifndef C_CENAFILOSOFOS_HPP
#define C_CENAFILOSOFOS_HPP
#include <iostream>
#include <cstdlib>
#include <thread>
#include <mutex>
#include <semaphore>
#include <condition_variable>
#include <vector>

using namespace std;

#define N 5 //Numero de filósofos
#define VIDA 3 //número de veces que se ejecutará cada thread, simulando primer y segundo plato y postre.
#define IZQUIERDA(x)	((x) !=0 ? (x)-1 : (N-1)) //Calcula el filósofo de la izquierda
#define DERECHA(x)		(((x)+1)%N) //Calcula el filósofo de la derecha

typedef enum{
    PENSANDO,HAMBRIENTO,COMIENDO
}status;

mutex cerrojoMutex;
vector<status> estado{N}; //Estado en el que esta cada proceso en cada momento (pensando, hambriento o comiendo)
binary_semaphore tenedorOcupado(0);
//sem_t mutex,s[N]; //Mutex: Solo un filosofo puede coger o soltar tenedores; s[N]: Controlamos si he podido
            // coger tenedores o no, si no he podido, me bloqueo hasta que nos despierte el filosofo de la izquierda o derecha


void Filosofo(int i);
void pensar(int id);
void comer(int id);
void coger_tenedores(int id);
void Comprobar(int id);
void soltar_tenedores(int id);

void Filosofo(int i)
{
    int id, j;
    id = i;

    for(j = 0; j < VIDA; j++)
    {
        pensar(id);
        //this_thread::sleep_for(1s);
        coger_tenedores(id);
        comer(id);
        //this_thread::sleep_for(1s);
        soltar_tenedores(id);
    }
}

void pensar(int id)
{
    cerrojoMutex.lock();
    cout << "Filosofo " << id << " pensando\n";
    this_thread::sleep_for(1s);
    cerrojoMutex.unlock();
}

void comer(int id)
{
    cerrojoMutex.lock();
    cout << "Filosofo " << id << " comiendo\n";
    this_thread::sleep_for(1s);
    cerrojoMutex.unlock();
}

void coger_tenedores(int id)
{
    //sem_wait(&mutex); //Si un filósofo está cogiendo tenedores, no podre coger y me quedaré bloqueado. Si no hay nadie cogiendo tenedores, cogeré yo
    cerrojoMutex.lock();

    estado[id] = HAMBRIENTO;
    Comprobar(id);

    //sem_post(&mutex); //Permito que otro filósofo coja tenedores
    cerrojoMutex.unlock();

    //sem_wait(&s[id]); //Si no hace el post de la function Comprobar(), se quedaría pillado aquí
    tenedorOcupado.acquire();
}

void Comprobar(int id)
{
    if(estado[id] == HAMBRIENTO and estado[IZQUIERDA(id)] != COMIENDO and estado[DERECHA(id)] != COMIENDO)
    {
        estado[id]=COMIENDO;

        //sem_post(&s[id]); //Sirve para liberar al filósofo para que no se quede pillado más adelante, puesto que ha podido coger tenedores
        tenedorOcupado.release();
    }
}

void soltar_tenedores(int id)
{
    //sem_wait(&mutex); //Si hay alguien cogiendo tenedores, nadie más puede coger. Si estoy cogiendo tenedores, bloqueo para que nadie más pueda hacerlo
    cerrojoMutex.lock();

    estado[id]=PENSANDO;
    Comprobar(IZQUIERDA(id));
    Comprobar(DERECHA(id));

    //sem_post(&mutex);
    cerrojoMutex.unlock();
}
#endif //C_CENAFILOSOFOS_HPP
