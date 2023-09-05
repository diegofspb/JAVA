package oo.desafio;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	String nome;
	
	Cliente(String nome){
		this.nome = nome;
	}
	
	void adicionarCompra(Compra compra) {
		this.compras.add(compra);
	}
	
	// O plano inicial é criar uma relação entre as classes Cliente e Compra
	// relação de um para muitos, ou seja
	// um cliente pode fazer varias compras
	// como são várias compras então a variável compras aqui será do tipo lista/array
	List<Compra> compras = new ArrayList<Compra>();
	
	double obterValorTotal() {
		
		double total = 0;
		
		for(Compra compra : compras) {
			total += compra.obterValorTotal();
			// apesar da função obterValorTotal estar com o mesmo nome da função encontrada
			// na classe Compra, quando vc coloca o nome_da_clase.nome_da_funcao então 
			// o que será executada é a função que está dentro da classe antes do ponto final
			// entendendo melhor agora, cada compra já está vindo de uma por uma somada através
			// da função obterValorTotal
		}
		return total;
	}

}
