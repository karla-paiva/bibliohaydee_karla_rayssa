
import br.escola.bibliohaydee.model.Autor;
import br.escola.bibliohaydee.model.Livro;

void main() {
    Autor [] autores = new Autor[5];
    Livro [] livros = new Livro[10];
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