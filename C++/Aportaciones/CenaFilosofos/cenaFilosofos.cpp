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

#include "cenaFilosofos.hpp"

int main()
{
    /*extern status estado[N];*/ //No es necesario
    /*extern sem_t mutex,s[N];*/ //No es necesario

    /**
     * Vector de ids de los filósofos
     * para decirle a cada hilo quien es
     */
    //int v[N];
    vector<int> v(N);

    int i, value;
    //sem_init(&mutex,0,1);

    /**
     * vector de thread de filósofos
     */
    //pthread_t filosofo[N];
    vector<thread> filosofo;

    //void *Filosofo(void* i);

	for(i = 0; i < N; i++) //NO SE PUEDEN LANZAR LOS HILOS HASTA QUE LOS SEMAFOROS NO ESTEN INICIALIZADOS
	{
        //sem_init(&s[i],0,0);
        filosofo.push_back(thread(Filosofo, i));
        estado[i]=PENSANDO;
        v[i] = i; //aquí se le dice a cada hilo quien es.
    }

    /* Esta sección no es necesaria con la concurrencia dada en es standard de C++
    for(i = 0; i < N; i++)
    {
        v[i] = i;
        if(value = pthread_create(&filosofo[i],NULL,Filosofo, (void *) &v[i]))
            exit(value);
    }*/

    for(i = 0; i < N; i++)
    {
        //pthread_join(filosofo[i],NULL);
        filosofo[i].join();
    }

    return 0;
}