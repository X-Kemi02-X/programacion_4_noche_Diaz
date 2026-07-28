fun main() {
    println("When con condiciones - Descuento por marca")
    println("Cantidad de unidades a comprar")
    val cantidad = readLine()?.toIntOrNull() ?: 0
    println("Es cliente premium? S/N")
    val esPremium = readLine()?.trim()?.lowercase() == "s"

    val nivel: String = if (esPremium) {
        println("Nivel de membresia (BASICO/PLUS/PREMIUM)")
        readLine()?.trim()?.uppercase() ?: ""
    } else {
        ""
    }
    val descuento = when {
        !esPremium && cantidad < 2 -> 0.0
        !esPremium && cantidad >= 5 -> 10.0
        !esPremium -> 5.0
        nivel == "BASICO" -> 8.0
        nivel == "PLUS" -> 15.0
        nivel == "PREMIUM" -> 25.0
        else -> 5.0
    }
    println("Descuento aplicado: ${"%.1f".format(descuento)}%")
}
