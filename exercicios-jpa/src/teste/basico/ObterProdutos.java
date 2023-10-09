package teste.basico;

import Modelo.basico.Produto;
import infra.DAO;

import java.util.ArrayList;
import java.util.List;

public class ObterProdutos {
    public static void main(String[] args) {
        DAO<Produto> dao = new DAO<>(Produto.class);
        List<Produto> produtos = new ArrayList<>(dao.obterTodos(2,1));
        for (Produto produto: produtos) {
            System.out.println(produto.getNome());
        }
    }
}
