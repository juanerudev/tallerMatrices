package org.example.ejercicios

import org.example.utilidades.UtilidadesMatrices

object Ejercicio1 {
    fun ejecutar() {
        println("\n=== EJERCICIO 1 ===")
        println("Multiplicar matriz por escalar K")
        println("====================")

        // Leer dimensiones de la matriz
        print("Ingrese el número de filas (M): ")
        val m = readLine()!!.toInt()
        print("Ingrese el número de columnas (N): ")
        val n = readLine()!!.toInt()

        // Leer la matriz A
        val matrizA = UtilidadesMatrices.leerMatriz(m, n)

        // Leer el escalar K
        print("Ingrese el número K para multiplicar: ")
        val k = readLine()!!.toInt()

        // Multiplicar matriz por K
        val matrizResultado = multiplicarMatrizPorEscalar(matrizA, k)

        // Mostrar resultados
        println("\nMatriz original A:")
        UtilidadesMatrices.imprimirMatriz(matrizA)

        println("\nNúmero K: $k")

        println("\nMatriz resultado (A × K):")
        UtilidadesMatrices.imprimirMatriz(matrizResultado)
    }

    private fun multiplicarMatrizPorEscalar(matriz: Array<IntArray>, k: Int): Array<IntArray> {
        val filas = matriz.size
        val columnas = matriz[0].size
        val resultado = Array(filas) { IntArray(columnas) }

        for (i in 0 until filas) {
            for (j in 0 until columnas) {
                resultado[i][j] = matriz[i][j] * k
            }
        }
        return resultado
    }
}