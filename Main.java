/**
 * Classe principal do sistema de cadastro de academia.
 * 
 * Esta classe contém o método main que inicializa o sistema de cadastro e
 * permite ao usuário interagir com ele através de um menu no console.
 * 
 * Funcionalidades disponíveis:
 * 1. Cadastrar Unidade: Permite cadastrar uma nova unidade da academia.
 * 2. Cadastrar Aluno: Permite cadastrar um novo aluno em uma unidade específica.
 * 3. Cadastrar Professor: Permite cadastrar um novo professor em uma unidade específica.
 * 4. Consultar Alunos de uma Unidade: Permite consultar todos os alunos cadastrados em uma unidade específica.
 * 5. Consultar Professores de uma Unidade: Permite consultar todos os professores cadastrados em uma unidade específica.
 * 6. Consultar Unidades Cadastradas: Lista todas as unidades cadastradas no sistema.
 * 7. Consultar Informações de uma Unidade: Permite consultar informações detalhadas de uma unidade específica.
 * 8. Sair: Encerra o sistema.
 * 
 * O sistema utiliza a classe Scanner para ler a entrada do usuário e a classe
 * SistemaCadastro para gerenciar as operações de cadastro e consulta.
 * 
 * Exceções tratadas:
 * - InputMismatchException: Tratada quando o usuário insere um valor não numérico
 *   ao escolher uma opção do menu.
 * 
 * O loop principal continua executando até que o usuário escolha a opção de sair (opção 8).
 * 
 * @param args Argumentos da linha de comando (não utilizados).
 */

 import java.util.Scanner;
 import java.util.InputMismatchException;
 
 public class Main {
     public static void main(String[] args) {
         SistemaCadastro sistema = new SistemaCadastro();
         Scanner scanner = new Scanner(System.in);
         boolean continuar = true;
 
         while (continuar) {
             System.out.println("\n--- Sistema de Cadastro ---");
             System.out.println("1. Cadastrar Unidade");
             System.out.println("2. Cadastrar Aluno");
             System.out.println("3. Cadastrar Professor");
             System.out.println("4. Consultar Alunos de uma Unidade");
             System.out.println("5. Consultar Professores de uma Unidade");
             System.out.println("6. Consultar Unidades Cadastradas");
             System.out.println("7. Consultar Informações de uma Unidade");
             System.out.println("8. Sair");
             System.out.print("Escolha uma opção: ");
 
             int opcao = 0;
             try {
                 opcao = scanner.nextInt();
                 scanner.nextLine(); // Consumir nova linha
             } catch (InputMismatchException e) {
                 System.out.println("Por favor, insira um número válido.");
                 scanner.nextLine(); // Limpar o buffer
                 continue;
             }
 
             switch (opcao) {
                 case 1:
                     System.out.print("Endereço da Unidade: ");
                     String endereco = scanner.nextLine();
                     System.out.print("Nome Fantasia da Unidade: ");
                     String nomeFantasia = scanner.nextLine();
                     sistema.cadastrarUnidade(endereco, nomeFantasia);
                     break;
                 case 2:
                     System.out.print("Nome do Aluno: ");
                     String nomeAluno = scanner.nextLine();
                     System.out.print("Idade do Aluno: ");
                     int idade = scanner.nextInt();
                     scanner.nextLine(); // Consumir nova linha
                     System.out.print("Nome da Unidade: ");
                     String nomeUnidadeAluno = scanner.nextLine();
                     sistema.cadastrarAluno(nomeAluno, idade, nomeUnidadeAluno);
                     break;
                 case 3:
                     System.out.print("Nome do Professor: ");
                     String nomeProfessor = scanner.nextLine();
                     System.out.print("Especialidade do Professor: ");
                     String especialidade = scanner.nextLine();
                     System.out.print("Nome da Unidade: ");
                     String nomeUnidadeProfessor = scanner.nextLine();
                     sistema.cadastrarProfessor(nomeProfessor, especialidade, nomeUnidadeProfessor);
                     break;
                 case 4:
                     System.out.print("Nome da Unidade: ");
                     String nomeConsultaAluno = scanner.nextLine();
                     System.out.println(sistema.consultarAlunos(nomeConsultaAluno));
                     break;
                 case 5:
                     System.out.print("Nome da Unidade: ");
                     String nomeConsultaProfessor = scanner.nextLine();
                     System.out.println(sistema.consultarProfessores(nomeConsultaProfessor));
                     break;
                 case 6:
                     System.out.println(sistema.listarUnidades());
                     break;
                 case 7:
                     System.out.print("Nome da Unidade: ");
                     String nomeConsultaUnidade = scanner.nextLine();
                     System.out.println(sistema.consultarInformacoesUnidade(nomeConsultaUnidade));
                     break;
                 case 8:
                     continuar = false;
                     break;
                 default:
                     System.out.println("Opção inválida.");
                     break;
             }
         }
 
         scanner.close();
     }
 }
 