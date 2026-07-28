fun main() {
    println("Operadores Logicos - Descuentos")
    val esClienteFrecuente = true
    val tieneTarjetaRegalo = false
    val superaMontoMinimo = true
    val esNuevoCliente = false

    println("Operador And &&")
    println("$esClienteFrecuente && $tieneTarjetaRegalo ${esClienteFrecuente && tieneTarjetaRegalo}")
    println("$esClienteFrecuente && $superaMontoMinimo ${esClienteFrecuente && superaMontoMinimo}")

    println("Or Logico ||")
    println("$esClienteFrecuente || $tieneTarjetaRegalo ${esClienteFrecuente || tieneTarjetaRegalo}")
    println("$esClienteFrecuente || $superaMontoMinimo ${esClienteFrecuente || superaMontoMinimo}")
    println("$esNuevoCliente || $tieneTarjetaRegalo ${esNuevoCliente || tieneTarjetaRegalo}")
    println("$esNuevoCliente || $tieneTarjetaRegalo || $superaMontoMinimo ${esNuevoCliente || tieneTarjetaRegalo || superaMontoMinimo}")

    println("Not Logico !")
    println("! $esClienteFrecuente ${!esClienteFrecuente}")
    println("! $esNuevoCliente ${!esNuevoCliente}")

    val texto = readLine()
    println(texto)
}
