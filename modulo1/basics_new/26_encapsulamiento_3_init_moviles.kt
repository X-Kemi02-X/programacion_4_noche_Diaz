class EquipoMovil(val modelo: String, val imei: String) {
    val modeloNormalizado: String
    val codigoRegion: String

    init {
        require(modelo.isNotBlank()) { "El modelo no puede estar vacio" }
        require(imei.length == 15) { "IMEI invalido: $imei" }

        modeloNormalizado = modelo.trim().lowercase()
        codigoRegion = imei.substring(0, 2)
    }
}

fun main() {
    val e = EquipoMovil("  Galaxy S25  ", "351234567891234")
    println(e.modeloNormalizado)
    println(e.codigoRegion)
}
