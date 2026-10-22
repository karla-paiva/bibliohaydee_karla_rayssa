package br.escola.bibliohaydee.model;

public class Usuario {

    private String nome;
    private String matricula;
    private String tipo; // somente ALUNO ou PROFESSOR
    private Integer limiteEmprestimos;
    private Integer emprestimosAtivos; // começa em zero

    public Usuario(String nomeUsuario, String matriculaUsuario,
                   String tipoUsuario, Integer limiteUsuario) {

        if (nomeUsuario == null || nomeUsuario.isBlank()) {
            throw new IllegalArgumentException(
                    "Nome não pode ser nulo ou vazio");
        }

        if (tipoUsuario == null ||
                (!tipoUsuario.equals("ALUNO") &&
                        !tipoUsuario.equals("PROFESSOR"))) {
            throw new IllegalArgumentException(
                    "Tipo deve ser ALUNO ou PROFESSOR");
        }

        nome = nomeUsuario;
        matricula = matriculaUsuario;
        tipo = tipoUsuario;
        limiteEmprestimos = limiteUsuario;
        emprestimosAtivos = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getLimiteEmprestimos() {
        return limiteEmprestimos;
    }

    public Integer getEmprestimosAtivos() {
        return emprestimosAtivos;
    }

    public void setNome(String novoNome) {
        if (novoNome == null || novoNome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        nome = novoNome;
    }

    public void setTipo(String novoTipo) {
        if (novoTipo == null ||
                (!novoTipo.equals("ALUNO") &&
                        !novoTipo.equals("PROFESSOR"))) {
            throw new IllegalArgumentException("Tipo inválido");
        }
        tipo = novoTipo;
    }
}