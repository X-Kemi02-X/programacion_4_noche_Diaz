open class Telefono(val modelo: String, val precioBase: Double) {
    open fun obtenerPrecioFinal() = println("$modelo precio final: $precioBase")
    open fun descripcion() = "Soy $modelo"

    fun encender() = println("$modelo encendido")
}

class Smartphone(modelo: String, precioBase: Double, val almacenamiento: Int) : Telefono(modelo, precioBase) {
    override fun obtenerPrecioFinal() {
        super.obtenerPrecioFinal()
        println("(incluye 128GB de almacenamiento)")
    }
    override fun descripcion() = "${super.descripcion()}, un smartphone"
}

class FeaturePhone(modelo: String, precioBase: Double, val tieneTeclado: Boolean) : Telefono(modelo, precioBase) {
    override fun descripcion() =
        "${super.descripcion()}, un feature phone ${if (tieneTeclado) "con teclado" else "sin teclado"}"
}

fun main() {
    val s = Smartphone("Galaxy S25", 899.99, 128)
    s.obtenerPrecioFinal()

    val f = FeaturePhone("Nokia 3310", 49.99, true)
    println(f.descripcion())

    s.encender()
}
