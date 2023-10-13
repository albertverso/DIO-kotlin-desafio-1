enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String, val id: String)

data class ConteudoEducacional(val nome: String, val duracao: Int, val nivel: Nivel)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>,val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        inscritos.add(usuario)
    }
    
    fun printListaInscritos(){
        for(alunos in inscritos){
            println(alunos)
        }
    }
    
    fun printGradeFormacao(){
        for(cont in conteudos){
            println("${cont.nome} = ${cont.duracao}hrs")
        }
    }
}

fun main() {

	val moduloJava = ConteudoEducacional("Curso Java", 260, Nivel.DIFICIL)
    val moduloKotlin = ConteudoEducacional("Curso kotlin", 200, Nivel.INTERMEDIARIO)
    
    val listaConteudos = mutableListOf<ConteudoEducacional>()
    listaConteudos.add(moduloJava)
    listaConteudos.add(moduloKotlin)
    
    val carlos = Usuario("carlos", "1")
    val debora = Usuario("debora", "2")
    
    val formacaoBackEnd = Formacao("BackEnd", listaConteudos, Nivel.DIFICIL)
    
    formacaoBackEnd.matricular(carlos)
    formacaoBackEnd.matricular(debora)
    
    println("======================================")
    println("Dados da formação")
    println("${formacaoBackEnd.nome} - ${formacaoBackEnd.nivel}")
    println("Grade formação")
    println(formacaoBackEnd.printGradeFormacao())
    println("=======================================")
    println("Lista de inscritos")
    println(formacaoBackEnd.printListaInscritos())
   
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}
