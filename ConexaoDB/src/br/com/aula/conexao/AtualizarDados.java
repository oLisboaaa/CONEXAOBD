package br.com.aula.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AtualizarDados {
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
        Connection conexao = ConexaoDB.conectar();
        if (conexao != null) {
            String sql = "UPDATE alunos SET nome = ?, idade = ? WHERE id = ?";
            try {
                PreparedStatement stmt = conexao.prepareStatement(sql);
                
               
                System.out.print("Informe o ID do aluno: ");
                int id = scan.nextInt();
                scan.nextLine();

                System.out.print("Informe o novo nome do aluno: ");
                String nome = scan.nextLine();

                System.out.print("Informe a nova idade do aluno: ");
                int idade = scan.nextInt();
                
                stmt.setString(1, nome);
                stmt.setInt(2, idade);
                stmt.setInt(3, id);
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
        /*scan.close();*/
    }
    
}
