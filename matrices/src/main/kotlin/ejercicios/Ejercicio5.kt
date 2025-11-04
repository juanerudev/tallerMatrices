package org.example.ejercicios

import org.example.utilidades.UtilidadesMatrices

object Ejercicio5 {
    fun ejecutar() {
        println("\n=== EJERCICIO 5 ===")
        println("Verificar si una matriz es rala")
        println("===============================")

        // Leer dimensiones
        print("Ingrese número de filas (N): ")
        val n = readLine()!!.toInt()
        print("Ingrese número de columnas (M): ")
        val m = readLine()!!.toInt()

        // Leer matriz
        val matriz = UtilidadesMatrices.leerMatriz(n, m)

        // Verificar si es rala
        val esRala = verificarMatrizRala(matriz)

        // Mostrar resultados
        println("\nMatriz ingresada:")
        UtilidadesMatrices.imprimirMatriz(matriz)

        if (esRala) {
            println("\n✓ La matriz ES rala")
        } else {
            println("\n✗ La matriz NO es rala")
        }
    }

    private fun verificarMatrizRala(matriz: Array<IntArray>): Boolean {
        val filas = matriz.size
        val columnas = matriz[0].size

        // Verificar que cada fila tenga exactamente un 1 y los demás 0
        for (i in 0 until filas) {
            var unosEnFila = 0
            for (j in 0 until columnas) {
                if (matriz[i][j] == 1) {
                    unosEnFila++
                } else if (matriz[i][j] != 0) {
                    return false // Si hay algún número diferente de 0 o 1, no es rala
                }
            }
            if (unosEnFila != 1) return false
        }

        // Verificar que cada columna tenga exactamente un 1 y los demás 0
        for (j in 0 until columnas) {
            var unosEnColumna = 0
            for (i in 0 until filas) {
                if (matriz[i][j] == 1) {
                    unosEnColumna++
                }
            }
            if (unosEnColumna != 1) return false
        }

        return true
    }
}