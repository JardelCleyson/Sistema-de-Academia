/**
 * A classe Unidade representa uma unidade de uma academia, contendo informações
 * sobre o endereço, nome fantasia, alunos e professores associados.
 * 
 * <p>Esta classe fornece métodos para adicionar alunos e professores à unidade,
 * bem como para recuperar as listas de alunos e professores.</p>
 * 
 * <p>Exemplo de uso:</p>
 * <pre>{@code
 * Unidade unidade = new Unidade("Rua Exemplo, 123", "Academia Exemplo");
 * unidade.adicionarAluno(new Aluno("João"));
 * unidade.adicionarProfessor(new Professor("Maria"));
 * System.out.println(unidade);
 * }</pre>
 * 
 * @author Jardel
 */

import java.util.ArrayList;
import java.util.List;


public class Unidade {
    private String endereco;
    private String nomeFantasia;
    private List<Aluno> alunos;
    private List<Professor> professores;

    public Unidade(String endereco, String nomeFantasia) {
        this.endereco = endereco;
        this.nomeFantasia = nomeFantasia;
        this.alunos = new ArrayList<>();
        this.professores = new ArrayList<>();
    }

    // Métodos para adicionar Alunos e Professores à Unidade
    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void adicionarProfessor(Professor professor) {
        professores.add(professor);
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    @Override
    public String toString() {
        return "Unidade: " + nomeFantasia + ", Endereço: " + endereco;
    }
}
