fun main() {
    println("Conversiones de precios")
    val precioEntero: Int = 599

    val precioDecimal: Double = precioEntero.toDouble()
    val precioLong: Long = precioEntero.toLong()
    val precioString: String = precioEntero.toString()

    println("to Double $precioDecimal")
    println("to Long $precioLong")
    println("to String $precioString")

    println("String a Numerico")
    val numero1 = "999".toInt()
    val numero2 = "1299.99".toDouble()

    val invalido = "mil".toIntOrNull()
    println(invalido)
}
