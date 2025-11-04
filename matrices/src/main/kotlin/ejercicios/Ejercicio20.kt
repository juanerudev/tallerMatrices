package org.example.ejercicios

object Ejercicio20 {
    fun ejecutar() {
        println("\n=== EJERCICIO 20 ===")
        println("Generar matriz espiral hacia afuera desde el centro")
        println("===================================================")

        var n: Int
        do {
            print("Ingrese el valor de N (impar y mayor que 3): ")
            n = readLine()!!.toInt()

            if (n <= 3 || n % 2 == 0) {
                println("Error: N debe ser impar y mayor que 3")
            }
        } while (n <= 3 || n % 2 == 0)

        // Generar la matriz espiral hacia afuera
        val matriz = generarMatrizEspiralAfuera(n)

        // Mostrar la matriz
        println("\nMatriz generada ($n x $n):")
        imprimirMatrizFormateada(matriz)
    }

    private fun generarMatrizEspiralAfuera(n: Int): Array<IntArray> {
        val matriz = Array(n) { IntArray(n) }
        var valor = 1

        var filaInicio = 0
        var filaFin = n - 1
        var colInicio = 0
        var colFin = n - 1

        while (valor <= n * n) {
            // Arriba: de izquierda a derecha
            for (j in colInicio..colFin) {
                matriz[filaInicio][j] = valor
                valor++
            }
            filaInicio++

            // Derecha: de arriba hacia abajo
            for (i in filaInicio..filaFin) {
                matriz[i][colFin] = valor
                valor++
            }
            colFin--

            // Abajo: de derecha a izquierda
            for (j in colFin downTo colInicio) {
                matriz[filaFin][j] = valor
                valor++
            }
            filaFin--

            // Izquierda: de abajo hacia arriba
            for (i in filaFin downTo filaInicio) {
                matriz[i][colInicio] = valor
                valor++
            }
            colInicio++
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