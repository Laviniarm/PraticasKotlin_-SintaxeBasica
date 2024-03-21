import java.util.*

fun main() {
    // Questão 1
    class Produto {
        var nome: String
        var preco: Double

        constructor(nome: String, preco: Double) {
            this.nome = nome
            this.preco = preco
        }

        constructor(nome: String) : this(nome, 0.0)
    }

    // Crie instâncias das diferentes classes Produto utilizando os seus construtores e imprima os detalhes de cada produto.
    val produto1 = Produto("Celular", 2500.0)
    val produto2 = Produto("Bolsa")
    println("Produto 1: ${produto1.nome}, Preço: ${produto1.preco}")
    println("Produto 2: ${produto2.nome}, Preço: ${produto2.preco}")

    // Questão 2
    class Cliente {
        var nome: String = ""
        private var idade: Int = 0

        fun mostrarIdade() {
            println("Idade do cliente: $idade")
        }
    }

    // Crie uma instância de Cliente e chame o método mostrarIdade() para verificar seu funcionamento.
    val cliente = Cliente()
    cliente.nome = "Mateus"
    cliente.mostrarIdade()

    // Questão 3
    abstract class Personagem {
        abstract fun atacar()
    }

    class Guerreiro : Personagem() {
        override fun atacar() {
            println("Guerreiro ataca com sua espada!")
        }
    }

    class Mago : Personagem() {
        override fun atacar() {
            println("Mago lança uma fentiço poderoso!")
        }
    }

    // Crie instâncias de Guerreiro e Mago e chame o método atacar() de cada um para verificar se estão realizando os ataques corretamente de acordo com suas respectivas classes.
    val guerreiro = Guerreiro()
    val mago = Mago()

    guerreiro.atacar()
    mago.atacar()

    // Questão 4
    abstract class FormaGeometrica {
        abstract fun calcularArea(): Double
    }

    class Retangulo(val altura: Double, val largura: Double) : FormaGeometrica() {
        override fun calcularArea(): Double {
            return altura * largura
        }
    }

    class Circulo(val raio: Double) : FormaGeometrica() {
        override fun calcularArea(): Double {
            return Math.PI * raio * raio
        }
    }

    // Crie instâncias dessas duas classes e chame o método calcularArea() em cada uma delas para verificar o resultado.
    val retangulo = Retangulo(6.0, 3.0)
    val circulo = Circulo(8.0)

    println("Área do Retângulo: ${retangulo.calcularArea()}")
    println("Área do Círculo: ${circulo.calcularArea()}")

    // Questão 5
    class ContaBancaria {
        var numeroConta: String = ""
        var nomeTitular: String = ""
        var saldo: Double = 0.0
            set(value) {
                if (value >= 0) {
                    field = value
                } else {
                    println("O saldo não pode ser negativo.")
                }
            }
    }


    // Crie uma instância de ContaBancaria. Altere o nome do titular para uma string que inicie com letra minúscula e mude o saldo para um valor negativo. Imprima os valores para verificar se as regras dos getters e setters estão sendo aplicadas corretamente.
    var conta = ContaBancaria()
    conta.numeroConta = "1234567"
    conta.nomeTitular = "Lorena"
    conta.saldo = -140.0

    println("Número da Conta: ${conta.numeroConta}")
    println("Nome do Titular: ${conta.nomeTitular}")
    println("Saldo: ${conta.saldo}")
}

