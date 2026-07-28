fun main() {
    println("CICLOS while")
    println("while basico")
    var contador=1
    while (contador<=5){
        println(contador)
        contador++
    }
    println("do while")
    contador=1
    do {
        println(contador)
        contador++
    }while (contador<=5)

    println("brake - continue")
    contador=1
    while (contador<=10){
        contador++
        if(contador ==3) continue
        if(contador ==7) break
        println(contador)
    }
    var input: String
    while(true){
        println("Escribe 'salir' para terminar:")
        input=readLine()?:""
        if(input=="salir") break
        println("Ingresaste $input")
    }
}

/* #EJERCICIO#
fun main() {
    val correctPassword = "1234"
    var enteredPassword: String
    do
        {
        println("Ingrese la contraseña:")
        enteredPassword = readLine() ?: ""

        if (enteredPassword == correctPassword) {
            println("Acceso permitido")
        } else {
            println("Contraseña incorrecta")
        }
    } while (enteredPassword != correctPassword)
}
 */