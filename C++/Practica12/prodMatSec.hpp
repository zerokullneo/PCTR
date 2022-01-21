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

#ifndef C_PRODMATSEC_HPP
#define C_PRODMATSEC_HPP

#include <iostream>
#include <cstdlib>
#include <vector>
#include <random>

using namespace std;

class prodMatSec
{
    public:
        /**
         * Constructor base de la clase con el parametro para la dimension de la matriz.
         * @param tam parametro que indica la dimension de la matriz.
         */
        prodMatSec(int tam);

        /**
         * Metodo para multiplicar matrices.
         */
        void multiplicacion();

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
        int op;
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
#endif //C_PRODMATSEC_HPP
