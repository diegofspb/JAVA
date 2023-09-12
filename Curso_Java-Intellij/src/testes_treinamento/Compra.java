package testes_treinamento;

public class Compra {

    public static void main(String[] args) {

        Carrinho novoCarrinho = new Carrinho();

        novoCarrinho.itens.add(new Produto("bola", 2, 3.4));
        novoCarrinho.itens.add(new Produto("lapis", 5, 1.5));
        novoCarrinho.itens.add(new Produto("papel", 1, 8.0));

        System.out.println(novoCarrinho.total());
    }

}
