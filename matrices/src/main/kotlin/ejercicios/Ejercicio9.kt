package org.example.ejercicios

import org.example.utilidades.UtilidadesMatrices

object Ejercicio9 {
    fun ejecutar() {
        println("\n=== EJERCICIO 9 ===")
        println("Análisis de ventas por sucursal")
        println("==============================")

        // Leer número de sucursales
        print("Ingrese el número de sucursales (N): ")
        val n = readLine()!!.toInt()

        // Leer matriz de ventas (N sucursales x 12 meses)
        println("\nIngrese las ventas de cada sucursal por mes:")
        val ventas = UtilidadesMatrices.leerMatriz(n, 12)

        // Realizar análisis
        val totalCompania = calcularTotalCompania(ventas)
        val totalesSucursales = calcularTotalesSucursales(ventas)
        val sucursalMaxima = encontrarSucursalMaxima(totalesSucursales)
        val mesMinimo = encontrarMesMinimo(ventas)

        // Mostrar resultados
        mostrarResultados(ventas, totalCompania, totalesSucursales, sucursalMaxima, mesMinimo)
    }

    private fun calcularTotalCompania(ventas: Array<IntArray>): Int {
        var total = 0
        for (sucursal in ventas) {
            for (venta in sucursal) {
                total += venta
            }
        }
        return total
    }

    private fun calcularTotalesSucursales(ventas: Array<IntArray>): IntArray {
        return IntArray(ventas.size) { i ->
            ventas[i].sum()
        }
    }

    private fun encontrarSucursalMaxima(totalesSucursales: IntArray): Pair<Int, Int> {
        var maxVentas = totalesSucursales[0]
        var sucursalMax = 0

        for (i in totalesSucursales.indices) {
            if (totalesSucursales[i] > maxVentas) {
                maxVentas = totalesSucursales[i]
                sucursalMax = i
            }
        }
        return Pair(sucursalMax, maxVentas)
    }

    private fun encontrarMesMinimo(ventas: Array<IntArray>): Pair<Int, Int> {
        val meses = arrayOf("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre")

        val totalesMeses = IntArray(12) { 0 }

        for (sucursal in ventas) {
            for (mes in sucursal.indices) {
                totalesMeses[mes] += sucursal[mes]
            }
        }

        var minVentas = totalesMeses[0]
        var mesMin = 0

        for (i in totalesMeses.indices) {
            if (totalesMeses[i] < minVentas) {
                minVentas = totalesMeses[i]
                mesMin = i
            }
        }
        return Pair(mesMin, minVentas)
    }

    private fun mostrarResultados(
        ventas: Array<IntArray>,
        totalCompania: Int,
        totalesSucursales: IntArray,
        sucursalMaxima: Pair<Int, Int>,
        mesMinimo: Pair<Int, Int>
    ) {
        val meses = arrayOf("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre")

        println("\n--- MATRIZ DE VENTAS ---")
        print("Suc\\Mes\t")
        meses.forEach { print("${it.take(3)}\t") }
        println()

        for (i in ventas.indices) {
            print("S${i+1}\t")
            for (j in ventas[i].indices) {
                print("${ventas[i][j]}\t")
            }
            println()
        }

        println("\n--- RESULTADOS ---")
        println("a) Total de ventas de la compañía: $totalCompania")

        println("\nb) Total de ventas por cada sucursal:")
        for (i in totalesSucursales.indices) {
            println("   Sucursal ${i+1}: ${totalesSucursales[i]}")
        }

        println("\nc) Sucursal que más vendió:")
        println("   Sucursal ${sucursalMaxima.first + 1} con ${sucursalMaxima.second} ventas")

        println("\nd) Mes que menos vendió la compañía:")
        println("   ${meses[mesMinimo.first]} con ${mesMinimo.second} ventas")
    }
}