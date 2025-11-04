package org.example.ejercicios

import org.example.utilidades.UtilidadesMatrices

object Ejercicio8 {
    fun ejecutar() {
        println("\n=== EJERCICIO 8 ===")
        println("Reemplazar negativos por 0 y positivos por 9")
        println("=============================================")

        // Leer dimensión de la matriz cuadrada
        print("Ingrese el orden de la matriz cuadrada (N): ")
        val n = readLine()!!.toInt()

        // Leer matriz original
        println("\nMatriz original:")
        val matriz = UtilidadesMatrices.leerMatriz(n, n)

        // Mostrar matriz original
        println("\n--- MATRIZ ORIGINAL ---")
        UtilidadesMatrices.imprimirMatriz(matriz)

        // Reemplazar elementos en la misma matriz (sin usar matriz auxiliar)
        reemplazarElementos(matriz)

        // Mostrar matriz modificada
        println("\n--- MATRIZ MODIFICADA ---")
        println("(Negativos → 0, Positivos → 9)")
        UtilidadesMatrices.imprimirMatriz(matriz)
    }

    private fun reemplazarElementos(matriz: Array<IntArray>) {
        for (i in matriz.indices) {
            for (j in matriz[i].indices) {
                when {
                    matriz[i][j] < 0 -> matriz[i][j] = 0
                    matriz[i][j] > 0 -> matriz[i][j] = 9
                    // Si es cero, se mantiene igual
                }
            }
        }
    }
}