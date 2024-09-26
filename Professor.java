/**
 * A classe Professor representa um professor com nome, matrícula e especialidade.
 * 
 * <p>Esta classe fornece métodos para acessar os atributos do professor, 
 * como nome, matrícula e especialidade. Além disso, sobrescreve o método 
 * toString para fornecer uma representação textual do objeto Professor.</p>
 * 
 * <p>Exemplo de uso:</p>
 * <pre>{@code
 * Professor professor = new Professor("João Silva", "12345", "Personal Trainer");
 * System.out.println(professor.getNome()); // João Silva
 * System.out.println(professor.getMatricula()); // 12345
 * System.out.println(professor.getEspecialidade()); // Personal Trainer
 * System.out.println(professor.toString()); // Professor: João Silva, Matrícula: 12345, Especialidade: Personal Trainer
 * }</pre>
 * 
 * @author Jardel
 */
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
