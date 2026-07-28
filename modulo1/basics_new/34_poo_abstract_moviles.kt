abstract class DispositivoMovil(val nombre: String) {
    abstract val precio: Double
    abstract val almacenamiento: Int
    abstract fun especificaciones(): String

    fun comparar(otro: DispositivoMovil): String = when {
        precio > otro.precio -> "$nombre es mas caro que ${otro.nombre}"
        precio < otro.precio -> "$nombre es mas barato que ${otro.nombre}"
        else -> "$nombre y ${otro.nombre} tienen el mismo precio"
    }

    override fun toString() = "${especificaciones()} | Precio: ${"%.2f".format(precio)}"
}

class GamaAlta(val modelo: String) : DispositivoMovil("Gama Alta") {
    override val precio: Double get() = 899.99
    override val almacenamiento: Int get() = 512
    override fun especificaciones() = "Smartphone $modelo de gama alta"
}

class GamaMedia(val modelo: String) : DispositivoMovil("Gama Media") {
    override val precio: Double get() = 349.99
    override val almacenamiento: Int get() = 128
    override fun especificaciones() = "Smartphone $modelo de gama media"
}

class GamaBaja(val modelo: String) : DispositivoMovil("Gama Baja") {
    override val precio: Double get() = 129.99
    override val almacenamiento: Int get() = 64
    override fun especificaciones() = "Smartphone $modelo de gama baja"
}

fun main() {
    val dispositivos: List<DispositivoMovil> = listOf(
        GamaAlta("Galaxy S25"),
        GamaMedia("Redmi Note 13"),
        GamaBaja("Nokia C21")
    )

    dispositivos.forEach { println(it) }

    val mayor = dispositivos.maxByOrNull { it.precio }
    println("\nDispositivo mas caro: ${mayor?.nombre}")

    println(dispositivos[0].comparar(dispositivos[1]))
}
