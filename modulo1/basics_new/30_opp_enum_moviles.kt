enum class EstadoTelefono(val descripcion: String, val tieneGarantia: Boolean) {
    NUEVO("Telefono nuevo en caja sellada", true),
    USADO("Telefono usado en buen estado", false),
    REACONDICIONADO("Telefono reacondicionado por fabrica", true),
    DEFECTUOSO("Telefono con fallas de fabrica", false),
    ROBADO("Telefono reportado como robado", false);

    fun puedeTransicionarA(siguiente: EstadoTelefono): Boolean = when (this) {
        NUEVO -> siguiente == USADO || siguiente == REACONDICIONADO
        USADO -> siguiente == REACONDICIONADO || siguiente == DEFECTUOSO
        REACONDICIONADO -> siguiente == USADO || siguiente == DEFECTUOSO
        else -> false
    }
}

fun main() {
    val estado = EstadoTelefono.NUEVO
    println(estado.descripcion)
    println(estado.tieneGarantia)

    val icono = when (estado) {
        EstadoTelefono.NUEVO -> "N"
        EstadoTelefono.USADO -> "U"
        EstadoTelefono.REACONDICIONADO -> "R"
        EstadoTelefono.DEFECTUOSO -> "D"
        EstadoTelefono.ROBADO -> "X"
    }
    println(icono)

    println(estado.puedeTransicionarA(EstadoTelefono.USADO))
}
