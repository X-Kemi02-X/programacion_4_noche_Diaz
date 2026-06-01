fun main() {
    println("Control de Flujo")
    println("If simple")
    println("Temperatura corporal del paciente grados centig.")

    val temperatura = readLine()?.toDoubleOrNull() ?: 35.5

    if (temperatura >= 38) {
        println("Fiebre detectada")
    }

    if (temperatura >= 40) {
        println("Fiebre alta")
    }

    println("Temperatura registrada: $temperatura")


    // Ejercicio
    /*
    fun main() {
        println("Ingrese la saturacion de oxigeno (SpO2) en %:")

        val spO2 = readLine()?.toDouble() #OrNull

        if (spO2 != null && spO2 < 95) {
            println("Alerta: saturacion baja - evaluar suministro de oxigeno")
        }

        println("Valor registrado: $spO2%")
    }
*/