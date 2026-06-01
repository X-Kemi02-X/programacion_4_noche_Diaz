fun main() {
    println("when con bloques de codigo - Estado del equipo")
    println("Modelo del telefono:")
    val modelo = readLine()?.trim() ?: ""
    println("Estado del equipo NUEVO/USADO/REACONDICIONADO/ROTO")
    val estado = readLine()?.trim()?.uppercase() ?: ""

    when (estado) {
        "NUEVO" -> {
            println("ALERTA - Modelo $modelo")
            println("Vender a precio completo")
            println("Registrar garantia de fabrica")
        }
        "USADO" -> {
            println("USADO - Modelo $modelo")
            println("Aplicar 30% de descuento")
            println("Verificar estado fisico")
        }
        "REACONDICIONADO" -> println("Reacondicionado $modelo. Incluir 6 meses de garantia")
        "ROTO" -> println("Roto: $modelo. Enviar a taller de reparacion")
        else -> println("Estado no reconocido")
    }

    println("Anios de garantia:")
    val anios = readLine()?.toIntOrNull() ?: 0
    val cobertura = when (anios) {
        in 0..1 -> "Garantia basica"
        in 2..3 -> "Garantia estandar"
        in 4..5 -> "Garantia premium"
        else -> "Garantia vitalicia"
    }
    println("$anios anios -> $cobertura")
}
