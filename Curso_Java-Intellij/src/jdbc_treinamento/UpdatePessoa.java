package jdbc_treinamento;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdatePessoa {
    public static void main(String[] args) throws SQLException {
        Connection conexao = Conexao.getConexao();

        String sql = "UPDATE pessoas SET nome = 'Novo nome de pessoa' WHERE id = 1 ";

        Statement stmt = conexao.createStatement();
        stmt.execute(sql);

        System.out.println("Nome atualizado com sucesso!");
        stmt.close();
        conexao.close();

    }
}
