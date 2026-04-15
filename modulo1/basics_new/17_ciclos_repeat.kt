fun main() {
    println("CICLOS repeat")
    println("cuantas pulsaciones tomar para caluclar frecuencia")
    val mediciones = readLine()?.toIntOrNull() ?: 3
    var totalPulsaciones = 0
    repeat(mediciones) { i ->
        println("Medicion ${i + 1} (pulsos en 15 seg)")
        val pulsos = readLine()?.toIntOrNull() ?: 0
        totalPulsaciones += pulsos * 4 //segudnos
    }
    val promedio = totalPulsaciones / mediciones
    println("Frecuencia cardiaca promedio: $promedio lpm")
    println("Clasificacion: ${
        when {
            promedio < 60 -> "Bradicardia"
            promedio <= 100 -> "Normal"
            else -> "Taquicardia"
        }
    }")
}


/* EJERCICIO
fun main() {
    println("CICLOS repeat")

    var temperaturas = 0.0
    var fiebres = 0

    repeat(6) { i ->
        println("Medición ${i + 1} Temperatura:")
        val temperatura = readLine()?.toDoubleOrNull() ?: 0.0

        temperaturas += temperatura

        if (temperatura > 38.5) {
            fiebres++
        }
    }

    val promedio = temperaturas / 6
    println("Promedio: $promedio")

    if (fiebres > 2) {
        println("Fiebre sostenida")
    }
}
 */