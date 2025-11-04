package org.example.ejercicios

object Ejercicio18 {
    fun ejecutar() {
        println("\n=== EJERCICIO 18 ===")
        println("Generar matriz triangular inferior con patrón en espiral inversa")
        println("===============================================================")

        var n: Int
        do {
            print("Ingrese el valor de N (impar y mayor que 3): ")
            n = readLine()!!.toInt()

            if (n <= 3 || n % 2 == 0) {
                println("Error: N debe ser impar y mayor que 3")
            }
        } while (n <= 3 || n % 2 == 0)

        // Generar la matriz triangular inferior
        val matriz = generarMatrizTriangularInferior(n)

        // Mostrar la matriz
        println("\nMatriz generada ($n x $n):")
        imprimirMatrizFormateada(matriz)
    }

    private fun generarMatrizTriangularInferior(n: Int): Array<IntArray> {
        val matriz = Array(n) { IntArray(n) { 0 } } // Inicializar con ceros
        var valor = 1

        // Llenar por columnas de derecha a izquierda, de abajo hacia arriba
        for (col in n-1 downTo 0) {
            var fila = n-1
            var colActual = col

            // Llenar la diagonal desde la posición actual hacia arriba-izquierda
            while (fila >= 0 && colActual >= 0) {
                if (fila >= colActual) { // Solo llenar la triangular inferior
                    matriz[fila][colActual] = valor
                    valor++
                }
                fila--
                colActual--
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