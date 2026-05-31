fun main() {
    println("Map - Catalogo de precios")
    println("Inmutables")
    val precios = mapOf(
        "Galaxy S25" to 899.99,
        "iPhone 16" to 999.99,
        "Redmi Note 13" to 299.99,
        "Mate 60" to 1099.99,
    )
    println(precios["Galaxy S25"])
    println(precios["Pixel 9"])
    println(precios.getOrDefault("Galaxy S25", 0.0))
    println(precios.getOrDefault("Pixel 9", 0.0))
    println(precios.keys)
    println(precios.values)
    println(precios.entries)
    println(precios)
    for ((modelo, precio) in precios) {
        println("modelo: $modelo - precio: $precio")
    }
    for (precio in precios) {
        println("precio: $precio")
    }
    println("Mutables - Inventario")
    val inventario = mutableMapOf(
        "Samsung" to 15,
        "Apple" to 8,
        "Xiaomi" to 20,
        "Motorola" to 12
    )
    inventario["OnePlus"] = 5
    println(inventario)
    inventario["Samsung"] = 25
    println(inventario)
    inventario.remove("Motorola")
    println(inventario)
    inventario.getOrPut("Huawei") { 10 }
    println(inventario)
    inventario.getOrPut("Xiaomi") { 10 }
    println(inventario)
}
