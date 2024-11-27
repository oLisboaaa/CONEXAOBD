package br.com.aula.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletarDados {
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
        Connection conexao = ConexaoDB.conectar();
        if (conexao != null) {
            String sql = "DELETE FROM alunos WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            	System.out.print("Digite o ID a ser excluido: ");
            	int id = scan.nextInt();
            	
                stmt.setInt(1, id);
                stmt.executeUpdate();

                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Dados deletados com sucesso!");
                } else {
                    System.out.println("Nenhum dado foi encontrado para excluir.");
                }
            } catch (SQLException e) {
                System.err.println("Erro ao deletar dados: " + e.getMessage());
            } finally {
                try {
                    if (conexao != null) conexao.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        }
        /*scan.close();*/
    }
}
