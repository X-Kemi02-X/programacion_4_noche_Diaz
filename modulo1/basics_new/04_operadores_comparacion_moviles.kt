fun main() {
    var precioSamsung = 850
    var precioXiaomi = 420

    println("precioSamsung==precioXiaomi ${precioSamsung == precioXiaomi}")
    println("precioSamsung!=precioXiaomi ${precioSamsung != precioXiaomi}")
    println("precioSamsung>precioXiaomi ${precioSamsung > precioXiaomi}")
    println("precioSamsung<precioXiaomi ${precioSamsung < precioXiaomi}")
    println("precioSamsung>=precioXiaomi ${precioSamsung >= precioXiaomi}")
    println("precioSamsung<=precioXiaomi ${precioSamsung <= precioXiaomi}")

    var modelo1 = "Galaxy"
    var modelo2 = "Galaxy"

    println("modelo1===modelo2 ${modelo1 === modelo2}")
    println("modelo1==modelo2 ${modelo1 == modelo2}")
    println("modelo1.equals(modelo2) ${modelo1.equals(modelo2)}")
}
