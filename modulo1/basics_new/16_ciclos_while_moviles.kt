fun main() {
    println("CICLOS while - Control de stock")
    println("while basico")
    var cajas = 1
    while (cajas <= 5) {
        println("Revisando caja $cajas")
        cajas++
    }
    println("do while")
    cajas = 1
    do {
        println("Caja $cajas")
        cajas++
    } while (cajas <= 5)

    println("break - continue")
    cajas = 1
    while (cajas <= 10) {
        cajas++
        if (cajas == 3) continue
        if (cajas == 7) break
        println("Procesando unidad $cajas")
    }
    var input: String
    while (true) {
        println("Escribe 'salir' para cerrar inventario:")
        input = readLine() ?: ""
        if (input == "salir") break
        println("Ingresaste $input")
    }
}
