
package br.escola.bibliohaydee.model;

public class Usuario {

    private String nome;
    private String matricula;
    private String tipo;
    private Integer limiteEmprestimos;
    private int emprestimosAtivos;

    public Usuario(String nomeUsuario,
                   String matriculaUsuario,
                   String tipoUsuario,
                   Integer limiteUsuario) {

        if (!nomeValido(nomeUsuario)) {
            throw new IllegalArgumentException(
                    "Nome não pode ser nulo ou vazio");
        }

        if (matriculaUsuario == null || matriculaUsuario.isBlank()) {
            throw new IllegalArgumentException(
                    "Matrícula não pode ser vazia");
        }

        if (tipoUsuario == null ||
                (!tipoUsuario.equals("ALUNO") &&
                        !tipoUsuario.equals("PROFESSOR"))) {
            throw new IllegalArgumentException(
                    "Tipo deve ser ALUNO ou PROFESSOR");
        }

        if (limiteUsuario == null || limiteUsuario < 1) {
            throw new IllegalArgumentException(
                    "Limite deve ser maior que zero");
        }

        nome = nomeUsuario.trim();
        matricula = matriculaUsuario.trim();
        tipo = tipoUsuario;
        limiteEmprestimos = limiteUsuario;
        emprestimosAtivos = 0;
    }

    private boolean nomeValido(String nome) {
        return nome != null && !nome.isBlank();
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

    public int getEmprestimosAtivos() {
        return emprestimosAtivos;
    }

    public boolean podeEmprestar() {
        return emprestimosAtivos < limiteEmprestimos;
    }

    public void registrarEmprestimo() {
        emprestimosAtivos++;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nMatrícula: " + matricula +
                "\nTipo: " + tipo +
                "\nLimite de empréstimos: " + limiteEmprestimos +
                "\nEmpréstimos ativos: " + emprestimosAtivos;
    }
}
