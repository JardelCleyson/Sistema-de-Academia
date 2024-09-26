public class Professor {
    private String nome;
    private String matricula;
    private String especialidade;

    public Professor(String nome, String matricula, String especialidade) {
        this.nome = nome;
        this.matricula = matricula;
        this.especialidade = especialidade;
    }

    // Métodos Getter
    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    @Override
    public String toString() {
        return "Professor: " + nome + ", Matrícula: " + matricula + ", Especialidade: " + especialidade;
    }
}
