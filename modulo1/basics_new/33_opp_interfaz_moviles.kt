interface Vendible {
    fun vender(cantidad: Int): Boolean
    val nombre: String
}

class TiendaFisica(val direccion: String) : Vendible {
    override val nombre = "Tienda Fisica"
    override fun vender(cantidad: Int): Boolean {
        println("Vendiendo $cantidad unidad(es) en tienda $direccion")
        return true
    }
}

class TiendaOnline(val url: String) : Vendible {
    override val nombre = "Tienda Online"
    override fun vender(cantidad: Int): Boolean {
        println("Vendiendo $cantidad unidad(es) via $url")
        return true
    }
}

class VentaMayorista : Vendible {
    override val nombre = "Mayorista"
    override fun vender(cantidad: Int): Boolean {
        println("Vendiendo $cantidad unidad(es) al por mayor")
        return true
    }
}

class Subasta : Vendible {
    override val nombre = "Subasta"
    override fun vender(cantidad: Int): Boolean {
        println("Subastando $cantidad unidad(es)")
        return true
    }
}

fun realizarVenta(cantidad: Int, canal: Vendible) {
    println("Procesando venta con ${canal.nombre}...")
    val exito = canal.vender(cantidad)
    println(if (exito) "Venta exitosa" else "Venta fallida")
}

fun main() {
    val canales: List<Vendible> = listOf(
        TiendaFisica("Av. Central 123"),
        TiendaOnline("tiendamovil.com"),
        VentaMayorista(),
        Subasta()
    )

    canales.forEach { realizarVenta(5, it) }
}
