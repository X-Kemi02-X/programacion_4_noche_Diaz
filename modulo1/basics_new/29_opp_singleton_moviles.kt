object ConfiguracionTienda {
    val nombreTienda: String = "TiendaMovil Centro"
    val impuesto: Int = 19
    private val apiKey: String = "movil-secret-key-456"

    fun urlCatalogo() = "https://$nombreTienda/catalogo"
    fun headers() = mapOf("Authorization" to "Bearer $apiKey")
}

class TelefonoStock private constructor(val id: Int, val modelo: String) {
    companion object {
        private var contadorId = 0

        fun crear(modelo: String, marca: String): TelefonoStock? {
            if (modelo.isBlank() || marca.isBlank()) return null
            return TelefonoStock(++contadorId, modelo.trim())
        }

        const val STOCK_MINIMO = 5
    }
}

fun main() {
    println(ConfiguracionTienda.urlCatalogo())

    val t = TelefonoStock.crear("Galaxy S25", "Samsung")
    println(t)
}
