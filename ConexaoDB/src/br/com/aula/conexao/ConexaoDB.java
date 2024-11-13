package br.com.aula.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    public static Connection conectar() {
        Connection conexao = null;
        try {
            String url = "jdbc:mysql://localhost:3306/seu_banco_de_dados"; // Update with your database URL
            String usuario = "seu_usuario"; // Update with your username
            String senha = "sua_senha"; // Update with your password
            
            conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return conexao;
    }
}
