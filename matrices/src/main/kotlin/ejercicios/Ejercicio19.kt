package org.example.ejercicios

object Ejercicio19 {
    fun ejecutar() {
        println("\n=== EJERCICIO 19 ===")
        println("Generar matriz espiral hacia adentro desde el centro")
        println("====================================================")

        var n: Int
        do {
            print("Ingrese el valor de N (impar y mayor que 3): ")
            n = readLine()!!.toInt()

            if (n <= 3 || n % 2 == 0) {
                println("Error: N debe ser impar y mayor que 3")
            }
        } while (n <= 3 || n % 2 == 0)

        // Generar la matriz espiral hacia adentro
        val matriz = generarMatrizEspiralAdentro(n)

        // Mostrar la matriz
        println("\nMatriz generada ($n x $n):")
        imprimirMatrizFormateada(matriz)
    }

    private fun generarMatrizEspiralAdentro(n: Int): Array<IntArray> {
        val matriz = Array(n) { IntArray(n) }
        var valor = n * n
        var filaInicio = 0
        var filaFin = n - 1
        var colInicio = 0
        var colFin = n - 1

        while (valor >= 1) {
            // Abajo: de derecha a izquierda
            for (j in colFin downTo colInicio) {
                matriz[filaFin][j] = valor
                valor--
            }
            filaFin--

            // Izquierda: de abajo hacia arriba
            for (i in filaFin downTo filaInicio) {
                matriz[i][colInicio] = valor
                valor--
            }
            colInicio++

            // Arriba: de izquierda a derecha
            for (j in colInicio..colFin) {
                matriz[filaInicio][j] = valor
                valor--
            }
            filaInicio++

            // Derecha: de arriba hacia abajo
            for (i in filaInicio..filaFin) {
                matriz[i][colFin] = valor
                valor--
            }
            colFin--
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