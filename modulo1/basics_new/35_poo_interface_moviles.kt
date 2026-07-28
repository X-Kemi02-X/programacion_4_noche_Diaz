interface Garantizable {
    val id: String
    fun serializar(): String
    val version: Int get() = 1
}

interface Evaluable {
    val errores: List<String>
    val esValido: Boolean get() = errores.isEmpty()

    fun validar(): Boolean
    fun imprimirErrores() {
        if (errores.isEmpty()) println("Sin errores")
        else errores.forEach { println("  X $it") }
    }
}

data class VentaTelefono(
    override val id: String,
    val cliente: String,
    val modelos: List<String>,
    val total: Double
) : Garantizable, Evaluable {

    override fun serializar() =
        "$id|$cliente|${modelos.joinToString(",")}|$total"

    override val errores: List<String> get() = buildList {
        if (cliente.isBlank()) add("El cliente no puede estar vacio")
        if (modelos.isEmpty()) add("La venta debe tener al menos un telefono")
        if (total <= 0) add("El total debe ser mayor que cero")
    }

    override fun validar() = esValido
}

fun main() {
    val venta1 = VentaTelefono("V001", "Ana", listOf("Galaxy S25", "iPhone 16"), 1899.98)
    val venta2 = VentaTelefono("V002", "", emptyList(), -5.0)

    fun procesarGarantizable(g: Garantizable) = println("-> ${g.serializar()}")
    fun procesarEvaluable(v: Evaluable) {
        println("Valido: ${v.esValido}")
        v.imprimirErrores()
    }

    procesarGarantizable(venta1)
    procesarEvaluable(venta1)
    procesarEvaluable(venta2)
}
