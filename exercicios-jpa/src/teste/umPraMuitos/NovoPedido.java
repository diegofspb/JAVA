package teste.umPraMuitos;

import Modelo.basico.Produto;
import Modelo.umParaMuitos.ItemPedido;
import Modelo.umParaMuitos.Pedido;
import infra.DAO;

public class NovoPedido {
    public static void main(String[] args) {
        DAO<Object> dao = new DAO<>();

        Produto produto = new Produto("Fogao", 3289.99);
        Pedido pedido = new Pedido(); // aqui seria incluido a data atual, porém foi colocado que no construtor de pedido ele já faz isso caso aqui vá sem parâmetro
        ItemPedido item = new ItemPedido(pedido, produto, 10); // construtor: ItemPedido(Pedido pedido, Produto produto, int quantidade)
        /*
            o método construtor de ItemPedido aceita 'pedido', 'produto' e quantidade;
            'pedido' é em formato de chave primária, porém como estamos utilizando ORM, fica implícito
                na classe 'ItemPedido' cria-se o atributo 'pedido' e nele coloca-se @ManyToOne informando que são 'vários itens de pedido' para '1 pedido'
            'produto' é do mesmo jeito que 'pedido' explicado acima.
        */
        dao.abrirT()
                .incluir(produto)
                .incluir(pedido)
                .incluir(item)
                .fecharT()
                .fechar();
    }
}
