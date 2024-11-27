package br.com.aula.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InserirDados {
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
        Connection conexao = ConexaoDB.conectar();
        if (conexao != null) {
            String sql = "INSERT INTO alunos (nome, idade) VALUES (?, ?)";
            try {
                PreparedStatement stmt = conexao.prepareStatement(sql);
                
                System.out.print("Digite o NOME do aluno novo: ");
                String nome  = scan.nextLine();
                
                System.out.print("Digite a IDADE do aluno novo: ");
                int idade = scan.nextInt();
                
                
                stmt.setString(1, nome);
                stmt.setInt(2, idade);
                stmt.executeUpdate();
                
                System.out.println("Dados inseridos com sucesso!");
            } catch (SQLException e) {
                System.err.println("Erro ao inserir dados: " + e.getMessage());
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
