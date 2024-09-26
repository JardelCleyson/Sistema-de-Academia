/**
 * A classe CadastroAcademiaGUI é responsável por criar a interface gráfica do sistema de cadastro de uma academia.
 * Ela permite cadastrar unidades, alunos e professores, além de consultar informações sobre as unidades cadastradas.
 * 
 * Funcionalidades:
 * - Cadastrar Unidade: Permite cadastrar uma nova unidade informando o endereço e o nome fantasia.
 * - Cadastrar Aluno: Permite cadastrar um novo aluno informando o nome, idade e a unidade.
 * - Cadastrar Professor: Permite cadastrar um novo professor informando o nome, especialidade e a unidade.
 * - Listar Unidades: Exibe uma lista de todas as unidades cadastradas.
 * - Consultar Alunos de uma Unidade: Exibe uma lista de alunos de uma unidade específica.
 * - Consultar Professores de uma Unidade: Exibe uma lista de professores de uma unidade específica.
 * - Consultar Informações de uma Unidade: Exibe informações detalhadas de uma unidade específica.
 * - Consultar Todas as Unidades: Exibe uma lista de todas as unidades cadastradas.
 * 
 * A interface gráfica é construída utilizando a biblioteca Swing, com uma janela principal contendo botões para cada funcionalidade.
 * 
 * Atributos:
 * - sistema: Instância da classe SistemaCadastro que gerencia os dados do sistema.
 * 
 * Métodos:
 * - CadastroAcademiaGUI(): Construtor da classe que inicializa o sistema e cria a interface gráfica.
 * - criarInterface(): Método privado que configura a interface gráfica e adiciona os botões e suas respectivas ações.
 * 
 * Método Main:
 * - main(String[] args): Método principal que inicia a aplicação utilizando SwingUtilities.invokeLater.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroAcademiaGUI {
    private SistemaCadastro sistema;

    public CadastroAcademiaGUI() {
        sistema = new SistemaCadastro();
        criarInterface();
    }

    private void criarInterface() {
        JFrame frame = new JFrame("Sua Academia");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());

        // Botão para cadastrar unidade
        JButton btnCadastrarUnidade = new JButton("Cadastrar Unidade");
        btnCadastrarUnidade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String endereco = JOptionPane.showInputDialog("Endereço da Unidade:");
                String nomeFantasia = JOptionPane.showInputDialog("Nome Fantasia da Unidade:");
                if (endereco == null || endereco.trim().isEmpty() || nomeFantasia == null || nomeFantasia.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                sistema.cadastrarUnidade(endereco, nomeFantasia);
            }
        });
        frame.add(btnCadastrarUnidade);

        // Botão para cadastrar aluno
        JButton btnCadastrarAluno = new JButton("Cadastrar Aluno");
        btnCadastrarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeAluno = JOptionPane.showInputDialog("Nome do Aluno:");
                if (nomeAluno == null || nomeAluno.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, preencha o nome do aluno.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String idadeStr = JOptionPane.showInputDialog("Idade do Aluno:");
                int idade;
                try {
                    idade = Integer.parseInt(idadeStr);
                    if (idade <= 0) {
                        JOptionPane.showMessageDialog(frame, "Idade deve ser um número positivo.", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira uma idade válida.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String nomeUnidade = JOptionPane.showInputDialog("Nome da Unidade:");
                sistema.cadastrarAluno(nomeAluno, idade, nomeUnidade);
            }
        });
        frame.add(btnCadastrarAluno);

        // Botão para cadastrar professor
        JButton btnCadastrarProfessor = new JButton("Cadastrar Professor");
        btnCadastrarProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeProfessor = JOptionPane.showInputDialog("Nome do Professor:");
                if (nomeProfessor == null || nomeProfessor.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, preencha o nome do professor.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String especialidade = JOptionPane.showInputDialog("Especialidade do Professor:");
                if (especialidade == null || especialidade.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, preencha a especialidade.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String nomeUnidade = JOptionPane.showInputDialog("Nome da Unidade:");
                sistema.cadastrarProfessor(nomeProfessor, especialidade, nomeUnidade);
            }
        });
        frame.add(btnCadastrarProfessor);

        // Botão para listar unidades
        JButton btnListarUnidades = new JButton("Listar Unidades");
        btnListarUnidades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String unidades = sistema.listarUnidades();
                JOptionPane.showMessageDialog(frame, unidades, "Unidades Cadastradas", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        frame.add(btnListarUnidades);

        // Botão para consultar alunos de uma unidade
        JButton btnConsultarAlunos = new JButton("Consultar Alunos de uma Unidade");
        btnConsultarAlunos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeUnidade = JOptionPane.showInputDialog("Nome da Unidade:");
                String alunos = sistema.consultarAlunos(nomeUnidade);
                JOptionPane.showMessageDialog(frame, alunos, "Alunos da Unidade", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        frame.add(btnConsultarAlunos);

        // Botão para consultar professores de uma unidade
        JButton btnConsultarProfessores = new JButton("Consultar Professores de uma Unidade");
        btnConsultarProfessores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeUnidade = JOptionPane.showInputDialog("Nome da Unidade:");
                String professores = sistema.consultarProfessores(nomeUnidade);
                JOptionPane.showMessageDialog(frame, professores, "Professores da Unidade", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        frame.add(btnConsultarProfessores);

        // Botão para consultar informações de uma unidade
        JButton btnConsultarInformacoes = new JButton("Consultar Informações de uma Unidade");
        btnConsultarInformacoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeUnidade = JOptionPane.showInputDialog("Nome da Unidade:");
                String informacoes = sistema.consultarInformacoesUnidade(nomeUnidade);
                JOptionPane.showMessageDialog(frame, informacoes, "Informações da Unidade", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        frame.add(btnConsultarInformacoes);

        // Exibir a janela
        frame.setVisible(true);
    // Botão para consultar todas as unidades
    JButton btnConsultarTodasUnidades = new JButton("Consultar Todas as Unidades");
    btnConsultarTodasUnidades.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String todasUnidades = sistema.consultarTodasUnidades();
            JOptionPane.showMessageDialog(frame, todasUnidades, "Todas as Unidades", JOptionPane.INFORMATION_MESSAGE);
        }
    });
    frame.add(btnConsultarTodasUnidades);

    // Exibir a janela
    frame.setVisible(true);
}

public static void main(String[] args) {
    SwingUtilities.invokeLater(CadastroAcademiaGUI::new);
}
}
