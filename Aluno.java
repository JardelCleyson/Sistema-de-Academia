/**
 * A classe Aluno representa um aluno com nome, idade e matrícula.
 * 
 * <p>Esta classe fornece métodos para acessar os atributos do aluno, 
 * como nome, idade e matrícula. Além disso, sobrescreve o método 
 * {@code toString()} para fornecer uma representação textual do aluno.</p>
 * 
 * <p>Exemplo de uso:</p>
 * <pre>{@code
 * Aluno aluno = new Aluno("João", 20, "20230001");
 * System.out.println(aluno.getNome()); // João
 * System.out.println(aluno.getIdade()); // 20
 * System.out.println(aluno.getMatricula()); // 20230001
 * System.out.println(aluno); // Aluno: João, Idade: 20, Matrícula: 20230001
 * }</pre>
 * 
 * @author Jardel Cleyson
 */
public class Aluno {
    private String nome;
    private int idade;
    private String matricula;

    public Aluno(String nome, int idade, String matricula) {
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
    }

    // Métodos Getter
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return "Aluno: " + nome + ", Idade: " + idade + ", Matrícula: " + matricula;
    }
}
