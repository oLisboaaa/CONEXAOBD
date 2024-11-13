package br.com.aula.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletarDados {
    public static void main(String[] args) {
        // Conectar ao banco de dados
        Connection conexao = ConexaoDB.conectar();
        if (conexao != null) {
            String sql = "DELETE FROM alunos WHERE nome = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                // Definir o nome do aluno a ser excluído
                stmt.setString(1, "Maria Souza");  // Exemplo: Maria Souza

                // Executar a exclusão
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
    }
}
