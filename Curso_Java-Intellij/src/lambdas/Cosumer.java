package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
public class Cosumer {  // O Consumer recebe apenas 1 parâmetro e não retorna nada, ou seja, VOID
	public static void main(String[] args) {		
		Consumer<Produto> imprimir = p -> System.out.println(p.nome + "!!!");		
		Produto p1 = new Produto("Caneta", 12.34, 0.09);
		imprimir.accept(p1);	//.accept executa o método Consumer	
		/*
		 Texto ChatGpt:		 
		 	A interface funcional Consumer<T> possui um único método abstrato chamado accept(T t). 
		 	O método accept() é projetado para aceitar um argumento do tipo genérico T (nesse caso, Produto) e realizar 
		 	alguma operação com esse argumento.		  
		 */
		Produto p2 = new Produto("Notebook", 2987.99, 0.25);
		Produto p3 = new Produto("Caderno", 19.90, 0.05);
		Produto p4 = new Produto("Borracha", 7.8, 0.18);
		Produto p5 = new Produto("Lapis", 4.39, 0.19);		
		List<Produto> produtos = Arrays.asList(p1, p2, p3, p4, p5);		
		produtos.forEach(imprimir);
		produtos.forEach(p -> System.out.println(p.preco));	
		produtos.forEach(System.out::println); // sem ter criado a função toString ele imprimiu: lambdas.Produto@4a574795
		//em outro exemplo o System.out::println funcionou normal, porém ele estava imprimindo apenas uma lista de strings
		// aqui é uma lista de objetos então foi necessário criar a função toString
}
}
