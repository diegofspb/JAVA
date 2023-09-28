package jdbc_treinamento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection getConexao(){
        try {
            String user = "root";
            String senha = "admin";
            String url = "jdbc:mysql://localhost/curso_java";

            return DriverManager.getConnection(url, user, senha);

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
