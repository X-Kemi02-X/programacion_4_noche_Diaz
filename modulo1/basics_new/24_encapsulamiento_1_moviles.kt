class TelefonoMovil(val modelo: String, val precioInicial: Double) {
    private var nivelBateria: Int = 100
    internal val codigoImei: String = "35${(100000..999999).random()}${(100000..999999).random()}"
    protected open fun calcularComision(): Double = precioInicial * 0.05

    fun cargarSaldo(monto: Double) {
        require(monto > 0) { "el monto debe ser positivo" }
        val nuevoPrecio = precioInicial + monto
        println("Cargado $${"%.2f".format(monto)} | Precio actual: ${consultarPrecio()}")
    }

    fun aplicarDescuento(monto: Double): Boolean {
        require(monto > 0) { "el monto debe ser positivo" }
        if (monto > precioInicial) {
            println("Descuento excede el precio")
            return false
        }
        println("Descuento de $${"%.2f".format(monto)} | Nuevo Precio: ${consultarPrecio()}")
        return true
    }

    fun consultarPrecio(): String = "$${"%.2f".format(precioInicial)}"
}

fun main() {
    println("Programacion Orientada a Objeto")
    println("Encapsulamiento - Telefono")

    val telefonoAna = TelefonoMovil("Galaxy S25", 1000.0)
    telefonoAna.cargarSaldo(500.0)
    telefonoAna.aplicarDescuento(200.0)
    telefonoAna.aplicarDescuento(2000.0)

    println(telefonoAna.consultarPrecio())
}
