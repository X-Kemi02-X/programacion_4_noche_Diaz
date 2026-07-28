fun main() {
    println("Clasificador de precios de celulares")
    val precio = readLine()?.toIntOrNull() ?: 0
    val clasificacion = if (precio < 150) {
        "Gama Baja"
    } else if (precio <= 350) {
        "Gama Media"
    } else if (precio <= 700) {
        "Gama Alta"
    } else if (precio <= 1200) {
        "Premium"
    } else {
        "Ultra Premium"
    }
    println("Clasificacion: $clasificacion")
}
