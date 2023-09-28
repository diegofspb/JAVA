package jdbc_treinamento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {
    public static void main(String[] args) throws SQLException {

        String sql = "CREATE DATABASE curso_java";

        Connection conexao = Conexao.getConexao();

        Statement stmt = conexao.createStatement();
        stmt.execute(sql);

        System.out.println("Banco de dados criado com sucesso!");

    }
}
