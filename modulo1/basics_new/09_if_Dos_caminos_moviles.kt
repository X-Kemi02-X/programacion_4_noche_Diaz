fun main() {
    println("Control de Garantia")
    println("Tiene garantia extendida? s/n")
    val tieneGarantia = readLine()?.trim()?.lowercase() == "s"
    println("Costo base del telefono? $")
    val costoBase = readLine()?.toDoubleOrNull() ?: 0.0
    if (tieneGarantia) {
        val cobertura = costoBase * 0.50
        println("Garantia cubre $cobertura Cliente cubre ${costoBase - cobertura}")
    } else {
        println("Cliente cubre $costoBase")
    }
}
