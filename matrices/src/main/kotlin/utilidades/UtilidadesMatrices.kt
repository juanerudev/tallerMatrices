package org.example.utilidades

object UtilidadesMatrices {
    fun imprimirMatriz(matriz: Array<IntArray>) {
        for (fila in matriz) {
            for (elemento in fila) {
                print("$elemento\t")
            }
            println()
        }
    }

    fun leerMatriz(filas: Int, columnas: Int): Array<IntArray> {
        val matriz = Array(filas) { IntArray(columnas) }
        println("Ingrese los elementos de la matriz ($filas x $columnas):")

        for (i in 0 until filas) {
            for (j in 0 until columnas) {
                print("Elemento [$i][$j]: ")
                matriz[i][j] = readLine()!!.toInt()
            }
        }
        return matriz
    }
}