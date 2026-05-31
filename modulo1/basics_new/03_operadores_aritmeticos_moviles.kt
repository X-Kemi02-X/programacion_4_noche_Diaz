fun main() {

    val precioBase = 500
    val iva = 19

    println("Suma")
    println("$precioBase + $iva = ${precioBase + iva}")
    println("Resta")
    println("$precioBase - $iva = ${precioBase - iva}")
    println("Multiplicacion")
    println("$precioBase * $iva = ${precioBase * iva}")
    println("Division")
    println("$precioBase / $iva = ${precioBase / iva}")
    println("Modulo")
    println("$precioBase % $iva = ${precioBase % iva}")

    var stock = 50
    stock += 10
    println("stock+=10 ${stock}")
    stock -= 3
    println("stock-=3 ${stock}")
    stock *= 2
    println("stock*=2 ${stock}")
    stock /= 4
    println("stock/=4 ${stock}")
    stock %= 4
    println("stock%=4 ${stock}")

    var contadorVentas = 0
    println("contadorVentas++ ${contadorVentas}")
    contadorVentas--
    println("contadorVentas-- ${contadorVentas}")
}
