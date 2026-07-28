data class MarcaTelefono(val id: Int, val nombre: String)

data class TelefonoVenta(
    val id: Int,
    val modelo: String,
    val precio: Double,
    val stock: Int,
    val marca: MarcaTelefono,
    val activo: Boolean = true
) {
    val disponible: Boolean get() = activo && stock > 0
    val precioConIva: Double get() = precio * 1.19

    fun aplicarDescuento(porcentaje: Double): TelefonoVenta {
        require(porcentaje in 0.0..100.0) { "Descuento debe ser entre 0 y 100" }
        return copy(precio = precio * (1 - porcentaje / 100))
    }
}

object CatalogoTelefonos {
    private val marcas = mutableListOf(
        MarcaTelefono(1, "Samsung"),
        MarcaTelefono(2, "Apple"),
        MarcaTelefono(3, "Xiaomi")
    )
    private val telefonos = mutableListOf<TelefonoVenta>()
    private var siguienteId = 1

    fun agregarTelefono(modelo: String, precio: Double, stock: Int, marcaId: Int): TelefonoVenta? {
        val marca = marcas.find { it.id == marcaId } ?: return null
        val telefono = TelefonoVenta(siguienteId++, modelo, precio, stock, marca)
        telefonos.add(telefono)
        return telefono
    }

    fun listar(): List<TelefonoVenta> = telefonos.toList()
    fun disponibles(): List<TelefonoVenta> = telefonos.filter { it.disponible }
    fun porMarca(id: Int): List<TelefonoVenta> = telefonos.filter { it.marca.id == id }
    fun buscar(query: String): List<TelefonoVenta> =
        telefonos.filter { it.modelo.contains(query, ignoreCase = true) }
}

fun main() {
    CatalogoTelefonos.agregarTelefono("Galaxy S25", 899.99, 15, 1)
    CatalogoTelefonos.agregarTelefono("iPhone 16", 999.99, 0, 2)
    CatalogoTelefonos.agregarTelefono("Redmi Note 13", 299.99, 5, 3)
    CatalogoTelefonos.agregarTelefono("Galaxy A55", 449.99, 8, 1)

    println("=== Todos los telefonos ===")
    CatalogoTelefonos.listar().forEach { t ->
        val estado = if (t.disponible) "D" else "X"
        println("$estado ${t.modelo} — ${"%.2f".format(t.precioConIva)} (con IVA)")
    }

    println("\n=== Disponibles con 15% descuento ===")
    CatalogoTelefonos.disponibles()
        .map { it.aplicarDescuento(15.0) }
        .forEach { println("  ${it.modelo}: ${"%.2f".format(it.precio)}") }

    for (telefono in CatalogoTelefonos.listar()) {
        println("${telefono.modelo} ${telefono.stock}")
    }
}
