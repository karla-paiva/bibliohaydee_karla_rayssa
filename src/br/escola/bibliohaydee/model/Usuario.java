
package br.escola.bibliohaydee.model;

public class Usuario {

    public static final int LIMITE_PADRAO = 3;

    private String nome;
    private String matricula;
    private String tipo;
    private Integer limiteEmprestimos;
    private Integer emprestimosAtivos;

    public Usuario(String nomeUsuario, String matriculaUsuario,
                   String tipoUsuario, Integer limiteUsuario) {

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

    public Usuario(String nomeUsuario, String matriculaUsuario,
                   String tipoUsuario) {

        this(nomeUsuario, matriculaUsuario, tipoUsuario,
                LIMITE_PADRAO);
    }

    private static boolean nomeValido(String nome) {
        return nome != null && !nome.isBlank();
    }

    private static boolean limiteValido(int limite) {
        return limite >= 1;
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

    public boolean setNome(String novoNome) {
        if (!nomeValido(novoNome)) {
            return false;
        }

        nome = novoNome.trim();
        return true;
    }

    public boolean setLimiteEmprestimos(int novoLimite) {
        if (!limiteValido(novoLimite)) {
            return false;
        }

        limiteEmprestimos = novoLimite;
        return true;
    }

    @Override
    public String toString() {
        return "Nome: " + nome
                + " | Matrícula: " + matricula
                + " | Tipo: " + tipo
                + " | Limite de empréstimos: " + limiteEmprestimos
                + " | Empréstimos ativos: " + emprestimosAtivos;
    }
}
