fun main() {
    println("Evaluacion de bateria")
    println("El telefono tiene carga rapida? s/n")
    val tieneCargaRapida = readLine()?.lowercase() == "s"
    println("Capacidad de bateria mAh:")
    val capacidad = readLine()?.toIntOrNull() ?: 0
    if (tieneCargaRapida) {
        println("Telefono con carga rapida")
        if (capacidad < 4000) {
            println("Bateria estandar")
        } else if (capacidad > 5000) {
            println("Bateria de alto rendimiento")
        } else {
            println("Bateria optima")
        }
    } else {
        println("Telefono sin carga rapida")
        if (capacidad < 3000 || capacidad > 6000) {
            println("Capacidad fuera de lo recomendado")
        } else {
            println("Capacidad de bateria normal")
        }
    }
}
