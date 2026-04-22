class CuentaBancaria(val titular: String, val saldoInicial: Double){
    private var saldo: Double = saldoInicial
    internal val numeroCuenta: String = "ES${(100000..999999).random()}"
    protected open fun calcularInteres(): Double = saldo * 0.02

    fun depositar(monto: Double){
        require(monto > 0) { "el monto debe ser positivo" }
        saldo += monto
        println("Depositado $${"%.2f".format(monto)} | Nuevo Saldo: ${consultarSaldo()}")
    }

    fun retirar(monto: Double): Boolean {
        require(monto > 0) { "el monto debe ser positivo" }
        if (monto > saldo) {
            println("Fondos insuficientes")
            return false
        }
        saldo -= monto
        println("Retirado $${"%.2f".format(monto)} | Nuevo Saldo: ${consultarSaldo()}")
        return true
    }

    fun consultarSaldo(): String = "$${"%.2f".format(saldo)}"
}

fun main() {
    println("Programacion Orientada a Objeto")
    println("Encapsulamiento")

    val cuentaAna = CuentaBancaria("Juan Cumare", 1000.0)
    cuentaAna.depositar(500.0)
    cuentaAna.retirar(500.0)
    cuentaAna.retirar(2000.0)

    println(cuentaAna.consultarSaldo())
}