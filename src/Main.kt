class Livro(var titulo: String, var preco: Double) {
    override fun toString(): String {
        return "Livro: Titulo = $titulo, Preco = $preco"
    }
}

fun menu() {
    println("1 - Cadastrar livro")
    println("2 - Excluir livro")
    println("3 - Buscar livro")
    println("4 - Editar livro")
    println("5 - Listar livros")
    println("6 - Listar livros que começam com letra escolhida")
    println("7 - Listar livros com preço abaixo do informado")
    println("8 - Sair")
}

fun inputTitulo(): String {
    print("Digite o titulo do livro: ")
    return readLine() ?: ""
}

fun inputPreco(): Double {
    print("Digite o preco do livro: ")
    var preco = readLine()?.toDoubleOrNull() ?: 0.0

    while (preco <= 0) {
        println("O preço não pode ser negativo ou zero. Por favor, informe um valor válido.")
        preco = readLine()?.toDoubleOrNull() ?: 0.0
    }

    return preco
}

fun cadastrarLivro(repositorio: MutableList<Livro>) {
    val titulo = inputTitulo()
    val preco = inputPreco()

    repositorio.add(Livro(titulo, preco))
    println("\nCadastrado com sucesso!\n")
}

fun excluirLivro(repositorio: MutableList<Livro>) {
    val livro = buscarNome(repositorio)
    if (livro != null) {
        repositorio.remove(livro)
        println("Livro removido com sucesso!")
    } else {
        println("Livro não encontrado.")
    }
}

fun buscarNome(repositorio: MutableList<Livro>): Livro? {
    val titulo = inputTitulo()
    return repositorio.find { it.titulo == titulo }
}

fun editarLivro(repositorio: MutableList<Livro>) {
    val livro = buscarNome(repositorio)
    if (livro != null) {
        println("Qual informação deseja editar? (1 - Título, 2 - Preço)")
        val opcao = readLine()?.toIntOrNull() ?: 0

        when (opcao) {
            1 -> {
                println("Digite o novo título:")
                val novoTitulo = readLine() ?: ""
                livro.titulo = novoTitulo
                println("Título alterado com sucesso!")
            }
            2 -> {
                val novoPreco = inputPreco()
                livro.preco = novoPreco
                println("Preço alterado com sucesso!")
            }
            else -> println("Opção inválida.")
        }
    } else {
        println("Livro não encontrado.")
    }
}

fun listar(repositorio: MutableList<Livro>) {
    println("Lista de Livros:")
    for (livro in repositorio) {
        println(livro)
    }
}

fun listarComLetraInicial(repositorio: MutableList<Livro>) {
    print("Informe a letra: ")
    val letra = readLine()?.firstOrNull()?.toUpperCase() ?: return

    val livros = repositorio.filter { it.titulo.startsWith(letra) }
    if (livros.isNotEmpty()) {
        println("Livros com título iniciado por '$letra':")
        livros.forEach { println(it) }
    } else {
        println("Nenhum livro encontrado com título iniciado por '$letra'.")
    }
}

fun listarComPrecoAbaixo(repositorio: MutableList<Livro>) {
    val preco = inputPreco()
    val livros = repositorio.filter { it.preco < preco }
    if (livros.isNotEmpty()) {
        println("Livros com preço abaixo de $preco:")
        livros.forEach { println(it) }
    } else {
        println("Nenhum livro encontrado com preço abaixo de $preco.")
    }
}

fun main() {
    val repositorioLivros = mutableListOf<Livro>()
    repositorioLivros.add(Livro("Livro dos Livros", 999999.99))
    repositorioLivros.add(Livro("Turma da Monica", 4.99))
    repositorioLivros.add(Livro("Kotlin for Dummies", 29.99))
    repositorioLivros.add(Livro("A", 59.99))

    var opcao = 0
    while (opcao != 8) {
        menu()
        print("Digite a opção: ")
        opcao = readLine()?.toIntOrNull() ?: 8

        when (opcao) {
            1 -> cadastrarLivro(repositorioLivros)
            2 -> excluirLivro(repositorioLivros)
            3 -> {
                val livro = buscarNome(repositorioLivros)
                println(livro ?: "Livro não encontrado.")
            }
            4 -> editarLivro(repositorioLivros)
            5 -> listar(repositorioLivros)
            6 -> listarComLetraInicial(repositorioLivros)
            7 -> listarComPrecoAbaixo(repositorioLivros)
            8 -> println("Até a próxima :)")
            else -> println("Opção inválida.")
        }
        Thread.sleep(3000)
    }
}
