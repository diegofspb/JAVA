package oo.desafio;

import java.util.ArrayList;
import java.util.List;

public class Compra {
	
		// Idêntico ao que aconteceu com a classe Cliente
		// relação de um para muitos, ou seja
		// uma compra pode conter varios itens
		// como são varios itens então a variável 'itens' aqui será do tipo lista/array
	List<Item> itens = new ArrayList<Item>();
	
	
	void adicionarItem(String nome, double preco, int quantidade) {
		var produto = new Produto(nome, preco);
		this.itens.add(new Item(produto, quantidade));
	}	
	void adicionarItem(Produto p, int quantidade) {
		this.itens.add(new Item(p, quantidade));
	}	
	double obterValorTotal() {
		double total = 0;
		// usando foreach 
		for(Item item: itens) {
			total += item.quantidade * item.produto.preco;
		}
		return total;
	}
}
