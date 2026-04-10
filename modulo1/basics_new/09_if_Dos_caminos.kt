fun main() {
    println("Control de Flujo")
    println("If Dos caminos")
    println("Tiene Seguro Medico? s/n")
    val tieneSeguro= readLine()?.trim()?.lowercase()=="s"
    println("Costo base del consulta? $")
    val costoBase= readLine()?.toDoubleOrNull()?:0.0
    if(tieneSeguro){
        val cobertura=costoBase*0.80
        println("Seguro cubre $cobertura Cliente cubre ${costoBase - cobertura}")
    } else {
        println("Cliente cubre $costoBase")
    }
}

// Ejercicio
/*
fun main() {
    println("Ingrese el tipo de examen (laboratorio o imagen):")

    val tipo = readLine()

    val mensaje = if (tipo == "laboratorio") {
        "Debe estar en ayunas"
    } else {
        "No requiere ayuno"
    }

    println(mensaje)
}
*/