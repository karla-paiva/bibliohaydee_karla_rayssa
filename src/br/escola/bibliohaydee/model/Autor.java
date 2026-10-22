package br.escola.bibliohaydee.model;

public class Autor {
    String nome;
    String nacionalidade;
    Integer anoDeNascimento;

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