fun main() {

    println("Funcion Lambda - Calculo de descuentos")
    val descuento10: (Double) -> Double = { a: Double -> a * 0.90 }
    println(descuento10(500.0))
    val descuento20: (Double) -> Double = { a -> a * 0.80 }
    println(descuento20(500.0))
    val aplicarIva: (Double) -> Double = { it * 1.19 }
    println(aplicarIva(500.0))
}
