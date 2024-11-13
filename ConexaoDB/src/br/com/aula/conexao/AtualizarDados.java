package br.com.aula.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AtualizarDados {
    public static void main(String[] args) {
        Connection conexao = ConexaoDB.conectar();
        if (conexao != null) {
            String sql = "UPDATE alunos SET nome = ?, idade = ? WHERE id = ?";
            try {
                PreparedStatement stmt = conexao.prepareStatement(sql);
                
                // Atualizar registro com id 1
                stmt.setString(1, "João Silva");
                stmt.setInt(2, 21); // Exemplo: nova idade
                stmt.setInt(3, 1);  // ID do registro a ser atualizado
                stmt.executeUpdate();
                
                // Atualizar registro com id 2
                stmt.setString(1, "Maria Souza");
                stmt.setInt(2, 23); // Exemplo: nova idade
                stmt.setInt(3, 2);  // ID do registro a ser atualizado
                stmt.executeUpdate();
                
                // Atualizar registro com id 3
                stmt.setString(1, "Pedro Santos");
                stmt.setInt(2, 26); // Exemplo: nova idade
                stmt.setInt(3, 3);  // ID do registro a ser atualizado
                stmt.executeUpdate();
                
                System.out.println("Dados atualizados com sucesso!");
            } catch (SQLException e) {
                System.err.println("Erro ao atualizar dados: " + e.getMessage());
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
