package br.escola.bibliohaydee.model;

public class Livro {
    String titulo;
    String isbn;
    Autor autor;
    Integer anoDePublicacao;
    String genero;
    boolean disponibilidade;

    public Livro(String tituloLivro, String isbnLivro, Autor autorLivro, int anoDePublicacaoLivro, String generoLivro) {
        titulo = tituloLivro;
        isbn = isbnLivro;
        autor = autorLivro;
        anoDePublicacao = anoDePublicacaoLivro;
        genero = generoLivro;
        disponibilidade = true;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo +
                " | ISBN : " + isbn +
                "\nAutor : " + autor +
                "\nAno de publicação: " + anoDePublicacao +
                " | Gênero: " + genero +
                " | Disponibilidade : " + (disponibilidade ? "disponível" : "emprestado");
    }

}