package jdbc_treinamento;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaPessoa {
    public static void main(String[] args) throws SQLException {
        String sql = "CREATE TABLE pessoas(" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "nome VARCHAR(200) NOT NULL" +
                ")";

        Connection conexao = Conexao.getConexao();
        Statement stmt = conexao.createStatement();

        stmt.execute(sql);
    }
}
