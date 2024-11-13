package br.com.aula.conexao;

import java.util.Scanner;

public class TabelaAlunosCLI {

    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
    	
    	InserirDados insert = new InserirDados();
    	AtualizarDados update = new AtualizarDados();
    	DeletarDados delete = new DeletarDados();
    	LerDados select = new LerDados();
        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer do scanner

            switch (opcao) {
	            case 1:
	                insert.main(args);
	                break;
	            case 2:
	                update.main(args);
	                break;
	            case 3:
	                delete.main(args);
	                break;
	            case 4:
	                select.main(args);
	                break;

                case 0:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // Função para exibir o menu
    private static void exibirMenu() {
        System.out.println("\n=== Gerenciamento da Tabela de Alunos ===");
        System.out.println("1 - Inserir Dados");
        System.out.println("2 - Atualizar Dados");
        System.out.println("3 - Deletar Dados");
        System.out.println("4 - Ler Dados");
        System.out.println("0 - Sair");
        System.out.print("\nEscolha uma opção: ");
    }
}