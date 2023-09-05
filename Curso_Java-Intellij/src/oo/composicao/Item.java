package oo.composicao;

public class Item {
	
	//os dados que compõem um item é nome + qtd + preço

	String nome;
	int quantidade;
	double preco;
	
	Item(String nome, int quantidade, double preco){
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
	}
}
