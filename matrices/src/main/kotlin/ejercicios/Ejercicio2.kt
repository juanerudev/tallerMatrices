package org.example.ejercicios

import org.example.utilidades.UtilidadesMatrices

object Ejercicio2 {
    fun ejecutar() {
        println("\n=== EJERCICIO 2 ===")
        println("Diagonales y matrices triangulares de matriz cuadrada")
        println("=====================================================")

        // Leer tamaño de la matriz cuadrada
        print("Ingrese el orden de la matriz cuadrada (P): ")
        val p = readLine()!!.toInt()

        // Leer la matriz C
        val matrizC = UtilidadesMatrices.leerMatriz(p, p)

        // Mostrar resultados
        println("\nMatriz C original ($p x $p):")
        UtilidadesMatrices.imprimirMatriz(matrizC)

        mostrarDiagonalPrincipal(matrizC)
        mostrarDiagonalSecundaria(matrizC)
        mostrarTriangularSuperior(matrizC)
        mostrarTriangularInferior(matrizC)
    }

    private fun mostrarDiagonalPrincipal(matriz: Array<IntArray>) {
        println("\n--- Diagonal Principal ---")
        print("Elementos: ")
        for (i in matriz.indices) {
            print("${matriz[i][i]} ")
        }
        println()
    }

    private fun mostrarDiagonalSecundaria(matriz: Array<IntArray>) {
        println("\n--- Diagonal Secundaria ---")
        print("Elementos: ")
        val n = matriz.size
        for (i in matriz.indices) {
            print("${matriz[i][n - 1 - i]} ")
        }
        println()
    }

    private fun mostrarTriangularSuperior(matriz: Array<IntArray>) {
        println("\n--- Matriz Triangular Superior ---")
        val n = matriz.size
        val triangularSuperior = Array(n) { IntArray(n) }

        for (i in 0 until n) {
            for (j in 0 until n) {
                if (j >= i) {
                    triangularSuperior[i][j] = matriz[i][j]
                } else {
                    triangularSuperior[i][j] = 0
                }
            }
        }
        UtilidadesMatrices.imprimirMatriz(triangularSuperior)
    }

    private fun mostrarTriangularInferior(matriz: Array<IntArray>) {
        println("\n--- Matriz Triangular Inferior ---")
        val n = matriz.size
        val triangularInferior = Array(n) { IntArray(n) }

        for (i in 0 until n) {
            for (j in 0 until n) {
                if (j <= i) {
                    triangularInferior[i][j] = matriz[i][j]
                } else {
                    triangularInferior[i][j] = 0
                }
            }
        }
        UtilidadesMatrices.imprimirMatriz(triangularInferior)
    }
}