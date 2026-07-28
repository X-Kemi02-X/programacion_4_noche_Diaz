fun main() {
    println("Utilidades de Listas - Filtros de inventario")
    val precios = listOf(150.0, 320.0, 450.0, 599.0, 699.0, 899.0, 999.0, 1299.0, 1599.0)
    println(precios)
    val preciosConIva = precios.map { it * 1.19 }
    println(preciosConIva)
    val preciosTexto = precios.map { "$$it" }
    println(preciosTexto)

    println("--- Filter ---")
    val economicos = precios.filter { it <= 400 }
    println("Economicos: $economicos")
    val gamaAlta = precios.filter { it > 700 }
    println("Gama alta: $gamaAlta")
    val rangoMedio = precios.filter { it >= 400 && it <= 800 }
    println("Rango medio: $rangoMedio")
    val costosos = precios.filterNot { it < 1000 }
    println("Costosos: $costosos")
}
