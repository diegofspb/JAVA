package lambdas;

import java.util.function.UnaryOperator;

public class OperadorUnario {

	/*  - é uma interface da biblioteca Java;
	    - o tipo de entrada é o mesmo do retorno;
	    - é usado para representar uma operação que recebe um único argumento do mesmo tipo e retorna um resultado do mesmo tipo;
	    - herda o método .apply() de Function. O método .apply() permite a entrada de um valor para executar o UnaryOperator.
	 */
	
	public static void main(String[] args) {
		
		UnaryOperator<Integer> maisDois = n -> n+2;
		UnaryOperator<Integer> vezesDois = n -> n*2;
		UnaryOperator<Integer> aoQuadrado = n -> n*n;
		
		int resultado1 = maisDois.andThen(vezesDois).andThen(aoQuadrado).apply(0);		
		System.out.println(resultado1);
		// .andThen ele sai executando no sentido da esquerda pra direita, ou seja, sequencia normal
		int resultado2 = aoQuadrado.compose(vezesDois).compose(maisDois).apply(0);
		// .apply() serve para passar o valor inical para função ser executada
		System.out.println(resultado2);
		//.compose executa da direita para esquerda
	}
}
