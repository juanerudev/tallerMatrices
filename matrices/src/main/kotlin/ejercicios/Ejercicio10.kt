package org.example.ejercicios

import org.example.utilidades.UtilidadesMatrices

object Ejercicio10 {
    fun ejecutar() {
        println("\n=== EJERCICIO 10 ===")
        println("Análisis de calificaciones de estudiantes")
        println("=========================================")

        // Leer número de estudiantes
        print("Ingrese el número de estudiantes (M): ")
        val m = readLine()!!.toInt()

        // Leer matriz de calificaciones (M estudiantes x 6 materias)
        println("\nIngrese las calificaciones (0-100) de cada estudiante:")
        val calificaciones = UtilidadesMatrices.leerMatriz(m, 6)

        // Realizar análisis
        val promediosEstudiantes = calcularPromediosEstudiantes(calificaciones)
        val aprobadosPorMateria = contarAprobadosPorMateria(calificaciones)
        val reprobadosPorMateria = contarReprobadosPorMateria(calificaciones)
        val promediosMaterias = calcularPromediosMaterias(calificaciones)

        // Mostrar resultados
        mostrarResultados(calificaciones, promediosEstudiantes, aprobadosPorMateria,
            reprobadosPorMateria, promediosMaterias)
    }

    private fun calcularPromediosEstudiantes(calificaciones: Array<IntArray>): DoubleArray {
        return DoubleArray(calificaciones.size) { i ->
            calificaciones[i].average()
        }
    }

    private fun contarAprobadosPorMateria(calificaciones: Array<IntArray>): IntArray {
        val materias = 6
        val aprobados = IntArray(materias) { 0 }

        for (j in 0 until materias) {
            for (i in calificaciones.indices) {
                if (calificaciones[i][j] >= 60) { // Aprobado con 60 o más
                    aprobados[j]++
                }
            }
        }
        return aprobados
    }

    private fun contarReprobadosPorMateria(calificaciones: Array<IntArray>): IntArray {
        val materias = 6
        val reprobados = IntArray(materias) { 0 }

        for (j in 0 until materias) {
            for (i in calificaciones.indices) {
                if (calificaciones[i][j] < 60) { // Reprobado con menos de 60
                    reprobados[j]++
                }
            }
        }
        return reprobados
    }

    private fun calcularPromediosMaterias(calificaciones: Array<IntArray>): DoubleArray {
        val materias = 6
        val promedios = DoubleArray(materias) { 0.0 }

        for (j in 0 until materias) {
            var suma = 0.0
            for (i in calificaciones.indices) {
                suma += calificaciones[i][j]
            }
            promedios[j] = suma / calificaciones.size
        }
        return promedios
    }

    private fun mostrarResultados(
        calificaciones: Array<IntArray>,
        promediosEstudiantes: DoubleArray,
        aprobadosPorMateria: IntArray,
        reprobadosPorMateria: IntArray,
        promediosMaterias: DoubleArray
    ) {
        val materias = arrayOf("Matemáticas", "Física", "Química", "Historia", "Literatura", "Inglés")

        println("\n--- MATRIZ DE CALIFICACIONES ---")
        print("Est\\Mat\t")
        materias.forEach { print("${it.take(4)}\t") }
        println()

        for (i in calificaciones.indices) {
            print("E${i+1}\t")
            for (j in calificaciones[i].indices) {
                print("${calificaciones[i][j]}\t")
            }
            println()
        }

        println("\n--- RESULTADOS ---")

        println("\na) Nota promedio de cada estudiante:")
        for (i in promediosEstudiantes.indices) {
            println("   Estudiante ${i+1}: ${"%.2f".format(promediosEstudiantes[i])}")
        }

        println("\nb) Número de estudiantes que aprobaron cada materia:")
        for (j in aprobadosPorMateria.indices) {
            println("   ${materias[j]}: ${aprobadosPorMateria[j]}")
        }

        println("\nc) Número de estudiantes que reprobaron cada materia:")
        for (j in reprobadosPorMateria.indices) {
            println("   ${materias[j]}: ${reprobadosPorMateria[j]}")
        }

        println("\nd) Nota promedio de cada materia:")
        for (j in promediosMaterias.indices) {
            println("   ${materias[j]}: ${"%.2f".format(promediosMaterias[j])}")
        }
    }
}