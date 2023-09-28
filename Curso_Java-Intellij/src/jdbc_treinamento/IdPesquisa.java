package jdbc_treinamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class IdPesquisa {
    public static void main(String[] args) throws SQLException {

        Connection conexao = Conexao.getConexao();

        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe uma ID para saber qual nome está vinculado: ");
        int id_informado = entrada.nextInt();

        String pesquisa = "SELECT nome, id FROM pessoas WHERE id = ?";

        PreparedStatement stmt = conexao.prepareStatement(pesquisa);
        stmt.setInt(1,id_informado);
        ResultSet resultado_pesquisa = stmt.executeQuery();

        if (resultado_pesquisa.next()){

            Pessoa pessoa = new Pessoa(resultado_pesquisa.getString("nome"), resultado_pesquisa.getInt("id"));

            System.out.println("O nome que está no ID: " + pessoa.getId() + " é = " + pessoa.getNome());

            System.out.println("Informe o nome nome para substituir: ");
            entrada.nextLine();
            String novo_nome = entrada.nextLine();

            String update = "UPDATE pessoas SET nome = ? WHERE id = ?";

            stmt.close();
            stmt = conexao.prepareStatement(update);
            stmt.setString(1,novo_nome);
            stmt.setInt(2,id_informado);
            stmt.execute();

            System.out.println("Nome atualizado com sucesso!");
            stmt.close();

        }
    }
}
