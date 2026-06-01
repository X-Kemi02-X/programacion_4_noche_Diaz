fun main() {
    println("Registro de Venta")
    println("Ingrese nombre del cliente")
    val nombre = readLine()
    println("Hola $nombre")

    println("Ingrese su presupuesto: ")
    val presupuesto = readLine()?.toDoubleOrNull() ?: 0.00
    println("Su presupuesto es: $presupuesto")

    val doblePresupuesto = presupuesto * 2
    println("El doble de su presupuesto es: ${doblePresupuesto}")
    println("El doble de su presupuesto es: ${presupuesto * 2}")
}
