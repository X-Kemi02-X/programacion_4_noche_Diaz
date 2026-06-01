class DimensionesTelefono(val alto: Double, val ancho: Double) {
    val areaPantalla: Double get() = alto * ancho
    val diagonal: Double get() = Math.sqrt(alto * alto + ancho * ancho)

    constructor(lado: Double) : this(lado, lado)
    constructor(alto: Int, ancho: Int) : this(alto.toDouble(), ancho.toDouble())

    override fun toString() = "Telefono(${alto}x${ancho}) | pantalla=${"%.1f".format(areaPantalla)}"
}

fun main() {
    val d1 = DimensionesTelefono(14.5, 7.2)
    val d2 = DimensionesTelefono(6.0)
    val d3 = DimensionesTelefono(15, 7)

    println(d1)
    println(d2)
}
