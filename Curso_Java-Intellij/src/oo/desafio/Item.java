package oo.desafio;

public class Item {
	
	// diferente do que aconteceu com as classes "Cliente" e "Compra"
	// um cliente pode fazer várias compras e uma compra pode conter vários produtos
	// porém um item equivale a um produto, ou seja, de 1 para 1
	
	Produto produto;
	int quantidade;
	
	Item(Produto produto, int quantidade){
		this.produto = produto;
		this.quantidade = quantidade;
	}
}
