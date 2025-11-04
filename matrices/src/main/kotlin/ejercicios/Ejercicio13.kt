package org.example.ejercicios

object Ejercicio13 {
    fun ejecutar() {
        println("\n=== EJERCICIO 13 ===")
        println("Generar matriz con marco de 1 e interior de 0 (N impar > 3)")
        println("===========================================================")

        var n: Int
        do {
            print("Ingrese el valor de N (impar y mayor que 3): ")
            n = readLine()!!.toInt()

            if (n <= 3 || n % 2 == 0) {
                println("Error: N debe ser impar y mayor que 3")
            }
        } while (n <= 3 || n % 2 == 0)

        // Generar la matriz con el patrón
        val matriz = generarMatrizMarco(n)

        // Mostrar la matriz
        println("\nMatriz generada ($n x $n):")
        imprimirMatrizSimple(matriz)
    }

    private fun generarMatrizMarco(n: Int): Array<IntArray> {
        val matriz = Array(n) { IntArray(n) { 0 } } // Inicializar toda la matriz con 0

        for (i in 0 until n) {
            for (j in 0 until n) {
                // Poner 1 en los bordes (primera y última fila, primera y última columna)
                if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
                    matriz[i][j] = 1
                }
            }
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