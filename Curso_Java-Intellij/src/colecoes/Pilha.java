package colecoes;

import java.util.ArrayDeque;
import java.util.Deque;

public class Pilha {

	public static void main(String[] args) {
		/*
		 * Pilha: o ultimo que entrou é o primeiro a sair
		 * */
		
		Deque<String> livros = new ArrayDeque<String>();
		
		livros.add("livro 1");
		// o push também adiciona, porém pode gerar problema caso não tenha espaço
		livros.push("dom quixote"); 
		livros.push("o hobbit");
		
		System.out.println(livros.peek()); //vai exibir o hobbit, pois o ultimo é o primeiro
	}
}
