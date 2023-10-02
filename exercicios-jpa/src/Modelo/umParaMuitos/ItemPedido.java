package Modelo.umParaMuitos;
import Modelo.basico.Produto;

import javax.persistence.*;

@Entity
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne // 'um ou vários' 'ItemPedido' associados a apenas um 'pedido'.
    private Pedido pedido; // será criado na tabela 'itempedido' a coluna 'pedido_id'
    @ManyToOne // 'um ou vários' 'ItemPedido' associados a apenas um 'produto'.
    private Produto produto; // será criado na tabela 'itempedido' a coluna 'produto_id'
    @Column(nullable = false)
    private int quantidade;
    @Column(nullable = false)
    private Double preco;

    public ItemPedido() {
    }

    public ItemPedido(Pedido pedido, Produto produto, int quantidade) {
        this.setPedido(pedido);
        this.setProduto(produto);
        this.setQuantidade(quantidade);
        // this.preco = preco; foi retirado, pois no método setProduto foi incluido um código para adicionar também o preço, veja la
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        if (produto!= null && this.preco == null){ // se o produto não for null e ainda não tiver setado o preço, ou seja, se ainda o preço = vazio, então seta o preço
            this.setPreco(produto.getPreco());
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
