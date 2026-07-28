fun main() {
    println("Seleccion de Marca")
    println("Codigo de marca? (1-7)")
    println("1- Samsung")
    println("2- Apple")
    println("3- Xiaomi")
    println("4- Huawei")
    println("5- Motorola")
    println("6- Oppo")
    println("7- OnePlus")
    val codigo = readLine()?.toIntOrNull() ?: 0
    val marca = when (codigo) {
        1 -> "Samsung"
        2 -> "Apple"
        3 -> "Xiaomi"
        4 -> "Huawei"
        5 -> "Motorola"
        6 -> "Oppo"
        7 -> "OnePlus"
        else -> "Marca no registrada"
    }
    println("Marca: $marca")
}
