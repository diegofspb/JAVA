package oo.composicao;

import java.util.ArrayList;

public class Compra {
	
	// falando de ATRIBUTOS a compra conterá CLIENTES + ITENS
	String cliente;
	//relação 1 para n:
	ArrayList<Item> itens = new ArrayList<Item>(); //esse array só conterá 'objetos'  do tipo Item
	// a ideia é ter várias classes interagindo entre si
	
	//A classe compra também contém um MÉTODO para calculo da compra
	
	double obterValorTotal() {
		double total = 0;
		
		for(Item item: itens) {
			total += item.quantidade * item.preco;
		}
		return total;
	}
}
