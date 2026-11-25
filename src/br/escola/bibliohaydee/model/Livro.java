
package br.escola.bibliohaydee.model;

public class Livro {

    private String titulo;
    private String isbn;
    private Autor autor;
    private int anoDePublicacao;
    private String genero;
    private boolean disponibilidade;

    public Livro(String titulo, String isbn, Autor autor,
                 int anoDePublicacao, String genero) {

        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.anoDePublicacao = anoDePublicacao;
        this.genero = genero;
        this.disponibilidade = true;
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

    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public String getGenero() {
        return genero;
    }

    public boolean estaDisponivel() {
        return disponibilidade;
    }

    public boolean emprestar() {

        if (!disponibilidade) {
            return false;
        }

        disponibilidade = false;
        return true;
    }


    @Override
    public String toString() {
        return "Título: " + titulo +
                "\nISBN: " + isbn +
                "\nAutor: " + autor.getNome() +
                "\nAno: " + anoDePublicacao +
                "\nGênero: " + genero +
                "\nDisponibilidade: " +
                (disponibilidade ? "Disponível" : "Emprestado");
    }
}
