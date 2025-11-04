package org.example.ejercicios

object Ejercicio15 {
    fun ejecutar() {
        println("\n=== EJERCICIO 15 ===")
        println("Generar matriz en patrón diagonal (N impar > 3)")
        println("===============================================")

        var n: Int
        do {
            print("Ingrese el valor de N (impar y mayor que 3): ")
            n = readLine()!!.toInt()

            if (n <= 3 || n % 2 == 0) {
                println("Error: N debe ser impar y mayor que 3")
            }
        } while (n <= 3 || n % 2 == 0)

        // Generar la matriz en patrón diagonal
        val matriz = generarMatrizDiagonal(n)

        // Mostrar la matriz
        println("\nMatriz generada ($n x $n):")
        imprimirMatrizFormateada(matriz)
    }

    private fun generarMatrizDiagonal(n: Int): Array<IntArray> {
        val matriz = Array(n) { IntArray(n) }
        var valor = 1

        // Llenar las diagonales en zigzag
        for (diagonal in 0 until 2 * n - 1) {
            if (diagonal % 2 == 0) {
                // Diagonal par: de abajo hacia arriba
                var i = minOf(diagonal, n - 1)
                var j = diagonal - i
                while (i >= 0 && j < n) {
                    matriz[i][j] = valor
                    valor++
                    i--
                    j++
                }
            } else {
                // Diagonal impar: de arriba hacia abajo
                var j = minOf(diagonal, n - 1)
                var i = diagonal - j
                while (j >= 0 && i < n) {
                    matriz[i][j] = valor
                    valor++
                    i++
                    j--
                }
            }
        }

        return matriz
    }

    private fun imprimirMatrizFormateada(matriz: Array<IntArray>) {
        for (i in matriz.indices) {
            for (j in matriz[i].indices) {
                print("%2d ".format(matriz[i][j]))
            }
            println()
        }
    }
}