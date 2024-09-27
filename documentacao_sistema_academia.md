
# Documentação do Sistema de Academia

## Descrição Geral
O **Sistema de Academia** é um software desenvolvido em **Java**, utilizando o **Swing** para a criação da interface gráfica. Seu objetivo é gerenciar o cadastro de alunos, professores e unidades de uma academia fictícia. O sistema pode ser executado tanto no modo terminal quanto no modo GUI (Interface Gráfica de Usuário).

## Funcionalidades
1. **Cadastro de Unidades**: Permite o registro de unidades da academia, onde serão alocados alunos e professores.
2. **Cadastro de Professores**: Registra os professores da academia, incluindo suas especialidades e a unidade onde lecionam.
3. **Cadastro de Alunos**: Insere alunos no sistema, associando-os a uma unidade específica.
4. **Sistema de Matrículas**: As matrículas são geradas automaticamente, diferenciando-se entre alunos e professores.

## Regras do Sistema
- Para cadastrar um aluno ou professor, é necessário que haja pelo menos uma unidade cadastrada.
- **Matrículas**:
  - Alunos recebem uma matrícula automática iniciada pela letra **A**.
  - Professores recebem uma matrícula automática iniciada pela letra **P**.
- O campo de **especialidade** é obrigatório para professores.
- O campo **idade** deve ser sempre um número inteiro.

## Estrutura de Arquivos
O sistema está organizado em diversas classes que foram separadas para facilitar a compreensão e manutenção do código:

1. **Aluno.java**: Define a classe que representa um aluno da academia, com atributos como nome, idade e matrícula.
2. **Professor.java**: Define a classe que representa um professor, com atributos como nome, especialidade e matrícula.
3. **Unidade.java**: Representa a unidade da academia, onde os alunos e professores estão alocados.
4. **SistemaCadastro.java**: Gerencia as operações de cadastro e controle dos dados inseridos.
5. **CadastroAcademiaGUI.java**: Responsável pela interface gráfica do sistema.
6. **Main.java**: Ponto de entrada do sistema, onde é definida a execução do programa.

## Execução do Sistema
O sistema pode ser executado de duas formas:
- **Modo Terminal**: Através de comandos via linha de comando para interação com o sistema.
- **Modo GUI (Interface Gráfica)**: Através de uma interface gráfica interativa, utilizando componentes Swing.

## Requisitos Técnicos
- **Java Development Kit (JDK)** versão 8 ou superior.

## Exemplos de Uso

1. **Cadastro de Unidade**:
   - Primeiro, o usuário deve registrar uma unidade da academia. Essa unidade será usada como referência para alocar alunos e professores.

2. **Cadastro de Professor**:
   - Nome, especialidade e idade devem ser informados. A matrícula será gerada automaticamente.
   
3. **Cadastro de Aluno**:
   - Nome, idade e unidade de matrícula são necessários para o registro do aluno.

---

## Melhorias Futuras
- Adição de um sistema de relatórios para análise dos cadastros de alunos e professores.
- Implementação de novas funcionalidades, como registro de aulas e controle de presença.
- Adaptação para um banco de dados relacional para melhor persistência dos dados.
