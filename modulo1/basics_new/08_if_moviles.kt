fun main() {
    println("Control de Stock")
    println("Unidades disponibles en inventario")

    val stock = readLine()?.toIntOrNull() ?: 0

    if (stock <= 5) {
        println("ALERTA: Stock bajo - Reabastecer")
    }

    if (stock == 0) {
        println("Sin existencia - Producto agotado")
    }

    println("Stock registrado: $stock")
}
