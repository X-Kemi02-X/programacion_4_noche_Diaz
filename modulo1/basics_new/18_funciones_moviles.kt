fun main() {
    mostrarBienvenida()
    saludarCliente("Carlos")
    val precio1 = 500.0
    val precio2 = 200.0
    println("Suma de $precio1 + $precio2 = ${sumar(precio1, precio2)}")
    println("Resta de $precio1 - $precio2 = ${restar(precio1, precio2)}")
    operacion()
    println()
    println("Multiplicar $precio1 * $precio2 = ${multiplicar(precio1, precio2)}")
}

fun mostrarBienvenida() {
    println("Bienvenido al sistema de ventas")
}

fun saludarCliente(nombre: String) {
    println("Buenas tardes: $nombre")
}

fun sumar(numero1: Double, numero2: Double): Double {
    return numero1 + numero2
}

fun restar(numero1: Double, numero2: Double) = numero1 - numero2

fun operacion() {
    fun iva(x: Double) = x * 1.19
    print(iva(500.0))
}

val multiplicar = { a: Double, b: Double -> a * b }
