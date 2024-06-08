package org.example;

import org.example.models.Alunos;
import org.example.models.Turmas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Turmas> listaDeTurmas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("## Escolha a ação que deseja utilizar ##");
            System.out.println("Opção 1 - Cadastrar uma nova turma");;
            System.out.println("Opção 2 - Cadastrar um novo aluno e vinculá-lo a uma turma");
            System.out.println("Opção 3 - Consultar os alunos cadastrados em uma turma específica");
            System.out.println("Opção 4 - Consultar todas as turmas existentes");
            System.out.println("Opção 0 - Encerrar programa");
            System.out.println("_____________________________________________________________________");

            System.out.print("Digite aqui sua opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    // Cadastro de turma
                    System.out.print("##### CADASTRO DE NOVAS TURMAS #####");

                    System.out.print("\nDigite a localização da sala: ");
                    String localizacao = scanner.nextLine();


                    System.out.print("Digite o nome da sala: ");
                    String nomeSala = scanner.nextLine();

                    Turmas novaTurma = new Turmas(nomeSala, localizacao);
                    listaDeTurmas.add(novaTurma);
                    System.out.println("Turma cadastrada com sucesso!");
                    break;

                case 2:
                    // Cadastro de aluno em uma turma
                    if (listaDeTurmas.isEmpty()) {
                        System.out.println("Nenhuma turma cadastrada. Cadastre uma turma primeiro.");
                        break;
                    }
                    System.out.println("********* Turmas registradas *********");
                    for (Turmas turma : listaDeTurmas) {
                        System.out.println(turma);
                    }

                    System.out.print("Digite a localização da turma para adicionar o aluno: ");
                    String codigoTurma = scanner.nextLine();
                    Turmas turmaSelecionada = null;

                    for (Turmas turma : listaDeTurmas) {
                        if (turma.localizacao.equals(codigoTurma)) {
                            turmaSelecionada = turma;
                            break;
                        }
                    }

                    if (turmaSelecionada == null) {
                        System.out.println("Turma não encontrada.");
                        break;
                    }

                    System.out.print("Digite o nome do aluno: ");
                    String nomeAluno = scanner.nextLine();

                    System.out.print("Digite a matrícula do aluno: ");
                    int matricula = Integer.parseInt(scanner.nextLine());

                    System.out.print("Digite a idade do aluno: ");
                    int idade = Integer.parseInt(scanner.nextLine());

                    Alunos novoAluno = new Alunos(nomeAluno, matricula, idade);
                    turmaSelecionada.adicionarAlunos(novoAluno);
                    System.out.println("Aluno cadastrado com sucesso!");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                    break;

                case 3:
                    // Consultar alunos de uma turma específica
                    if (listaDeTurmas.isEmpty()) {
                        System.out.println("Nenhuma turma cadastrada.");
                        break;
                    }

                    System.out.println("********* Turmas registradas *********");
                    for (Turmas turma : listaDeTurmas) {
                        System.out.println(turma);
                    }

                    System.out.print("Digite a localização da turma para listar os alunos: ");

                    String codigoTurmaConsulta = scanner.nextLine();
                    Turmas turmaConsulta = null;

                    for (Turmas turma : listaDeTurmas) {
                        if (turma.localizacao.equals(codigoTurmaConsulta)) {
                            turmaConsulta = turma;
                            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                            break;
                        }
                    }

                    if (turmaConsulta == null) {
                        System.out.println("Turma não encontrada.");
                        break;
                    }

                    turmaConsulta.listarAlunos();
                    break;

                case 4:
                    // Consultar todas as turmas
                    if (listaDeTurmas.isEmpty()) {
                        System.out.println("Nenhuma turma cadastrada.");
                        break;
                    }

                    System.out.println("********* Turmas registradas *********");
                    for (Turmas turma : listaDeTurmas) {
                        System.out.println(turma);
                        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    }
                    break;

                case 0:
                    System.out.println("Aplicação encerrada");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}
