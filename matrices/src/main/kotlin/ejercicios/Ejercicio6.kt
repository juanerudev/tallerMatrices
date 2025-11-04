package org.example.ejercicios

import org.example.utilidades.UtilidadesMatrices

object Ejercicio6 {
    fun ejecutar() {
        println("\n=== EJERCICIO 6 ===")
        println("Suma y multiplicación de matrices")
        println("================================")

        // Leer dimensiones
        print("Ingrese número de filas (N): ")
        val n = readLine()!!.toInt()
        print("Ingrese número de columnas (M): ")
        val m = readLine()!!.toInt()

        // Leer matriz A
        println("\nMatriz A:")
        val matrizA = UtilidadesMatrices.leerMatriz(n, m)

        // Leer matriz B
        println("\nMatriz B:")
        val matrizB = UtilidadesMatrices.leerMatriz(n, m)

        // a) Suma de matrices
        val matrizSuma = sumarMatrices(matrizA, matrizB)

        // b) Multiplicación de matrices (si es posible)
        val matrizMultiplicacion = multiplicarMatrices(matrizA, matrizB)

        // Mostrar resultados
        mostrarResultados(matrizA, matrizB, matrizSuma, matrizMultiplicacion)
    }

    private fun sumarMatrices(matrizA: Array<IntArray>, matrizB: Array<IntArray>): Array<IntArray> {
        val filas = matrizA.size
        val columnas = matrizA[0].size
        return Array(filas) { i ->
            IntArray(columnas) { j ->
                matrizA[i][j] + matrizB[i][j]
            }
        }
    }

    private fun multiplicarMatrices(matrizA: Array<IntArray>, matrizB: Array<IntArray>): Array<IntArray>? {
        val filasA = matrizA.size
        val columnasA = matrizA[0].size
        val filasB = matrizB.size
        val columnasB = matrizB[0].size

        // Verificar si la multiplicación es posible
        if (columnasA != filasB) {
            return null
        }

        val resultado = Array(filasA) { IntArray(columnasB) }

        for (i in 0 until filasA) {
            for (j in 0 until columnasB) {
                for (k in 0 until columnasA) {
                    resultado[i][j] += matrizA[i][k] * matrizB[k][j]
                }
            }
        }

        return resultado
    }

    private fun mostrarResultados(
        matrizA: Array<IntArray>,
        matrizB: Array<IntArray>,
        matrizSuma: Array<IntArray>,
        matrizMultiplicacion: Array<IntArray>?
    ) {
        println("\n--- MATRIZ A ---")
        UtilidadesMatrices.imprimirMatriz(matrizA)

        println("\n--- MATRIZ B ---")
        UtilidadesMatrices.imprimirMatriz(matrizB)

        println("\n--- SUMA (A + B) ---")
        UtilidadesMatrices.imprimirMatriz(matrizSuma)

        println("\n--- MULTIPLICACIÓN (A × B) ---")
        if (matrizMultiplicacion != null) {
            UtilidadesMatrices.imprimirMatriz(matrizMultiplicacion)
        } else {
            println("No es posible multiplicar las matrices")
            println("(El número de columnas de A debe ser igual al número de filas de B)")
        }
    }
}