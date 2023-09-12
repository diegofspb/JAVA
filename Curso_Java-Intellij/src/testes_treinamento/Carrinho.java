package testes_treinamento;

import oo.exemploCompra.Item;

import java.util.ArrayList;

public class Carrinho {

    ArrayList<Produto> itens = new ArrayList<Produto>();

    double total(){
        double somando = 0;
        for(Produto item: itens){
            somando += item.qtd * item.valor;
        }
        return somando;
    }

}
