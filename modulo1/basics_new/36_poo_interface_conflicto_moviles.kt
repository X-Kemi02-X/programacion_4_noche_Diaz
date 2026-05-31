interface GarantiaTienda {
    fun aplicarGarantia() = println("Tienda: Ofrecemos soporte técnico básico por 6 meses.")
}
interface GarantiaFabricante {
    fun aplicarGarantia() = println("Fabricante: Ofrecemos cambio de piezas originales por 1 año.")
}
class CelularPremium(val modelo: String) : GarantiaTienda, GarantiaFabricante {
    override fun aplicarGarantia() {
        println("RESOLVIENDO GARANTÍA PARA EL EQUIPO: $modelo")
        super<GarantiaTienda>.aplicarGarantia()
        super<GarantiaFabricante>.aplicarGarantia()
        println("Resultado: El equipo cuenta con cobertura de garantía total.")
    }
}

fun main() {
    val miTelefono = CelularPremium("iPhone 15 Pro Max")
    miTelefono.aplicarGarantia()
}