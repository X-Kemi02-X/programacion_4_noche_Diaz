fun main() {
    println("CICLOS for - Inventario")
    for (i in 1..5) {
        println("Estante $i")
    }
    println("until")
    for (i in 1 until 5) {
        println("Producto $i")
    }
    println("downTo")
    for (i in 10 downTo 1) {
        println("Stock $i")
    }
    println("listas de modelos")
    val modelos = listOf("Galaxy S25", "iPhone 16", "Redmi Note 13")
    for (modelo in modelos) {
        println(modelo)
    }
    println("indice valor")
    for ((index, valor) in modelos.withIndex()) {
        println("$index: $valor")
    }
    println("break - continue")
    for (i in 1..5) {
        if (i == 3) {
            continue
        }
        println(i)
    }
}
