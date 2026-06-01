fun main() {
    val marca = "Samsung"
    val almacenamiento: Int = 128
    var stock = 15
    stock = stock - 1

    println("$marca con $almacenamiento GB - Stock: $stock")

    val precio: Byte = 99
    val unidadesVendidas: Short = 12_500
    val codigoProducto: Int = 48291
    val imei: Long = 3_512_678_901_234_567

    println(precio)
    println(unidadesVendidas)
    println(codigoProducto)
    println(imei)

    val descuento: Float = 15.5f
    val precioFinal: Double = 349.99

    println(descuento)
    println(precioFinal)

    val categoria: Char = 'A'
    val modelo: String = "Galaxy S25"

    val inferido = "iPhone 16"
    val inferido1 = 999

    println("Tipo de inferido: ${inferido::class.simpleName}")
    println("Tipo de inferido1: ${inferido1::class.simpleName}")

    val nombreMarca = "xiaomi"
    val nombreModelo = "redmi note 13"
    val nombreMarcaMayuscula = nombreMarca.uppercase()
    val nombreModeloMayuscula = nombreModelo.uppercase()

    println("Equipo ${nombreMarcaMayuscula} ${nombreModeloMayuscula}")
    println("Equipo ${nombreMarca.uppercase()} ${nombreModelo.uppercase()}")
}
