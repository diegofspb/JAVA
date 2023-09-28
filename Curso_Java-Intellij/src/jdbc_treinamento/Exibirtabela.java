package jdbc_treinamento;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Exibirtabela {
    public static void main(String[] args) throws SQLException {
        Connection conexao = Conexao.getConexao();

        String sql = "SELECT * FROM pessoas";

        Statement stmt = conexao.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);

        List<Pessoa> pessoas = new ArrayList<>();

        while (resultado.next()){
            int id = resultado.getInt("id");
            String nome = resultado.getString("nome");
            pessoas.add(new Pessoa(nome, id));
        }

        pessoas.stream().forEach(n -> System.out.println("Nome: " + n.getNome() + "\n Id: " + n.id));
    }
}
