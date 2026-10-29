
import br.escola.bibliohaydee.model.Autor;
import br.escola.bibliohaydee.model.Livro;
import br.escola.bibliohaydee.model.Usuario;

void main() {

    Autor[] autores = new Autor[5];
    Livro[] livros = new Livro[10];
    Usuario[] usuarios = new Usuario[10];

    int qtdUsuarios = 0;
    int qtdAutores = 0;
    int qtdLivros = 0;

    IO.println("=========== BIBLIOHAYDÉE ===========");

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

    Livro livroSemGenero = new Livro(
            "Livro de teste",
            "123456789",
            harper,
            2020
    );

    livros[qtdLivros] = livroSemGenero;
    qtdLivros++;

    listarAcervo(livros, qtdLivros);

    IO.println("\n=========== CADASTRO DE USUÁRIO ===========");

    String nome;

    do {
        nome = IO.readln("Digite o nome: ");

        if (nome == null || nome.isBlank()) {
            IO.println("Nome inválido. Digite novamente.");
        }
    } while (nome == null || nome.isBlank());

    String matricula;

    do {
        matricula = IO.readln("Digite a matrícula: ").trim();

        if (matricula.isEmpty()) {
            IO.println(
                    "Matrícula não pode ficar vazia. Digite novamente."
            );
        }
    } while (matricula.isEmpty());

    String tipo;

    do {
        tipo = IO.readln(
                "Digite o tipo (ALUNO ou PROFESSOR): "
        ).trim().toUpperCase();

        if (!tipo.equals("ALUNO") &&
                !tipo.equals("PROFESSOR")) {
            IO.println(
                    "Tipo inválido. Digite ALUNO ou PROFESSOR."
            );
        }
    } while (!tipo.equals("ALUNO") &&
            !tipo.equals("PROFESSOR"));

    String definirLimite;

    do {
        definirLimite = IO.readln(
                "Definir o limite? (S/N): "
        ).trim().toUpperCase();

        if (!definirLimite.equals("S") &&
                !definirLimite.equals("N")) {
            IO.println("Digite S para sim ou N para não.");
        }
    } while (!definirLimite.equals("S") &&
            !definirLimite.equals("N"));

    Usuario usuario;

    if (definirLimite.equals("S")) {

        int limite = lerNumeroInteiro(
                "Digite o limite de empréstimos: "
        );

        while (limite < 1) {
            IO.println("O limite deve ser maior que zero.");

            limite = lerNumeroInteiro(
                    "Digite o limite de empréstimos: "
            );
        }

        usuario = new Usuario(nome, matricula, tipo, limite);

    } else {
        usuario = new Usuario(nome, matricula, tipo);
    }

    usuarios[qtdUsuarios] = usuario;
    qtdUsuarios++;

    IO.println("\nUsuário cadastrado com sucesso!");
    mostrarUsuario(usuario);

    IO.println("\n=========== ALTERAR USUÁRIO ===========");

    String matriculaBusca = IO.readln(
            "Digite a matrícula do usuário que deseja alterar: "
    ).trim();

    Usuario usuarioEncontrado = buscarUsuario(
            usuarios, qtdUsuarios, matriculaBusca
    );

    if (usuarioEncontrado == null) {

        IO.println(
                "Usuário não localizado. Nenhuma alteração feita."
        );

    } else {

        IO.println("\nUsuário encontrado:");
        mostrarUsuario(usuarioEncontrado);

        IO.println("\n1 - Alterar nome");
        IO.println("2 - Alterar limite de empréstimos");

        String opcao = IO.readln("Escolha uma opção: ").trim();

        if (opcao.equals("1")) {

            String novoNome = IO.readln("Digite o novo nome: ");

            if (usuarioEncontrado.setNome(novoNome)) {
                IO.println("Nome alterado com sucesso!");
            } else {
                IO.println(
                        "Nome inválido. Nenhuma alteração feita."
                );
            }

        } else if (opcao.equals("2")) {

            int novoLimite = lerNumeroInteiro(
                    "Digite o novo limite: "
            );

            if (usuarioEncontrado.setLimiteEmprestimos(novoLimite)) {
                IO.println("Limite alterado com sucesso!");
            } else {
                IO.println(
                        "Limite inválido. Nenhuma alteração feita."
                );
            }

        } else {
            IO.println(
                    "Opção inválida. Nenhuma alteração feita."
            );
        }

        IO.println("\nDados atuais do usuário:");
        mostrarUsuario(usuarioEncontrado);
    }
}

static int lerNumeroInteiro(String mensagem) {

    while (true) {
        try {
            return Integer.parseInt(
                    IO.readln(mensagem).trim()
            );
        } catch (NumberFormatException e) {
            IO.println(
                    "Digite um número inteiro válido. Tente novamente."
            );
        }
    }
}

static void listarAcervo(Livro[] acervo, int qtdLivros) {

    IO.println("\n=========== ACERVO ===========");

    if (qtdLivros == 0) {
        IO.println("Acervo vazio.");
        return;
    }

    for (int i = 0; i < qtdLivros; i++) {
        if (acervo[i] != null) {
            IO.println(acervo[i]);
            IO.println();
        }
    }
}

static Usuario buscarUsuario(
        Usuario[] usuarios,
        int qtdUsuarios,
        String matricula) {

    for (int i = 0; i < qtdUsuarios; i++) {

        if (usuarios[i] != null &&
                usuarios[i].getMatricula().equals(matricula)) {
            return usuarios[i];
        }
    }

    return null;
}

static void mostrarUsuario(Usuario usuario) {

    IO.println("Nome: " + usuario.getNome());
    IO.println("Matrícula: " + usuario.getMatricula());
    IO.println("Tipo: " + usuario.getTipo());
    IO.println(
            "Limite de empréstimos: "
                    + usuario.getLimiteEmprestimos()
    );
    IO.println(
            "Empréstimos ativos: "
                    + usuario.getEmprestimosAtivos()
    );
}
