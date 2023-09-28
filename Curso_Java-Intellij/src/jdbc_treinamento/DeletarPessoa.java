package jdbc_treinamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeletarPessoa {
    public static void main(String[] args) throws SQLException {
        Connection conexao = Conexao.getConexao();

        String deletar = "DELETE FROM pessoas WHERE id = ?";
        String exibir_pessoas = "SELECT * FROM pessoas";

        Statement stmt = conexao.createStatement();
        ResultSet lista_pessoas = stmt.executeQuery(exibir_pessoas);

        List<Pessoa> pessoas = new ArrayList<>();

        while (lista_pessoas.next()){
            pessoas.add(
                    new Pessoa(
                            lista_pessoas.getString("nome"),
                            lista_pessoas.getInt("id")
                    )
            );
        }

        System.out.println("Pessoas cadastradas: ");
        pessoas.stream().forEach(System.out::println);
        stmt.close();

        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe o ID para deletar a pessoa: ");
        int id_deletar = entrada.nextInt();

        PreparedStatement stmt_deletar = conexao.prepareStatement(deletar);
        stmt_deletar.setInt(1,id_deletar);
        stmt_deletar.execute();
        stmt_deletar.close();

        System.out.println("Pessoa deletada com sucesso!");
    }
}
