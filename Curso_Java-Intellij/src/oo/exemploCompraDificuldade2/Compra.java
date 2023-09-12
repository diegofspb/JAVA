package oo.exemploCompraDificuldade2;

import java.util.ArrayList;

public class Compra {

    ArrayList<Item> itens = new ArrayList<>();

    public double obterValorTotal(){
        double total = 0;
        for(Item item: itens){
            total += item.qtd * item.produto.preco;
        }
        return total;
    }
}
