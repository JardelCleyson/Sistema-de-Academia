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
