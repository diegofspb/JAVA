package oo.desafio;

public class Sistema {

	public static void main(String[] args) {
		
		/*
		 * entendendo as classes:
		 * 
		 * Produto = nome + preço
		 * Item = produto + quantidade
		 * compra => (Item = quantidade * preço) + (Item = quantidade * preço) ...
		 * */
		
		Compra compra1 = new Compra();
		compra1.adicionarItem("Caneta", 9.67, 100); //forma 1 ou pode ser
		compra1.adicionarItem(new Produto("Notebook", 1897.88), 2); // forma 2
		
		Compra compra2 = new Compra();
		compra2.adicionarItem("Caderno", 10, 10);
		compra2.adicionarItem(new Produto("Impressora", 998.90), 1);
		
		Cliente cliente = new Cliente("Maria Julia");
		// existem 2 formas, porém a primeira é a mais indicada e foi criada esta função
		// na classe cliente
		cliente.adicionarCompra(compra1);
		cliente.compras.add(compra2);
		
		System.out.println(cliente.obterValorTotal());
		
	}
}
