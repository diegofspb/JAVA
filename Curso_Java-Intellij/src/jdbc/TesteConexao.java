package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {

    //existem casos em que você é obrigado a tratar 'exceção' conforme visto na aula de tratamento de erros, ao utilizar a interface Connection
    // o java já mostrou erro obrigando o tratamento da execação, porém você pode escolher entre tratar utilizando o try/catch
    // ou então botar frente, ou seja, em outro momento será tratada, e para iso basta colocar na classe pai o 'throws SQLException'
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost";
        String usuario = "root";
        String senha = "admin";

        Connection conexao = DriverManager.getConnection(url, usuario, senha);

        System.out.println("Conexão efetuada com sucesso!");
        conexao.close();
    }
}
