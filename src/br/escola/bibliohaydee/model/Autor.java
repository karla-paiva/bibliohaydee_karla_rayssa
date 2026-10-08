package br.escola.bibliohaydee.model;

public class Autor {
    private String nome;
    private String nacionalidade;
    private int anoNascimento;

    public Autor() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("o nome do autor não pode ser vazio.");
        }
        this.nome = nome.trim();
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    @Override
    public String toString() {
        return nome + " (" + nacionalidade + ", nascido em " + anoNascimento + ")";
    }
}
