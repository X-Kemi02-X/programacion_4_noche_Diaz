data class Telefono(
    val id: Int,
    val modelo: String,
    val precio: Double,
    val marca: String,
    val disponible: Boolean = true
)

fun main() {
    val t1 = Telefono(1, "Galaxy S25", 899.99, "Samsung")
    val t2 = Telefono(1, "Galaxy S25", 899.99, "Samsung")
    val t3 = Telefono(2, "iPhone 16", 999.99, "Apple")

    println(t1)

    println(t1 == t2)
    println(t1 == t3)

    val barato = t1.copy(precio = 599.99)
    val agotado = t1.copy(disponible = false)

    val (id, modelo, precio) = t1
    println("$id: $modelo — $$precio")

    listOf(t1, t3).forEach { (id2, modelo2, precio2) ->
        println("[$id2] $modelo2: $$precio2")
    }
}
