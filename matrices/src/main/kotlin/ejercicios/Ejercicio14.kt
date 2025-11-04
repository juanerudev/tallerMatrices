package org.example.ejercicios

object Ejercicio14 {
    fun ejecutar() {
        println("\n=== EJERCICIO 14 ===")
        println("Generar matriz espiral hacia afuera (N impar > 3)")
        println("=================================================")

        var n: Int
        do {
            print("Ingrese el valor de N (impar y mayor que 3): ")
            n = readLine()!!.toInt()

            if (n <= 3 || n % 2 == 0) {
                println("Error: N debe ser impar y mayor que 3")
            }
        } while (n <= 3 || n % 2 == 0)

        // Generar la matriz espiral
        val matriz = generarMatrizEspiral(n)

        // Mostrar la matriz
        println("\nMatriz generada ($n x $n):")
        imprimirMatrizFormateada(matriz)
    }

    private fun generarMatrizEspiral(n: Int): Array<IntArray> {
        val matriz = Array(n) { IntArray(n) }
        var valor = n * n
        var filaInicio = 0
        var filaFin = n - 1
        var colInicio = 0
        var colFin = n - 1

        while (valor >= 1) {
            // Izquierda: de arriba hacia abajo
            for (i in filaInicio..filaFin) {
                matriz[i][colInicio] = valor
                valor--
            }
            colInicio++

            // Abajo: de izquierda a derecha
            for (j in colInicio..colFin) {
                matriz[filaFin][j] = valor
                valor--
            }
            filaFin--

            // Derecha: de abajo hacia arriba
            for (i in filaFin downTo filaInicio) {
                matriz[i][colFin] = valor
                valor--
            }
            colFin--

            // Arriba: de derecha a izquierda
            for (j in colFin downTo colInicio) {
                matriz[filaInicio][j] = valor
                valor--
            }
            filaInicio++
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