fun main() {
    println("When con condiciones")
    println("Edad del paciente")
    val edad = readLine()?.toIntOrNull()?:0
    println("Tiene seguro? S/N")
    val tieneSeguro = readLine()?.trim()?.lowercase()=="s"

    val nivel: String = if (tieneSeguro){
        println("Nivel del seguro (BASICO/INTERMEDIO/PREMIUM)")
        readLine()?.trim()?.uppercase()?:""
    } else {
        ""
    }
    val copago = when {
        !tieneSeguro && edad <18->0.0
        !tieneSeguro && edad >=65->15.0
        !tieneSeguro ->45.0
        nivel=="BASICO"->20.0
        nivel=="INTERMEDIO"->10.0
        nivel=="PREMIUM"->0.0
        else -> 30.0
    }
    println("Copago aplicado: $${"%.2f".format(copago)}")
}

/**
 * fun main() {
 *     println("Sistema de Triaje")
 *     println("¿Tiene dolor de pecho? (s/n)")
 *     val tieneDolorPecho = readLine()?.trim()?.lowercase() == "s"
 *     println("¿Tiene dificultad respiratoria? (s/n)")
 *     val tieneDificultadRespiratoria = readLine()?.trim()?.lowercase() == "s"
 *     println("Ingrese la temperatura (en grados Celsius):")
 *     val temperatura = readLine()?.toDoubleOrNull() ?: 0.0
 *     val clasificacion = when {
 *         tieneDolorPecho && tieneDificultadRespiratoria -> "P1 - emergencia"
 *         tieneDolorPecho -> "P2 - urgente"
 *         temperatura >= 39.5 -> "P2 - urgente"
 *         temperatura >= 38.0 && temperatura <= 39.4 -> "P3 - prioritario"
 *         else -> "P4 - consulta general"
 *     }
 *
 *     println("Clasificación de prioridad: $clasificacion")
 * }
 */
