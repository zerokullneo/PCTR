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

#ifndef C_PRODMATPAR_HPP
#define C_PRODMATPAR_HPP

#include <iostream>
#include <cstdlib>
#include <vector>
#include <random>

using namespace std;

class prodMatPar
{
    public:
        /**
         * Constructor base de la clase con el parametro para la dimension de la matriz.
         * @param tam parametro que indica la dimension de la matriz.
         * @param ini parametro que indica el inicio de la parte en las que se divide la matriz en numero de hilos
         * @param fin parametro que indica el final de la parte en las que se divide la matriz en numero de hilos
         */
        prodMatPar(int tam, int ini, int fin);

        /**
         * Metodo para multiplicar matrices.
         * @param fini parametro fila de inicio.
         * @param ffin parametro fila de final.
         */
        void multiplicacion(int fini, int ffin);

        /**
         * metodo para visualizar la matriz resultado de la multiplicacion.
         */
        void VerMatrizResultado();

        /**
         * metodo para visualizar la matriz A o B seleccionada por el parametro M.
         * @param M parametro que distingue que matriz se va a mostrar.
         */
        void VerMatriz(int M);

    private:
        /**
         * Dimensión de la matriz cuadrada.
         */
        int m;
        /**
         * Parte u operando para el cálculo parical de la multiplicación.
         */
        int op, fini, ffin;
        /**
         * Matriz Multiplicativa A.
         */
        vector<vector<int>> matrizA;
        /**
         * Matriz Multiplicativa B.
         */
        vector<vector<int>> matrizB;
        /**
         * Matriz de resultados.
         */
        vector<vector<int>> matrizResultado;
};
#endif //C_PRODMATPAR_HPP
