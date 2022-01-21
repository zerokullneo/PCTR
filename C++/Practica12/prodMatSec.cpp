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
 * clang++ -std=c++17 -o prodMatSec prodMatSec.cpp
 */


#include <chrono>
#include <ctime>
#include "prodMatSec.hpp"

/**
 * Constructor base de la clase con el parametro para la dimension de la matriz.
 * @param tam parametro que indica la dimension de la matriz.
 */
prodMatSec::prodMatSec(int tam):m(tam), op(0),
matrizA(m, vector<int>(m)), matrizB(m, vector<int>(m)), matrizResultado(m, vector<int>(m))
{
    //Seed with a real random value, if available
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
 */
void prodMatSec::multiplicacion()
{
    cout << "Multiplicando Matrices..." << endl;
    for(int i = 0; i < m; i++)
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
void prodMatSec::VerMatrizResultado()
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
void prodMatSec::VerMatriz(int M)
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
    chrono::time_point<chrono::system_clock> timeini, timefin;
    time_t timeHoraIni, timeHoraFin;

    cout<< "Introducir el tamaño n de la matriz nxn: ";
    cin >> n;
    cout << endl;

    timeini = chrono::system_clock::now();
    prodMatSec productoSecuencial(n);
    timefin = chrono::system_clock::now();

    chrono::duration<double> timeCrearMatriz = timefin-timeini;
    timeHoraIni = chrono::system_clock::to_time_t(timeini);
    timeHoraFin = chrono::system_clock::to_time_t(timefin);

    cout << "Tiempo en Crear Matrices: " << timeCrearMatriz.count() <<
         "s\nIniciado a las:" << ctime(&timeHoraIni) << "\nTerminado a las: " << ctime(&timeHoraFin) << endl;

    if(n <= 30)
    {
        productoSecuencial.VerMatriz('A');
        productoSecuencial.VerMatriz('B');
    }

    timeini = chrono::system_clock::now();
    productoSecuencial.multiplicacion();
    timefin = chrono::system_clock::now();

    chrono::duration<double> timeTranscurrido = timefin-timeini;
    timeHoraIni = chrono::system_clock::to_time_t(timeini);
    timeHoraFin = chrono::system_clock::to_time_t(timefin);

    if (n <= 30)
        productoSecuencial.VerMatrizResultado();

    cout << "Tiempo en Multiplicar Matrices: " << timeTranscurrido.count() <<
    "s\nIniciado a las:" << ctime(&timeHoraIni) << "\nTerminado a las: " << ctime(&timeHoraFin) << endl;
    return 0;
}