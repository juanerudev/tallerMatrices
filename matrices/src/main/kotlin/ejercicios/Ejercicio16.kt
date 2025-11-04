package org.example.ejercicios

object Ejercicio16 {
    fun ejecutar() {
        println("\n=== EJERCICIO 16 ===")
        println("Generar matriz triangular superior con patrón diagonal")
        println("======================================================")

        var n: Int
        do {
            print("Ingrese el valor de N (impar y mayor que 3): ")
            n = readLine()!!.toInt()

            if (n <= 3 || n % 2 == 0) {
                println("Error: N debe ser impar y mayor que 3")
            }
        } while (n <= 3 || n % 2 == 0)

        // Generar la matriz triangular superior
        val matriz = generarMatrizTriangularSuperior(n)

        // Mostrar la matriz
        println("\nMatriz generada ($n x $n):")
        imprimirMatrizFormateada(matriz)
    }

    private fun generarMatrizTriangularSuperior(n: Int): Array<IntArray> {
        val matriz = Array(n) { IntArray(n) { 0 } } // Inicializar con ceros
        var valor = 1

        // Llenar las diagonales de la triangular superior
        for (diagonal in 0 until n) {
            var i = 0
            var j = diagonal
            while (j < n) {
                matriz[i][j] = valor
                valor++
                i++
                j++
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