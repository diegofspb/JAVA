package lambdas;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class OperadorBinario {
	
	public static void main(String[] args) {		
	// Operador Binário recebe 2 valores 
	// (n1, n2) ficou entre parênteses, porque quando se utiliza apenas 1 variável não precisa(), porém acima de 1 tem que usar
		
		BinaryOperator<Double> media = (n1, n2) -> (n1 + n2) / 2;
		System.out.println(media.apply(9.8, 5.7));
	// BiFunction<T, U, R>   sendo que T = tipo do primeiro valor, U = tipo do segundo valor e R = resultado disso		
		BiFunction<Double, Double, String> resultado = (n1,n2) -> ( n1 + n2 ) / 2 >= 8 ? "Aprovado": "Reprovado";
		
		System.out.println(resultado.apply(9.7, 5.1));
		// lembre, Function recebe um valor numérico e devolve uma String
		// .andThen() concatena funções, ou seja, composição de funções
		// media.andThen(conceito) tem que ser entendido assim: a função 'media' é executada primeiro e seu valor
		// será a entrada da função conceito
		Function<Double, String> conceito = m -> m >= 7 ? "Aprovado": "Reprovado";
		System.out.println(media.andThen(conceito).apply(9.7, 5.1));
	}
}
