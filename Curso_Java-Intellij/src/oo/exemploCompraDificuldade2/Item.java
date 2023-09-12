package oo.exemploCompraDificuldade2;

public class Item {
    int qtd;
    Produto produto;

    Item(int qtd, Produto produto){
        this.qtd = qtd;
        this.produto = produto;
    }

    public String toString(){
        return "Produto: " + produto.nome + "\nPreço: " + produto.preco;
    }
}
