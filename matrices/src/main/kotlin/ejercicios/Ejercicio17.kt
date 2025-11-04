package org.example.ejercicios

object Ejercicio17 {
    fun ejecutar() {
        println("\n=== EJERCICIO 17 ===")
        println("Generar matriz con patrón de X en los bordes")
        println("============================================")

        var n: Int
        do {
            print("Ingrese el valor de N (impar y mayor que 3): ")
            n = readLine()!!.toInt()

            if (n <= 3 || n % 2 == 0) {
                println("Error: N debe ser impar y mayor que 3")
            }
        } while (n <= 3 || n % 2 == 0)

        // Generar la matriz con el patrón
        val matriz = generarMatrizPatronX(n)

        // Mostrar la matriz
        println("\nMatriz generada ($n x $n):")
        imprimirMatrizSimple(matriz)
    }

    private fun generarMatrizPatronX(n: Int): Array<IntArray> {
        val matriz = Array(n) { IntArray(n) { 0 } } // Inicializar con ceros
        val centro = n / 2

        // Bordes superior e inferior
        for (j in 0 until n) {
            matriz[0][j] = 1       // Primera fila
            matriz[n-1][j] = 1     // Última fila
        }

        // Diagonales secundarias
        for (i in 0 until n) {
            // Diagonal secundaria (de esquina superior derecha a inferior izquierda)
            matriz[i][n-1-i] = 1
        }

        return matriz
    }

    private fun imprimirMatrizSimple(matriz: Array<IntArray>) {
        for (i in matriz.indices) {
            for (j in matriz[i].indices) {
                print("${matriz[i][j]}  ")
            }
            println()
        }
    }
}