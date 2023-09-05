package colecoes;

import java.util.ArrayList;

public class Lista {	
	/*
	 * Lista: o primeiro que entrou é o ultimo a sair
	 *  - Pode ser Heterogêneo;
	 *  - Pode ser Homogêneo;
	 *  - aceita duplicados;
	 *  - é ordenado;
	 *  - é indexado;
	 * */

	public static void main(String[] args) {
		ArrayList<Usuario> lista = new ArrayList<Usuario>(); // utilizando a classe usuário 
		
		Usuario u1 = new Usuario("Ana");
		
		lista.add(new Usuario("carlos"));
		lista.add(new Usuario("Lia"));
		lista.add(new Usuario("Bia"));
		lista.add(new Usuario("Manu"));
		
		for(Usuario u: lista) {
			System.out.println(u.nome);
		}
		
		System.out.println("Exibindo atraves do indice 3 = "+ lista.get(3).nome);
	}
}
