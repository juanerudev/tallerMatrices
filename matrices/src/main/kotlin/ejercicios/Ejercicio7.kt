package org.example.ejercicios

import org.example.utilidades.UtilidadesMatrices

object Ejercicio7 {
    fun ejecutar() {
        println("\n=== EJERCICIO 7 ===")
        println("Eliminar e insertar filas y columnas")
        println("====================================")

        // Leer dimensiones iniciales
        print("Ingrese número de filas (N): ")
        val n = readLine()!!.toInt()
        print("Ingrese número de columnas (M): ")
        val m = readLine()!!.toInt()

        // Leer matriz original
        println("\nMatriz original:")
        var matriz = UtilidadesMatrices.leerMatriz(n, m)

        // Mostrar matriz original
        println("\n--- MATRIZ ORIGINAL ---")
        UtilidadesMatrices.imprimirMatriz(matriz)

        // a) Eliminar fila x
        print("\nIngrese fila a eliminar (0-${n-1}): ")
        val filaEliminar = readLine()!!.toInt()
        if (filaEliminar in 0 until n) {
            matriz = eliminarFila(matriz, filaEliminar)
            println("--- MATRIZ SIN FILA $filaEliminar ---")
            UtilidadesMatrices.imprimirMatriz(matriz)
        } else {
            println("Fila no válida")
        }

        // b) Eliminar columna y
        print("\nIngrese columna a eliminar (0-${matriz[0].size-1}): ")
        val columnaEliminar = readLine()!!.toInt()
        if (columnaEliminar in 0 until matriz[0].size) {
            matriz = eliminarColumna(matriz, columnaEliminar)
            println("--- MATRIZ SIN COLUMNA $columnaEliminar ---")
            UtilidadesMatrices.imprimirMatriz(matriz)
        } else {
            println("Columna no válida")
        }

        // c) Insertar nueva fila en x
        print("\nIngrese posición para nueva fila (0-${matriz.size}): ")
        val filaInsertar = readLine()!!.toInt()
        if (filaInsertar in 0..matriz.size) {
            matriz = insertarFila(matriz, filaInsertar)
            println("--- MATRIZ CON NUEVA FILA EN $filaInsertar ---")
            UtilidadesMatrices.imprimirMatriz(matriz)
        } else {
            println("Posición no válida")
        }

        // d) Insertar nueva columna en y
        print("\nIngrese posición para nueva columna (0-${matriz[0].size}): ")
        val columnaInsertar = readLine()!!.toInt()
        if (columnaInsertar in 0..matriz[0].size) {
            matriz = insertarColumna(matriz, columnaInsertar)
            println("--- MATRIZ CON NUEVA COLUMNA EN $columnaInsertar ---")
            UtilidadesMatrices.imprimirMatriz(matriz)
        } else {
            println("Posición no válida")
        }
    }

    private fun eliminarFila(matriz: Array<IntArray>, fila: Int): Array<IntArray> {
        val nuevasFilas = matriz.size - 1
        val columnas = matriz[0].size
        val nuevaMatriz = Array(nuevasFilas) { IntArray(columnas) }

        var nuevaFila = 0
        for (i in matriz.indices) {
            if (i != fila) {
                for (j in 0 until columnas) {
                    nuevaMatriz[nuevaFila][j] = matriz[i][j]
                }
                nuevaFila++
            }
        }
        return nuevaMatriz
    }

    private fun eliminarColumna(matriz: Array<IntArray>, columna: Int): Array<IntArray> {
        val filas = matriz.size
        val nuevasColumnas = matriz[0].size - 1
        val nuevaMatriz = Array(filas) { IntArray(nuevasColumnas) }

        for (i in 0 until filas) {
            var nuevaColumna = 0
            for (j in 0 until matriz[i].size) {
                if (j != columna) {
                    nuevaMatriz[i][nuevaColumna] = matriz[i][j]
                    nuevaColumna++
                }
            }
        }
        return nuevaMatriz
    }

    private fun insertarFila(matriz: Array<IntArray>, posicion: Int): Array<IntArray> {
        val nuevasFilas = matriz.size + 1
        val columnas = matriz[0].size
        val nuevaMatriz = Array(nuevasFilas) { IntArray(columnas) }

        print("Ingrese los $columnas elementos de la nueva fila: ")
        val nuevaFila = readLine()!!.split(" ").map { it.toInt() }.toIntArray()

        var filaActual = 0
        for (i in 0 until nuevasFilas) {
            when {
                i < posicion -> nuevaMatriz[i] = matriz[i].copyOf()
                i == posicion -> nuevaMatriz[i] = nuevaFila
                else -> {
                    nuevaMatriz[i] = matriz[filaActual].copyOf()
                    filaActual++
                }
            }
        }
        return nuevaMatriz
    }

    private fun insertarColumna(matriz: Array<IntArray>, posicion: Int): Array<IntArray> {
        val filas = matriz.size
        val nuevasColumnas = matriz[0].size + 1
        val nuevaMatriz = Array(filas) { IntArray(nuevasColumnas) }

        print("Ingrese los $filas elementos de la nueva columna: ")
        val nuevaColumna = readLine()!!.split(" ").map { it.toInt() }.toIntArray()

        for (i in 0 until filas) {
            var columnaActual = 0
            for (j in 0 until nuevasColumnas) {
                when {
                    j < posicion -> nuevaMatriz[i][j] = matriz[i][j]
                    j == posicion -> nuevaMatriz[i][j] = nuevaColumna[i]
                    else -> {
                        nuevaMatriz[i][j] = matriz[i][columnaActual]
                        columnaActual++
                    }
                }
            }
        }
        return nuevaMatriz
    }
}