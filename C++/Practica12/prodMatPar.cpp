/**
* Copyright (C) 14/1/22 Jose Manuel Barba Gonzalez
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
/**
 * Orden linea de comando para la compilacion
 * clang++ -pthread -std=c++17 -o prodMatPar prodMatPar.cpp
 */

#include <chrono>
#include <ctime>
#include <thread>
#include "prodMatPar.hpp"

/**
 * Constructor base de la clase con el parametro para la dimension de la matriz.
 * @param tam parametro que indica la dimension de la matriz.
 * @param ini parametro que indica el inicio de la parte en las que se divide la matriz en numero de hilos
 * @param fin parametro que indica el final de la parte en las que se divide la matriz en numero de hilos
 */
prodMatPar::prodMatPar(int tam, int ini = 0, int fin = 0):m(tam), op(0), fini(ini), ffin(fin),
matrizA(m, vector<int>(m)), matrizB(m, vector<int>(m)), matrizResultado(m, vector<int>(m))
{
    //Semilla con un valor aleatorio real. Seed with a real random value, if available
    /*random_device r;
    default_random_engine e1(r());
    uniform_int_distribution<int> uniform_distA(1, 99);//selecciona una media aleatoria entre 1 y 99
    default_random_engine e2(r());
    uniform_int_distribution<int> uniform_distB(1, 99);//selecciona una media aleatoria entre 1 y 99
    */
    int medA, medB;

    cout << "Construyendo Matrices..." << endl;
    for(int i = 0; i < tam; i++)
    {
        for (int j = 0; j < tam; ++j)
        {
            //medA = uniform_distA(e1);
            medA = 1 + rand() % 100;
            matrizA[i][j] = medA;
            //std::cout << "numero aleatorio A: " << medA << std::endl;

            //medB = uniform_distB(e2);
            medB = 1 + rand() % 100;
            matrizB[i][j] = medB;
            //std::cout << "numero aleatorio B: " << medB << std::endl;
        }
    }
}

/**
 * Metodo para multiplicar matrices.
 * @param fini parametro fila de inicio.
 * @param ffin parametro fila de final.
 */
void prodMatPar::multiplicacion(int fini, int ffin)
{
    cout << "Multiplicando Matrices...\n";
    for(int i = fini; i < ffin; i++)
    {
        for(int j = 0; j < m; j++)
        {
            op = op + (matrizA[i][j] * matrizB[j][i]);
            matrizResultado[i][j] = op;
        }
        op = 0;
    }
}

/**
 * metodo para visualizar la matriz resultado de la multiplicacion.
 */
void prodMatPar::VerMatrizResultado()
{
    cout << "Ver Matriz Resultado" << endl;
    for (int i = 0; i < this->m; ++i) {
        cout << "[";
        for (int j = 0; j < this->m; ++j) {
            cout << this->matrizResultado[i][j];
            if(j < this->m - 1)
                cout << "\t";
        }
        cout << "]" << endl;
    }
}

/**
 * metodo para visualizar la matriz A o B seleccionada por el parametro M.
 * @param M parametro que distingue que matriz se va a mostrar.
 */
void prodMatPar::VerMatriz(int M)
{
    cout << "Ver Matriz" << endl;
    for (int i = 0; i < this->m; ++i)
    {
        cout << "[";
        for (int j = 0; j < this->m; ++j)
        {
            (M == 'A') ? cout << this->matrizA[i][j] : cout << this->matrizB[i][j];
            if(j < this->m - 1)
                cout << "\t";
        }
        cout << "]" << endl;
    }
}

int main()
{
    int n;
    chrono::time_point <chrono::system_clock> timeini, timefin;
    time_t timeHoraIni, timeHoraFin;
    unsigned int nNucleos = thread::hardware_concurrency();
    vector<thread> hilosMatrices;

    cout << "Introducir el tamaño n de la matriz nxn: ";
    cin >> n;
    cout << endl;

    timeini = chrono::system_clock::now();
    prodMatPar productoParalelo(n);
    timefin = chrono::system_clock::now();

    chrono::duration<double> timeCrearMatriz = timefin-timeini;
    timeHoraIni = chrono::system_clock::to_time_t(timeini);
    timeHoraFin = chrono::system_clock::to_time_t(timefin);

    cout << "Tiempo en Crear Matrices: " << timeCrearMatriz.count() <<
         "s\nIniciado a las:" << ctime(&timeHoraIni) << "\nTerminado a las: " << ctime(&timeHoraFin) << endl;

    if(n <= 30)
    {
        productoParalelo.VerMatriz('A');
        productoParalelo.VerMatriz('B');
    }

    int fini = 0, filas = (int)n/(nNucleos); int ffin = filas, auxfilas = (int)n % (nNucleos);
    cout << "División Matriz en partes (n/nNucleos): " << ffin << endl;
    timeini = chrono::system_clock::now();
    for(int i = 0; i < (nNucleos); i++)
    {
        if(auxfilas > 0)
        {
            ffin += 1;
            auxfilas--;
        }
        hilosMatrices.push_back(std::thread([&productoParalelo, fini, ffin, &filas, &auxfilas]()
        {
                productoParalelo.multiplicacion(fini, ffin);
        }));
        fini = ffin;
        ffin += filas;
    }

    //std::thread t1(productoParalelo.multiplicacion, 0, n/16);

    for(auto& ithm : hilosMatrices){
        ithm.join();
    }
    timefin = chrono::system_clock::now();

    chrono::duration<double> timeTranscurrido = timefin-timeini;
    timeHoraIni = chrono::system_clock::to_time_t(timeini);
    timeHoraFin = chrono::system_clock::to_time_t(timefin);

    if (n <= 30)
        productoParalelo.VerMatrizResultado();

    cout << "Tiempo en Multiplicar Matrices: " << timeTranscurrido.count() <<
         "s\nIniciado a las:" << ctime(&timeHoraIni) << "\nTerminado a las: " << ctime(&timeHoraFin) << endl;
    return 0;
}