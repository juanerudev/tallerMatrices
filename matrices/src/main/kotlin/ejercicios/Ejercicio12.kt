package org.example.ejercicios

object Ejercicio12 {
    fun ejecutar() {
        println("\n=== EJERCICIO 12 ===")
        println("Generar patrón de matriz N x N (N impar > 3)")
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
        val matriz = generarMatrizPatron(n)

        // Mostrar la matriz
        println("\nMatriz generada ($n x $n):")
        imprimirMatrizSimple(matriz)
    }

    private fun generarMatrizPatron(n: Int): Array<IntArray> {
        val matriz = Array(n) { IntArray(n) }
        val centro = n / 2

        for (i in 0 until n) {
            for (j in 0 until n) {
                when {
                    // Esquinas - siempre 4
                    (i == 0 && j == 0) || (i == 0 && j == n-1) ||
                            (i == n-1 && j == 0) || (i == n-1 && j == n-1) -> matriz[i][j] = 4

                    // Cruz central completa
                    i == centro || j == centro -> matriz[i][j] = 1

                    // Bordes superior e inferior (sin esquinas)
                    i == 0 || i == n-1 -> matriz[i][j] = 1

                    // Bordes izquierdo y derecho (sin esquinas)
                    j == 0 || j == n-1 -> matriz[i][j] = 1

                    // Resto del interior
                    else -> matriz[i][j] = 4
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