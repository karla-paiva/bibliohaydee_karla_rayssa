
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

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public Autor getAutor() {
        return autor;
    }

    public Integer getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public String getGenero() {
        return genero;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    @Override
    public String toString() {
        return "Título: " + titulo
                + " | ISBN: " + isbn
                + "\nAutor: " + autor.getNome()
                + "\nAno de publicação: " + anoDePublicacao
                + " | Gênero: " + genero
                + " | Disponibilidade: "
                + (disponibilidade ? "Disponível" : "Emprestado");
    }
}
