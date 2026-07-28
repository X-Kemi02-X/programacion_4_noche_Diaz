fun main() {
    saludar()
    saludarConParametros("Elizabeth")
    val numero1=10
    val numero2=20
    println("Susma de $numero1 + $numero2 = ${sumar(numero1, numero2)}")
    println("Resta de $numero1 - $numero2 = ${restar(numero1, numero2)}")
    operacion()
    println()
    println("Multiplicar $numero1 * $numero2 = ${multiplicar(numero1, numero2)}")
}

fun saludar(){
    println("Hello worl from functions")
}

fun saludarConParametros(nombre: String){
    println("Buenas noches: $nombre")
}

fun sumar(numero1: Int, numero2: Int): Int{
    return numero1+numero2
}

// funcion simplificada
fun restar(numero1: Int, numero2: Int)=numero1-numero2

// funcion dentro de funcion
fun operacion(){
    fun cuadrado (x: Int)= x*x
    print(cuadrado(5))
}

// funciones como variables
val multiplicar={a: Int, b: Int-> a*b}