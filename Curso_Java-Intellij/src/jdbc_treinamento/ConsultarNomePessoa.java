package jdbc_treinamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultarNomePessoa {
    public static void main(String[] args) throws SQLException {

        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe um nome ou letra para pesquisar: ");
        String resposta = entrada.next();

        String sql = "SELECT * FROM pessoas WHERE nome LIKE (?)";

        Connection conexao = Conexao.getConexao();

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1,"%" + resposta + "%");
        ResultSet resultado = stmt.executeQuery();

        List<Pessoa> pessoas = new ArrayList<>();

        while (resultado.next()){
            String nome = resultado.getString("nome");
            int id = resultado.getInt("id");
            pessoas.add( new Pessoa(nome, id));
        }

        pessoas.stream().forEach(System.out::println);

        conexao.close();
        entrada.close();
    }
}
