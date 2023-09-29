package teste.basico;

import Modelo.basico.Produto;
import infra.DAO;

public class NovoProduto {
    public static void main(String[] args) {

        DAO<Produto> dao = new DAO<>(Produto.class);
            // ENTÃO o 'dao' vai receber 'Produto.class'

        Produto produto = new Produto("Monitor 23", 887.58);

//      dao.abrirT().incluir(produto).fecharT().fechar();
        dao.incluirAtomico(produto).fechar();
    }
}
