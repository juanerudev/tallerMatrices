package org.example.ejercicios

import org.example.utilidades.UtilidadesMatrices

object Ejercicio11 {
    // Constantes de pago
    private const val PRECIO_HORA_NORMAL = 2350
    private const val PRECIO_HORA_EXTRA = 3500
    private val DIAS_SEMANA = arrayOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")

    fun ejecutar() {
        println("\n=== EJERCICIO 11 ===")
        println("Sistema de nómina - La Huelga S.A.")
        println("===================================")

        // Leer número de empleados
        print("Ingrese el número de empleados: ")
        val numEmpleados = readLine()!!.toInt()

        // Validar rango de códigos
        if (numEmpleados < 1 || numEmpleados > 100) {
            println("Error: El número de empleados debe estar entre 1 y 100")
            return
        }

        // Leer códigos de empleados
        val codigos = leerCodigosEmpleados(numEmpleados)

        // Leer horas trabajadas (2 matrices: horas normales y horas extra)
        val horasNormales = leerHorasTrabajadas(numEmpleados, "normales")
        val horasExtras = leerHorasTrabajadas(numEmpleados, "extra")

        // Calcular sueldos y generar informe
        generarInforme(codigos, horasNormales, horasExtras)
    }

    private fun leerCodigosEmpleados(numEmpleados: Int): IntArray {
        val codigos = IntArray(numEmpleados)
        println("\nIngrese los códigos de los empleados (1-100):")

        for (i in 0 until numEmpleados) {
            var codigoValido = false
            while (!codigoValido) {
                print("Código del empleado ${i+1}: ")
                val codigo = readLine()!!.toInt()
                if (codigo in 1..100) {
                    codigos[i] = codigo
                    codigoValido = true
                } else {
                    println("Error: El código debe estar entre 1 y 100")
                }
            }
        }
        return codigos
    }

    private fun leerHorasTrabajadas(numEmpleados: Int, tipo: String): Array<IntArray> {
        println("\nIngrese las horas $tipo trabajadas por cada empleado:")
        val horas = Array(numEmpleados) { IntArray(7) }

        for (i in 0 until numEmpleados) {
            println("\nEmpleado ${i+1}:")
            for (j in 0 until 7) {
                print("  ${DIAS_SEMANA[j]}: ")
                horas[i][j] = readLine()!!.toInt()
            }
        }
        return horas
    }

    private fun generarInforme(codigos: IntArray, horasNormales: Array<IntArray>, horasExtras: Array<IntArray>) {
        println("\n" + "=".repeat(120))
        println("INFORME DE NÓMINA - LA HUELGA S.A.")
        println("=".repeat(120))
        println("%-10s %-15s %-15s %-15s %-15s %-15s".format(
            "CÓDIGO", "HORAS NORM.", "$ HORAS NORM.", "HORAS EXTRA", "$ HORAS EXTRA", "TOTAL $"
        ))
        println("-".repeat(120))

        var totalGeneral = 0.0

        for (i in codigos.indices) {
            val totalHorasNormales = horasNormales[i].sum()
            val totalHorasExtras = horasExtras[i].sum()

            val pagoHorasNormales = totalHorasNormales * PRECIO_HORA_NORMAL
            val pagoHorasExtras = totalHorasExtras * PRECIO_HORA_EXTRA
            val totalEmpleado = pagoHorasNormales + pagoHorasExtras

            totalGeneral += totalEmpleado

            println("%-10d %-15d %-15d %-15d %-15d %-15d".format(
                codigos[i],
                totalHorasNormales,
                pagoHorasNormales,
                totalHorasExtras,
                pagoHorasExtras,
                totalEmpleado
            ))

            // Mostrar detalle por día si se desea
            if (i == 0) { // Solo mostrar para el primer empleado como ejemplo
                println("  Detalle días:")
                for (j in 0 until 7) {
                    println("    ${DIAS_SEMANA[j]}: ${horasNormales[i][j]}h normales + ${horasExtras[i][j]}h extra")
                }
            }
        }

        println("-".repeat(120))
        println("%-75s %-15d".format("TOTAL GENERAL:", totalGeneral.toInt()))
        println("=".repeat(120))

        // Mostrar resumen de tarifas
        println("\nRESUMEN DE TARIFAS:")
        println("  Hora normal: $$PRECIO_HORA_NORMAL")
        println("  Hora extra: $$PRECIO_HORA_EXTRA")
    }
}