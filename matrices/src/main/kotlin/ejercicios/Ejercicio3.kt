package org.example.ejercicios

import org.example.utilidades.UtilidadesMatrices

object Ejercicio3 {
    fun ejecutar() {
        println("\n=== EJERCICIO 3 ===")
        println("Transpuesta de una matriz")
        println("=========================")

        // Leer dimensiones de la matriz
        print("Ingrese el número de filas (A): ")
        val a = readLine()!!.toInt()
        print("Ingrese el número de columnas (B): ")
        val b = readLine()!!.toInt()

        // Leer la matriz X
        println("\nLeyendo matriz X ($a x $b):")
        val matrizX = UtilidadesMatrices.leerMatriz(a, b)

        // Calcular la transpuesta
        val matrizTranspuesta = calcularTranspuesta(matrizX)

        // Mostrar resultados
        mostrarResultados(matrizX, matrizTranspuesta)
    }

    private fun calcularTranspuesta(matriz: Array<IntArray>): Array<IntArray> {
        val filasOriginal = matriz.size
        val columnasOriginal = matriz[0].size

        // La transpuesta intercambia filas por columnas
        val transpuesta = Array(columnasOriginal) { IntArray(filasOriginal) }

        for (i in 0 until filasOriginal) {
            for (j in 0 until columnasOriginal) {
                transpuesta[j][i] = matriz[i][j]
            }
        }

        return transpuesta
    }

    private fun mostrarResultados(matrizOriginal: Array<IntArray>, matrizTranspuesta: Array<IntArray>) {
        val filasOriginal = matrizOriginal.size
        val columnasOriginal = matrizOriginal[0].size

        println("\n--- Matriz Original X ($filasOriginal x $columnasOriginal) ---")
        UtilidadesMatrices.imprimirMatriz(matrizOriginal)

        println("\n--- Matriz Transpuesta (${columnasOriginal} x ${filasOriginal}) ---")
        UtilidadesMatrices.imprimirMatriz(matrizTranspuesta)

        // Mostrar relación entre elementos
        println("\n--- Relación entre elementos ---")
        println("X[i][j] -> Transpuesta[j][i]")

        // Mostrar algunos ejemplos
        val ejemplos = minOf(3, minOf(filasOriginal, columnasOriginal))
        for (i in 0 until ejemplos) {
            for (j in 0 until ejemplos) {
                println("X[$i][$j] = ${matrizOriginal[i][j]} -> Transpuesta[$j][$i] = ${matrizTranspuesta[j][i]}")
            }
        }
    }
}