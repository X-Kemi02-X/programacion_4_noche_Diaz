fun main() {
    println("If con múltiples condiciones")
    val sistolica = readLine()?.toIntOrNull() ?: 0
    val clasificacion = if (sistolica < 90) {
        "Hipotensión"
    } else if (sistolica <= 119) {
        "Normal"
    } else if (sistolica <= 139) {
        "Elevada"
    } else if (sistolica <= 179) {
        "Hipertensión grado 2"
    } else {
        "Crisis Hipertensiva"
    }
    println("Clasificación: $clasificacion")
}
// Ejercicio
/*
fun main() {
    println("Clinica")
    val tiempoEspera = readLine()?.toIntOrNull() ?: 0
    val clasificacion = if (tiempoEspera <= 10) {
        "Flujo normal"
    } else if (tiempoEspera <= 30) {
        "Espera moderada - informar al paciente"
    } else if (tiempoEspera <= 60) {
        "Espera prolongada - ofrecer reagendamiento"
    } else {
        "Alerta de gestion - notificar a coordinacion"
    }
    println("Clasificación: $clasificacion")
}
*/