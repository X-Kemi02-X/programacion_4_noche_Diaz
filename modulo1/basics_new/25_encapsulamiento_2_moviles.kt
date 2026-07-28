class PrecioTelefono(precioInicial: Double) {

    var precio: Double = precioInicial
        set(value) {
            require(value >= 0.0) { "El precio no puede ser negativo" }
            field = value
        }

    val precioConIva: Double
        get() = precio * 1.19

    val precioEnDolares: Double
        get() = precio / 4.10

    val descripcionPrecio: String
        get() = when {
            precio < 150 -> "Gama baja"
            precio < 400 -> "Gama media"
            precio < 800 -> "Gama alta"
            else -> "Premium"
        }
}

fun main() {
    val tel = PrecioTelefono(350.0)
    println("${tel.precio} = ${tel.precioConIva} con IVA = ${tel.precioEnDolares} USD")
    println(tel.descripcionPrecio)

    tel.precio = 100.0
    println("${tel.precio} -> ${tel.descripcionPrecio}")
}
