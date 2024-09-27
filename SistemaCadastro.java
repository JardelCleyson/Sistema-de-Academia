/**
 * A classe SistemaCadastro é responsável pelo gerenciamento de unidades, alunos e professores
 * em um sistema de cadastro de academia. Ela permite cadastrar novas unidades, alunos e professores,
 * além de consultar informações detalhadas sobre eles.
 * 
 * Atributos:
 * - unidades: Lista de unidades cadastradas.
 * - contadorAlunos: Contador para geração de matrículas de alunos.
 * - contadorProfessores: Contador para geração de matrículas de professores.
 * 
 * Métodos:
 * - SistemaCadastro(): Construtor que inicializa a lista de unidades e os contadores.
 * - void cadastrarUnidade(String endereco, String nomeFantasia): Cadastra uma nova unidade.
 * - String listarUnidades(): Lista todas as unidades cadastradas.
 * - void cadastrarAluno(String nome, int idade, String nomeUnidade): Cadastra um novo aluno em uma unidade específica.
 * - void cadastrarProfessor(String nome, String especialidade, String nomeUnidade): Cadastra um novo professor em uma unidade específica.
 * - String consultarAlunos(String nomeUnidade): Consulta alunos cadastrados em uma unidade específica.
 * - String consultarProfessores(String nomeUnidade): Consulta professores cadastrados em uma unidade específica.
 * - String consultarInformacoesUnidade(String nomeUnidade): Consulta informações detalhadas de uma unidade específica.
 * - String consultarTodasUnidades(): Consulta todas as unidades cadastradas, incluindo seus alunos e professores.
 * - String gerarMatriculaAluno(): Gera uma matrícula para um novo aluno.
 * - String gerarMatriculaProfessor(): Gera uma matrícula para um novo professor.
 * - Unidade encontrarUnidade(String nomeFantasia): Encontra uma unidade pelo nome fantasia.
 */

 import java.util.ArrayList;
 import java.util.List;
 import java.util.Random;

 public class SistemaCadastro {
    private List<Unidade> unidades;
    private int contadorAlunos; // Contador para matrículas de alunos
    private int contadorProfessores; // Contador para matrículas de professores
    private Random random; // Gerador de números aleatórios

    /**
     * Construtor da classe SistemaCadastro. Inicializa a lista de unidades e contadores.
     */
    public SistemaCadastro() {
        unidades = new ArrayList<>();
        contadorAlunos = 1;
        contadorProfessores = 1;
        random = new Random();
        inicializarMock(); // Inicializa dados mock
    }

    /**
     * Inicializa dados mock de unidades, alunos e professores.
     */
    private void inicializarMock() {
        String[] nomesUnidades = {"Academia Fitness", "Gym Power", "Health Club", "FitLife", "Body Builders"};
        String[] nomesAlunos = {"João", "Maria", "Carlos", "Ana", "Pedro", "Luana", "Ricardo", "Mariana", "Felipe", "Clara"};
        String[] nomesProfessores = {"Dr. Smith", "Prof. Jane", "Prof. Mike", "Prof. Lisa", "Prof. Tom"};
        String[] especialidades = {"Musculação", "Yoga", "Pilates", "Zumba", "Treinamento Funcional", "Crossfit", "AeroDance", "Boxe"};
    
        String[] ruas = {"Rua das Flores", "Avenida Brasil", "Rua da Paz", "Avenida dos Trabalhadores", "Rua do Comércio"};
        String[] bairros = {"Centro", "Jardim das Acácias", "Parque das Nações", "Vila Nova", "Lagoa Azul"};
        String[] cidades = {"São Paulo", "Rio de Janeiro", "Belo Horizonte", "Curitiba", "Porto Alegre"};
    
        for (String nomeUnidade : nomesUnidades) {
            String endereco = ruas[random.nextInt(ruas.length)] + ", " + (random.nextInt(100) + 1) + " - " + 
                              bairros[random.nextInt(bairros.length)] + ", " + 
                              cidades[random.nextInt(cidades.length)];
            cadastrarUnidade(endereco, nomeUnidade);
            
            int numAlunos = random.nextInt(6) + 5; // Gera de 5 a 10 alunos
            int numProfessores = random.nextInt(3) + 1; // Gera de 1 a 3 professores
            
            for (int i = 0; i < numAlunos; i++) {
                String alunoNome = nomesAlunos[random.nextInt(nomesAlunos.length)];
                int idade = random.nextInt(30) + 18; // Idade entre 18 e 47
                cadastrarAluno(alunoNome, idade, nomeUnidade);
            }
            
            for (int i = 0; i < numProfessores; i++) {
                String professorNome = nomesProfessores[random.nextInt(nomesProfessores.length)];
                String especialidade = especialidades[random.nextInt(especialidades.length)];
                cadastrarProfessor(professorNome, especialidade, nomeUnidade);
            }
        }
    }
    

    /**
     * Cadastra uma nova unidade.
     * @param endereco Endereço da unidade.
     * @param nomeFantasia Nome fantasia da unidade.
     */
    public void cadastrarUnidade(String endereco, String nomeFantasia) {
        Unidade unidade = new Unidade(endereco, nomeFantasia);
        unidades.add(unidade);
        System.out.println("Unidade cadastrada com sucesso!");
    }

    /**
     * Lista todas as unidades cadastradas.
     * @return String com a lista de unidades ou mensagem de nenhuma unidade.
     */
    public String listarUnidades() {
        if (unidades.isEmpty()) {
            return "Nenhuma unidade cadastrada.";
        } else {
            StringBuilder sb = new StringBuilder("Unidades cadastradas:\n");
            for (Unidade unidade : unidades) {
                sb.append(unidade).append("\n");
            }
            return sb.toString();
        }
    }

    /**
     * Cadastra um novo aluno em uma unidade específica.
     * @param nome Nome do aluno.
     * @param idade Idade do aluno.
     * @param nomeUnidade Nome da unidade onde o aluno será cadastrado.
     */
    public void cadastrarAluno(String nome, int idade, String nomeUnidade) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Nome inválido.");
            return;
        }
        if (idade <= 0) {
            System.out.println("Idade inválida.");
            return;
        }
        Unidade unidade = encontrarUnidade(nomeUnidade);
        if (unidade != null) {
            String matricula = gerarMatriculaAluno();
            Aluno aluno = new Aluno(nome, idade, matricula);
            unidade.adicionarAluno(aluno);
            System.out.println("Aluno cadastrado com sucesso na unidade " + nomeUnidade + " com matrícula " + matricula);
        } else {
            System.out.println("Unidade não encontrada. Aluno não cadastrado.");
        }
    }

    /**
     * Cadastra um novo professor em uma unidade específica.
     * @param nome Nome do professor.
     * @param especialidade Especialidade do professor.
     * @param nomeUnidade Nome da unidade onde o professor será cadastrado.
     */
    public void cadastrarProfessor(String nome, String especialidade, String nomeUnidade) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Nome inválido.");
            return;
        }
        if (especialidade == null || especialidade.trim().isEmpty()) {
            System.out.println("Especialidade inválida.");
            return;
        }
        Unidade unidade = encontrarUnidade(nomeUnidade);
        if (unidade != null) {
            String matricula = gerarMatriculaProfessor();
            Professor professor = new Professor(nome, matricula, especialidade);
            unidade.adicionarProfessor(professor);
            System.out.println("Professor cadastrado com sucesso na unidade " + nomeUnidade + " com matrícula " + matricula);
        } else {
            System.out.println("Unidade não encontrada. Professor não cadastrado.");
        }
    }

    /**
     * Consulta alunos cadastrados em uma unidade específica.
     * @param nomeUnidade Nome da unidade a ser consultada.
     * @return String com a lista de alunos ou mensagem de nenhuma aluno.
     */
    public String consultarAlunos(String nomeUnidade) {
        Unidade unidade = encontrarUnidade(nomeUnidade);
        if (unidade != null) {
            List<Aluno> alunos = unidade.getAlunos();
            if (alunos.isEmpty()) {
                return "Nenhum aluno cadastrado na unidade " + nomeUnidade + ".";
            } else {
                StringBuilder sb = new StringBuilder("Alunos da unidade " + nomeUnidade + ":\n");
                for (Aluno aluno : alunos) {
                    sb.append(aluno).append("\n");
                }
                return sb.toString();
            }
        } else {
            return "Unidade não encontrada.";
        }
    }

    /**
     * Consulta professores cadastrados em uma unidade específica.
     * @param nomeUnidade Nome da unidade a ser consultada.
     * @return String com a lista de professores ou mensagem de nenhum professor.
     */
    public String consultarProfessores(String nomeUnidade) {
        Unidade unidade = encontrarUnidade(nomeUnidade);
        if (unidade != null) {
            List<Professor> professores = unidade.getProfessores();
            if (professores.isEmpty()) {
                return "Nenhum professor cadastrado na unidade " + nomeUnidade + ".";
            } else {
                StringBuilder sb = new StringBuilder("Professores da unidade " + nomeUnidade + ":\n");
                for (Professor professor : professores) {
                    sb.append(professor).append("\n");
                }
                return sb.toString();
            }
        } else {
            return "Unidade não encontrada.";
        }
    }

    /**
     * Consulta informações detalhadas de uma unidade específica.
     * @param nomeUnidade Nome da unidade a ser consultada.
     * @return String com informações da unidade, alunos e professores.
     */
    public String consultarInformacoesUnidade(String nomeUnidade) {
        Unidade unidade = encontrarUnidade(nomeUnidade);
        if (unidade != null) {
            StringBuilder sb = new StringBuilder("Informações da unidade: " + unidade + "\n");
            sb.append("Alunos:\n");
            List<Aluno> alunos = unidade.getAlunos();
            if (alunos.isEmpty()) {
                sb.append("Nenhum aluno cadastrado.\n");
            } else {
                for (Aluno aluno : alunos) {
                    sb.append(aluno).append("\n");
                }
            }

            sb.append("Professores:\n");
            List<Professor> professores = unidade.getProfessores();
            if (professores.isEmpty()) {
                sb.append("Nenhum professor cadastrado.\n");
            } else {
                for (Professor professor : professores) {
                    sb.append(professor).append("\n");
                }
            }
            return sb.toString();
        } else {
            return "Unidade não encontrada.";
        }
    }

    /**
     * Gera uma matrícula para um novo aluno.
     * @return Matrícula gerada para o aluno.
     */
    private String gerarMatriculaAluno() {
        return "A" + String.format("%04d", contadorAlunos++);
    }

    /**
     * Gera uma matrícula para um novo professor.
     * @return Matrícula gerada para o professor.
     */
    private String gerarMatriculaProfessor() {
        return "P" + String.format("%04d", contadorProfessores++);
    }

    /**
     * Encontra uma unidade pelo nome fantasia.
     * @param nomeFantasia Nome fantasia da unidade.
     * @return Unidade correspondente ou null se não encontrada.
     */
    private Unidade encontrarUnidade(String nomeFantasia) {
        for (Unidade unidade : unidades) {
            if (unidade.getNomeFantasia().equalsIgnoreCase(nomeFantasia)) {
                return unidade;
            }
        }
        return null;
    }

/**
 * Consulta todas as unidades cadastradas, incluindo seus alunos e professores.
 * @return String com informações de todas as unidades.
 */
public String consultarTodasUnidades() {
    if (unidades.isEmpty()) {
        return "Nenhuma unidade cadastrada.";
    } else {
        StringBuilder sb = new StringBuilder("Todas as unidades cadastradas:\n");
        for (Unidade unidade : unidades) {
            sb.append(unidade).append("\n");
            sb.append("Alunos:\n");
            List<Aluno> alunos = unidade.getAlunos();
            if (alunos.isEmpty()) {
                sb.append("Nenhum aluno cadastrado.\n");
            } else {
                for (Aluno aluno : alunos) {
                    sb.append(aluno).append("\n");
                }
            }
            sb.append("Professores:\n");
            List<Professor> professores = unidade.getProfessores();
            if (professores.isEmpty()) {
                sb.append("Nenhum professor cadastrado.\n");
            } else {
                for (Professor professor : professores) {
                    sb.append(professor).append("\n");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}


}
