
open class Funcionario(val nome: String, val idade: Int) {

    init {
        println("Novo funcionário registrado: $nome, $idade anos")
    }

    open fun apresentar() {
        println("Nome: $nome, Idade: $idade")
    }
}

class Gerente(nome: String, idade: Int, val setor: String) : Funcionario(nome, idade) {
    override fun apresentar() {
        super.apresentar()
        println("Setor: $setor")
    }
}

class Desenvolvedor(nome: String, idade: Int, val linguagem: String) : Funcionario(nome, idade) {
    override fun apresentar() {
        super.apresentar()
        println("Linguagem: $linguagem")
    }
}

class Analista(nome: String, idade: Int, val area: String) : Funcionario(nome, idade) {
    override fun apresentar() {
        super.apresentar()
        println("Área: $area")
    }
}

fun main() {
    val listaFuncionarios = listOf(
        Gerente("Lavínia", 26, "Administrativo"),
        Desenvolvedor("Marcos", 35, "Kotlin"),
        Analista("Livia", 30, "Financeiro")
    )

    for (funcionario in listaFuncionarios) {
        when (funcionario) {
            is Gerente -> {
                println("\nApresentação do Gerente:")
                funcionario.apresentar()
            }
            is Desenvolvedor -> {
                println("\nApresentação do Desenvolvedor:")
                funcionario.apresentar()
            }
            is Analista -> {
                println("\nApresentação do Analista:")
                funcionario.apresentar()
            }
        }
    }
}
