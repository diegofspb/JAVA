package teste.umPraMuitos;

import Modelo.umParaMuitos.ItemPedido;
import Modelo.umParaMuitos.Pedido;
import infra.DAO;

public class ObterPedido {
    public static void main(String[] args) {
        DAO<Pedido> dao = new DAO<>(Pedido.class);
        Pedido pedido = dao.obterPorId(1L);

        for (ItemPedido item: pedido.getItens()){
            System.out.println("Produto: " + item.getProduto().getNome() + " Quantidade: " + item.getQuantidade());
        }
        dao.fechar();
    }
}
