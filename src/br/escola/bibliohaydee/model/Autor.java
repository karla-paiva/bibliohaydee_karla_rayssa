package br.escola.bibliohaydee.model;

public class Autor {
    private String nome;
    private String nacionalidade;
    private Integer anoDeNascimento;

    public Autor() {
        nome = "Harper Lee";
        nacionalidade = "norte-americana";
        anoDeNascimento = 1926;
    }

    @Override
    public String toString() {
        return nome + " | Nacionalidade: " + nacionalidade + " | Ano de nascimento: " + anoDeNascimento;
    }
}