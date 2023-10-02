package Modelo.umParaMuitos;
import Modelo.basico.Produto;

import javax.persistence.*;

@Entity
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne // 'um ou vários' 'ItemPedido' associados a apenas um 'pedido', ou seja, várias instâncias de 'ItemPedido' podem se referir à mesma instância de 'pedido'
    private Pedido pedido; // será criado na tabela 'itempedido' a coluna 'pedido_id'
    @ManyToOne(fetch = FetchType.EAGER) // @ManyToOne significa 'um ou vários' 'ItemPedido' associados ao mesmo 'produto'
    private Produto produto; // será criado na tabela 'itempedido' a coluna 'produto_id'
    // tanto 'produto' quanto 'pedido' existem apenas 1 em relação ao item do pedido, então quando vc faz uma consulta em ItemPedido, por padrão ele
    // executa uma consulta tipo EAGER (consulta tudo), já se fosse produto ou pedido fossem vários, então deveria ser uma consulta 'lazy'(tardia)
    // vi o exemplo de quando vc executa uma consulta tipo EAGER ele trás todos os dados da tabela pesquisada + os dados das tabelas que se relacionam com
    // aquele registro, porém é possível que esta consulta traga uma quantidade grande de dados e trave ou deixe o sistema lento, por isso motivo
    // é indicado usar a consulta do lado 'one' ser EAGLE, porém se o lado da consulta for Many então o ideal é 'lazy'. Este lazy não carregará
    // tudo, apenas o que for o principal e para carregar os dados das tabelas que estão se relacionando então terá que fazer uma subconsulta para pegar estes dados
    // um exemplo aqui foi a lista de itens que é uma relaçao OneToMany
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
