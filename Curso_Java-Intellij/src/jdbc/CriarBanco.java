package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost";
        String usuario = "root";
        String senha = "admin";

        Connection conexao = DriverManager.getConnection(url, usuario, senha); //Conexão com o banco de dados

        Statement stmt = conexao.createStatement(); //Statement é usado para enviar instruções SQL para o banco de dados.
        stmt.execute("CREATE DATABASE curso_java");

        System.out.println("Banco criado com sucesso! ");

        System.out.println("Conexão efetuada com sucesso!");
        conexao.close();
    }
}
