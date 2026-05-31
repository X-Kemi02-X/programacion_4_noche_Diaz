fun main() {
    println("CICLOS repeat - Registro de ventas")
    println("Cuantas ventas desea registrar?")
    val ventas = readLine()?.toIntOrNull() ?: 3
    var totalVentas = 0.0
    repeat(ventas) { i ->
        println("Venta ${i + 1} - Monto:")
        val monto = readLine()?.toDoubleOrNull() ?: 0.0
        totalVentas += monto
    }
    val promedio = totalVentas / ventas
    println("Monto total vendido: $totalVentas")
    println("Promedio por venta: $promedio")
    println("Clasificacion: ${
        when {
            promedio < 200 -> "Ventas bajas"
            promedio <= 500 -> "Ventas moderadas"
            else -> "Ventas altas"
        }
    }")
}
