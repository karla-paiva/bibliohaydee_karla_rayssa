
package br.escola.bibliohaydee.model;

public class Livro {

    private String titulo;
    private String isbn;
    private Autor autor;
    private Integer anoDePublicacao;
    private String genero;
    private boolean disponibilidade;

    public Livro(String tituloLivro, String isbnLivro,
                 Autor autorLivro, int anoDePublicacaoLivro,
                 String generoLivro) {

        titulo = tituloLivro;
        isbn = isbnLivro;
        autor = autorLivro;
        anoDePublicacao = anoDePublicacaoLivro;
        genero = generoLivro;
        disponibilidade = true;
    }

    public Livro(String tituloLivro, String isbnLivro,
                 Autor autorLivro, int anoDePublicacaoLivro) {

        this(tituloLivro, isbnLivro, autorLivro,
                anoDePublicacaoLivro, "Não informado");
    }

    @Override
    public String toString() {
        return "Título: " + titulo
                + " | ISBN: " + isbn
                + "\nAutor: " + autor
                + "\nAno de publicação: " + anoDePublicacao
                + " | Gênero: " + genero
                + " | Disponibilidade: "
                + (disponibilidade ? "disponível" : "emprestado");
    }
}
