
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

    public Autor(String nome, String nacionalidade, Integer anoDeNascimento) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.anoDeNascimento = anoDeNascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public Integer getAnoDeNascimento() {
        return anoDeNascimento;
    }

    @Override
    public String toString() {
        return nome
                + " | Nacionalidade: " + nacionalidade
                + " | Ano de nascimento: " + anoDeNascimento;
    }
}
