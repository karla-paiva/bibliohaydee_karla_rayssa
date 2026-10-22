
import br.escola.bibliohaydee.model.Autor;
import br.escola.bibliohaydee.model.Livro;
import br.escola.bibliohaydee.model.Usuario;


void main() {
    Autor [] autores = new Autor[5];
    Livro [] livros = new Livro[10];
    Usuario[] usuarios = new Usuario[10];
    int qtdUsuarios = 0;
    int qtdAutores = 0;
    int qtdLivros = 0;

    IO.println("=========== BIBLIOHAYDÉE ===========");
    listarAcervo(livros, qtdLivros);

    Autor harper = new Autor();
    autores[qtdAutores] = harper;
    qtdAutores++;

    IO.println("\nAutor cadastrado: " + harper);

    Livro livro = new Livro(
            "O Sol é Para Todos",
            "9788535905151",
            harper,
            2004,
            "Romance ficcional"
    );

    livros[qtdLivros] = livro;
    qtdLivros++;

    listarAcervo(livros, qtdLivros);

    IO.println("\n=========== CADASTRO DE USUÁRIO ===========");

    String nome;

    do {
        nome = IO.readln("Digite o nome: ");
        if (nome.isBlank()) {
            IO.println("Nome inválido. Digite novamente.");
        }
    } while (nome.isBlank());

    String matricula;

    do {
        matricula = IO.readln("Digite a matrícula: ").trim();

        if (matricula.isEmpty()) {
            IO.println("Matrícula não pode ficar vazia. Digite novamente.");
        }
    } while (matricula.isEmpty());

    String tipo;
    do {
        tipo = IO.readln("Digite o tipo (ALUNO ou PROFESSOR): ");

        if (!tipo.equals("ALUNO") && !tipo.equals("PROFESSOR")) {
            IO.println("Tipo inválido. Digite ALUNO ou PROFESSOR.");
        }
    } while (!tipo.equals("ALUNO") && !tipo.equals("PROFESSOR"));

    Integer limite = null;

    while (limite == null) {
        try {
            limite = Integer.parseInt(
                    IO.readln("Digite o limite de empréstimos: ")
            );

            if (limite < 0) {
                IO.println("O limite não pode ser negativo.");
                limite = null;
            }
        } catch (NumberFormatException e) {
            IO.println("Digite um número inteiro válido.");
        }
    }

    Usuario usuario = new Usuario(nome, matricula, tipo, limite);

    usuarios[qtdUsuarios] = usuario;
    qtdUsuarios++;

    IO.println("\nUsuário cadastrado com sucesso!");
    IO.println("Nome: " + usuario.getNome());
    IO.println("Matrícula: " + usuario.getMatricula());
    IO.println("Tipo: " + usuario.getTipo());
    IO.println("Limite de empréstimos: " + usuario.getLimiteEmprestimos());
    IO.println("Empréstimos ativos: " + usuario.getEmprestimosAtivos());
}


static void listarAcervo(Livro[] acervo, int qtdLivros){
    IO.println("=========== ACERVO ===========");
    if (qtdLivros == 0){
        IO.println("Acervo vazio.");
        return;
    }

    for (Livro livro : acervo){
        if (livro == null){
            break;
        }
        IO.println(livro);
    }
}