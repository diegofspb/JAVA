package oo.exemploCompra;

public class CompraTeste {
	
	public static void main(String[] args) {
		
		// lembrando que a Classe compra contém 1 atributo + 1 array de itens
        // desta forma 1 cliente (atributo) pode comprar vários itens 
		Compra compra1 = new Compra();
		compra1.cliente = "JOAO PEDRO";
		compra1.itens.add(new Item("Caneta", 20, 7.45));
		compra1.itens.add(new Item("Borracha", 12, 3.89));
		compra1.itens.add(new Item("Caderno", 3, 18.79));
		
		System.out.println(compra1.itens.size());
		System.out.println(compra1.obterValorTotal());
	}
}
