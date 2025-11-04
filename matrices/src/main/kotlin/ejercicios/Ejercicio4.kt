package org.example.ejercicios

import org.example.utilidades.UtilidadesMatrices

object Ejercicio4 {
    fun ejecutar() {
        println("\n=== EJERCICIO 4 ===")
        println("Suma de dos matrices")
        println("====================")

        // Leer dimensiones
        print("Ingrese número de filas: ")
        val filas = readLine()!!.toInt()
        print("Ingrese número de columnas: ")
        val columnas = readLine()!!.toInt()

        // Leer matriz A
        println("\nMatriz A:")
        val matrizA = UtilidadesMatrices.leerMatriz(filas, columnas)

        // Leer matriz B
        println("\nMatriz B:")
        val matrizB = UtilidadesMatrices.leerMatriz(filas, columnas)

        // Sumar matrices
        val matrizSuma = Array(filas) { i ->
            IntArray(columnas) { j ->
                matrizA[i][j] + matrizB[i][j]
            }
        }

        // Mostrar resultados
        println("\nMatriz A:")
        UtilidadesMatrices.imprimirMatriz(matrizA)

        println("\nMatriz B:")
        UtilidadesMatrices.imprimirMatriz(matrizB)

        println("\nMatriz A + B:")
        UtilidadesMatrices.imprimirMatriz(matrizSuma)
    }
}